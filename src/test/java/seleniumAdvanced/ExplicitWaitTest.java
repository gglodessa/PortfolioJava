package seleniumAdvanced;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import seleniumAdvanced.BaseTest;

public class ExplicitWaitTest extends BaseTest {

    @Test
    void testExplicitWait() {
        driver.get("http://uitestingplayground.com/ajax");
        driver.findElement(By.id("ajaxButton")).click();

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("#content > p")));
    }

    @Test
    void testExplicitWaitWithCustomCondition() {
        driver.get("http://uitestingplayground.com/progressbar");
        driver.findElement(By.id("startButton")).click();

        WebElement progressBar = driver.findElement(By.id("progressBar"));

        new FluentWait<WebElement>(progressBar)
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofSeconds(1))
                .withTimeout(Duration.ofSeconds(60))
                .withMessage("Progress haven't become 100% during timeout")
                .until(driver -> {
                    String progress = progressBar.getText();
                    System.out.println(new Date() + " - " + progress);
                    return progress.equals("100%");
                });
    }
}
