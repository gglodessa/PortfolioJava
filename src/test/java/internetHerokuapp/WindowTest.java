package internetHerokuapp;

import UIObjects.data.Url;
import UIObjects.pages.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WindowTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        agent.openUrl(Url.INTERNET_HEROKU_APP_URL + "windows");
    }

    @Test
    public void testSwitchToWindow() {
        String initialWindow = agent.getDriver().getWindowHandle();

        agent.onHerokuAppPage().clickHereOnWindowPage.click();

        Assert.assertEquals(agent.getDriver().getWindowHandles().size(), 2, "Unexpected number of windows");

        String newWindowHandle = agent.getDriver().getWindowHandles().stream()
                .filter(handle -> !handle.equals(initialWindow))
                .findFirst()
                .orElseThrow(() -> new AssertionError("New windows handle was not added"));

        agent.getDriver().switchTo().window(newWindowHandle);
        Assert.assertEquals(agent.getDriver().getTitle(), "New Window", "New Window has invalid title");

        agent.getDriver().switchTo().window(initialWindow);
        Assert.assertEquals(agent.getDriver().getTitle(), "The Internet", "Switching tab haven't happened");
    }
}
