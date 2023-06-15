package regression;

import UIObjects.pages.HerokuAppPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumAdvanced.BaseTest;

import java.util.List;

public class addedPageObjectHerokuAppTest extends BaseTest {
    @Test
    public void AddAndDeleteElements() {
        HerokuAppPage herokuAppPage = new HerokuAppPage(driver);

        logger.info("1. Open page and full screen mode");
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        logger.info("2.Check that we are on the required page Go to Forgot Add/Remove Elements");
        herokuAppPage.addRemoveTest.click();

        logger.info("3.Сheck that we are on the required page and click 5 times on add element");
        Assert.assertEquals(herokuAppPage.titleOnPage.getText(), "Add/Remove Elements",
                "Should be opened Add/Remove Elements");
        for (int i = 0; i < 5; i++) {
            herokuAppPage.addElementButton.click();
        }

        logger.info("4. Make sure 5 items appear");
        List<WebElement> fiveElements = driver.findElements(By.className("added-manually"));
        Assert.assertEquals(fiveElements.size(), 5, "Should be Find five elements");


        logger.info("5. Сlick on two elements and make sure there are 3 left");
        fiveElements.get(3).click();
        fiveElements.get(2).click();
        List<WebElement> ThreeElements = driver.findElements(By.className("added-manually"));
        Assert.assertEquals(ThreeElements.size(), 3, "Should be left 3 elements");
    }
}
