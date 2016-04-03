package de.flux.playground.deckcompare.fileupload;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import de.flux.playground.deckcompare.Deckcompare;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Deckcompare.class)
@WebAppConfiguration
public class FileUploadControllerIT {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void uploadControllerIsReachableViaGet() throws Exception {
        mvc.perform(get("/upload")).andExpect(status().isOk());
    }

}
