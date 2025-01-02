package demoRealWorld;

import UIObjects.data.Url;
import UIObjects.pages.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptKey;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExecuteJavaScriptTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        agent.openUrl(Url.DEMO_REAL_WORLD_URL);
    }

    @Test
    public void testPinScenario() throws InterruptedException {
        ScriptKey scriptKey = ((JavascriptExecutor) agent.getDriver()).pin("return new Date().getTime()");
        Long timeBefore = (Long) ((JavascriptExecutor) agent.getDriver()).executeScript(scriptKey);

        Thread.sleep(5000);

        Long timeAfter = (Long) ((JavascriptExecutor) agent.getDriver()).executeScript(scriptKey);

        Assert.assertTrue((timeAfter - timeBefore) > 5000,
                "The time difference is less than 5 seconds, but it should be greater.");
    }
}