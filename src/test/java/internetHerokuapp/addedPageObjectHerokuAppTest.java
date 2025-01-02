package internetHerokuapp;

import UIObjects.data.Url;
import org.testng.Assert;
import org.testng.annotations.Test;
import UIObjects.pages.BaseTest;

public class addedPageObjectHerokuAppTest extends BaseTest {

    @Test
    public void AddAndDeleteElements() {
        logger.info("1. Open page and full screen mode");
        agent.openUrl(Url.INTERNET_HEROKU_APP_URL);

        logger.info("2.Check that we are on the required page Go to Forgot Add/Remove Elements");
        agent.onHerokuAppPage().addRemoveTest.click();

        logger.info("3.Сheck that we are on the required page and click 5 times on add element");
        Assert.assertEquals(agent.onHerokuAppPage().titleOnAddElementPage.getText(), "Add/Remove Elements",
                "Should be opened Add/Remove Elements");
        for (int i = 0; i < 5; i++) {
            agent.onHerokuAppPage().addElementButtonOnAddElementPage.click();
        }

        logger.info("4. Make sure 5 items appear");
        agent.onHerokuAppPage().checkDeleteButtonsCountOnAddElementPage(5);

        logger.info("5. Сlick on two elements and make sure there are 3 left");
        agent.onHerokuAppPage().clickDeleteButtonsOnAddElementPage(1);
        agent.onHerokuAppPage().clickDeleteButtonsOnAddElementPage(2);
        agent.onHerokuAppPage().checkDeleteButtonsCountOnAddElementPage(3);
    }
}
