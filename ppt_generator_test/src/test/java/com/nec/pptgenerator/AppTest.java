package com.nec.pptgenerator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.io.File;

public class AppTest {
    private App app;

    @Before
    public void setUp() {
        app = new App();
        app.setup();
    }

    @Test
    public void testPPTGenerationAndDownload() {
        // Generate the PPT using the method in App.java
        app.generatePPT();

        // Wait for download
        try {
            Thread.sleep(5000); // Adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the PPT file exists in the download directory
        String downloadDir = System.getProperty("user.home") + "/Downloads/";
        String expectedFileName = "translated_presentation.pptx";
        File downloadedFile = new File(downloadDir + expectedFileName);
        assertTrue("The PPT file should be downloaded", downloadedFile.exists());
    }

    @After
    public void tearDown() {
        app.teardown();
    }
}
