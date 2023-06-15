package seleniumAdvanced;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumAdvanced.BaseTest;

public class FileUploadTest extends BaseTest {

    private String filePath;

    @BeforeMethod
    public void setUp() throws IOException {
        driver.get("http://webdriveruniversity.com/File-Upload/index.html");
        filePath = prepareFile();
    }

    @Test
    public void testFileUpload() {
        driver.findElement(By.id("myFile")).sendKeys(filePath);
        driver.findElement(By.id("submit-button")).click();

        assertEquals(driver.switchTo().alert().getText(), "Your file has now been uploaded!",
                "File was not uploaded!");
    }

    private String prepareFile() throws IOException {
        File file = File.createTempFile("testFile", ".jpg");
        file.deleteOnExit();
        Files.write(file.toPath(), "Test file".getBytes(StandardCharsets.UTF_8));
        return file.getAbsolutePath();
    }
}