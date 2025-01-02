package internetHerokuapp;

import UIObjects.data.Url;
import UIObjects.pages.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        agent.openUrl(Url.INTERNET_HEROKU_APP_URL + "iframe");
    }

    @Test
    public void testIFrame() {
        agent.getDriver().switchTo().frame("mce_0_ifr");
        Assert.assertEquals(agent.onHerokuAppPage()
                .editorBodyInTinyMCEOnFramesPage.getText(),
                "Your content goes here.", "Unexpected editor text");
    }
}