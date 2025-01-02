package webdriveruniversity;

import UIObjects.data.Url;
import UIObjects.pages.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileUploadTest extends BaseTest {

    private String filePath;

    @BeforeMethod
    public void setUp() throws IOException {
        agent.openUrl(Url.WEB_DRIVER_UNIVERSITY_URL + "File-Upload/index.html");
        filePath = prepareFile();
    }

    @Test
    public void testFileUpload() {
        agent.onUiTestingPlaygroundPage().uploadFileButton.sendKeys(filePath);
        agent.onUiTestingPlaygroundPage().submitFileButton.click();

        Assert.assertEquals(agent.getDriver().switchTo().alert().getText(), "Your file has now been uploaded!",
                "File was not uploaded!");
    }

    private String prepareFile() throws IOException {
        File file = File.createTempFile("testFile", ".jpg");
        file.deleteOnExit();
        Files.write(file.toPath(), "Test file".getBytes(StandardCharsets.UTF_8));
        return file.getAbsolutePath();
    }
}