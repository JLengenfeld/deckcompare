package de.flux.playground.deckcompare.fileupload;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.springframework.ui.ExtendedModelMap;

public class FileUploadControllerTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private FileUploadController controller;
    private ExtendedModelMap model;

    @Before
    public void setUp() throws Exception {
        controller = new FileUploadController(folder.getRoot().getPath());
        model = new ExtendedModelMap();
    }

    @Test
    public void getRequestsShouldUseUploadForm() throws Exception {
        assertEquals("uploadForm", controller.provideUploadInfo(model));
    }

    @Test
    public void shouldListAllFilesInFolder() throws Exception {
        folder.newFile("firstFile");
        folder.newFile("secondFile");

        controller.provideUploadInfo(model);

        assertTrue("Model does not contain files", model.containsKey("files"));

        @SuppressWarnings("unchecked") // we know that files will be of type List<String>
        final List<String> files = (List<String>) model.get("files");
        assertEquals("Model has wrong number of files", 2, files.size());
        assertTrue("Model does not contain firstFile", files.contains("firstFile"));
        assertTrue("Model does not contain secondFile", files.contains("secondFile"));
    }
}
