package webdriveruniversity;

import UIObjects.data.Url;
import UIObjects.pages.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        agent.openUrl(Url.WEB_DRIVER_UNIVERSITY_URL + "Popup-Alerts/index.html");
    }

    @Test
    public void testAlert() {
        agent.onWebDriverUniversityPage().alertButton.click();
        Assert.assertEquals(agent.getDriver().switchTo().alert().getText(), "Press a button!",
                "Unexpected alert text");

        agent.getDriver().switchTo().alert().accept();
        Assert.assertEquals(agent.getDriver().findElement(By.id("confirm-alert-text")).getText(), "You pressed OK!",
                "Unexpected status text");
    }
}
