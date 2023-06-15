package seleniumAdvanced;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void testIFrame() {
        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = driver.findElement(By.id("tinymce"));
        assertEquals(editor.getText(), "Your content goes here.", "Unexpected editor text");
    }
}