package internetHerokuapp;

import UIObjects.data.Url;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import UIObjects.pages.BaseTest;

public class DownloadUploadImageCheckBoxTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        agent.openUrl(Url.INTERNET_HEROKU_APP_URL);
    }

    @Test
    public void downloadUpload() {
        logger.info("2. Go to File Download");
        agent.onHerokuAppPage().downloadTest.click();

        logger.info("3. Download .png file");
        agent.onHerokuAppPage().downloadFileOnDownloadPage("Selenium_Logo.png");

        logger.info("4. Back to start page");
        agent.getDriver().navigate().back();

        logger.info("5. Check that the start page has opened");
        Assert.assertEquals(agent.onHerokuAppPage()
                .headerWelcomePage.getText(), "Welcome to the-internet", "Should be opened start page");

        logger.info("6. Go to File Uploaded");
        agent.onHerokuAppPage().uploadTest.click();

        logger.info("7. Add downloaded file to Select file");
        agent.onHerokuAppPage()
                .chooseFileOnUploadPage.sendKeys("C:\\Users\\Oleksii\\Downloads\\Selenium_Logo.png");

        logger.info("8. Click Upload");
        agent.onHerokuAppPage().submitButtonOnUploadPage.click();

        logger.info("9. Check if a message is displayed");
        Assert.assertEquals(agent.onHerokuAppPage().successBannerOnUploadPage.getText(), "File Uploaded!\nSelenium_Logo.png",
                "Should be File Uploaded \n Selenium_Logo.png displayed");
    }

    @Test
    public void CheckCheckboxes() {
        logger.info("2. Go to Checkboxes");
        agent.onHerokuAppPage().checkboxesTest.click();

        logger.info("3. Remove Checkboxes 2 and check that Checkboxes 2 is removed");
        agent.onHerokuAppPage().selectAndCheckCheckbox(2, false);

        logger.info("4. Install Checkboxes 1 and check that Checkboxes 1 is installed");
        agent.onHerokuAppPage().selectAndCheckCheckbox(1, true);
    }
}

