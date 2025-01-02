package google;

import UIObjects.data.Url;
import org.testng.Assert;
import org.testng.annotations.Test;
import UIObjects.pages.BaseTest;

public class CheckTitleTest extends BaseTest {

    @Test
    public void lessonsNumberNine() {
        agent.openUrl(Url.GOOGLE_URL);
        changeWindowSize(500, 500);
        Assert.assertEquals(agent.getDriver().getTitle(), "Google", "good job");
    }
}
