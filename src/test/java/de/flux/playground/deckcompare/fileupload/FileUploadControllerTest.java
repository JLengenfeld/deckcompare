package de.flux.playground.deckcompare.fileupload;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

public class FileUploadControllerTest {

    @Rule
    public TemporaryFolder uploadFolder = new TemporaryFolder();
    @Rule
    public TemporaryFolder sourceFolder = new TemporaryFolder();

    private FileUploadController controller;
    private ExtendedModelMap model;
    private RedirectAttributes redirectAttributes;

    @Before
    public void setUp() throws Exception {
        controller = new FileUploadController(uploadFolder.getRoot().getPath());
        model = new ExtendedModelMap();
        redirectAttributes = new RedirectAttributesModelMap();
    }

    @Test
    public void getRequestsShouldUseUploadForm() throws Exception {
        assertEquals("uploadForm", controller.provideUploadInfo(model));
    }

    @Test
    public void shouldListAllFilesInFolder() throws Exception {
        uploadFolder.newFile("firstFile");
        uploadFolder.newFile("secondFile");

        controller.provideUploadInfo(model);

        assertTrue("Model does not contain files", model.containsKey("files"));

        @SuppressWarnings("unchecked") // we know that files will be of type List<String>
        final List<String> files = (List<String>) model.get("files");
        assertEquals("Model has wrong number of files", 2, files.size());
        assertTrue("Model does not contain firstFile", files.contains("firstFile"));
        assertTrue("Model does not contain secondFile", files.contains("secondFile"));
    }

    @Test
    public void shouldAddFilestoFolder() throws Exception {
        InputStream stream = FileUploadControllerTest.class.getResourceAsStream("/decks/the-fun-ends-here-shl-jinteki-edition-1st-.o8d");
        MockMultipartFile firstMultipartFile = new MockMultipartFile("firstFile", stream);

        controller.handleFileUpload("firstFile", firstMultipartFile, redirectAttributes);

        assertThat(redirectAttributes.getFlashAttributes().get("message"), is("You successfully uploaded firstFile!"));

        File root = uploadFolder.getRoot();
        File[] listFiles = root.listFiles();
        assertThat(listFiles.length, is(1));
        assertThat(listFiles[0].getName(), is("firstFile"));

    }
}
