package seleniumAdvanced;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
    }

    @Test
    public void testAlert() {
        driver.findElement(By.id("button4")).click();
        assertEquals(driver.switchTo().alert().getText(), "Press a button!",
                "Unexpected alert text");

        driver.switchTo().alert().accept();
        assertEquals(driver.findElement(By.id("confirm-alert-text")).getText(), "You pressed OK!",
                "Unexpected status text");
    }
}
