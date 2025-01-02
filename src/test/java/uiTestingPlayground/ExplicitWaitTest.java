package uiTestingPlayground;

import java.time.Duration;
import java.util.Date;

import UIObjects.data.Url;
import UIObjects.pages.BaseTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class ExplicitWaitTest extends BaseTest {

    @Test
    void testExplicitWait() {
        agent.openUrl(Url.UI_TESTING_PLAYGROUND_URL + "ajax");
        agent.onUiTestingPlaygroundPage().ajaxButton.click();

        waitForElementVisibility(agent.onUiTestingPlaygroundPage().ajaxContent, 20);
    }

    @Test
    void testExplicitWaitWithCustomCondition() {
        agent.openUrl(Url.UI_TESTING_PLAYGROUND_URL + "progressbar");
        agent.onUiTestingPlaygroundPage().startButton.click();

        new FluentWait<>(agent.onUiTestingPlaygroundPage().progressBar)
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofSeconds(1))
                .withTimeout(Duration.ofSeconds(60))
                .withMessage("Progress hasn't reached 100% within the timeout period")
                .until(driver -> {
                    String progress = agent.onUiTestingPlaygroundPage().progressBar.getText();
                    String timestamp = new Date().toString();
                    System.out.println(timestamp + " - " + progress);
                    return "100%".equals(progress);
                });
    }
}
