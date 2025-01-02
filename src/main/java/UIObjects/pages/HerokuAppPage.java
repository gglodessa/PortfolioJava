package UIObjects.pages;

import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static UIObjects.pages.BaseTest.logger;

public class HerokuAppPage extends BaseComponent {
    public HerokuAppPage(WebDriver driver) {
        super(driver);
    }

    @Name("Header on Welcome page")
    @FindBy(xpath = "//h1[@class='heading']")
    public WebElement headerWelcomePage;

    @Name("Add/Remove Test link")
    @FindBy(xpath = "//a[@href='/add_remove_elements/']")
    public WebElement addRemoveTest;

    @Name("Download Test link")
    @FindBy(xpath = "//a[@href='/download']")
    public WebElement downloadTest;

    @Name("Upload Test link")
    @FindBy(xpath = "//a[@href='/upload']")
    public WebElement uploadTest;

    @Name("Checkboxes Test link")
    @FindBy(xpath = "//a[@href='/checkboxes']")
    public WebElement checkboxesTest;

    @Name("Frames Test link")
    @FindBy(xpath = "//a[@href='/frames']")
    public WebElement framesTest;

    @Name("Title on Add/Remove Elements page")
    @FindBy(css = "body h3")
    public WebElement titleOnAddElementPage;

    @Name("Add Element button on Add/Remove Elements page")
    @FindBy(xpath = "//button[text()='Add Element']")
    public WebElement addElementButtonOnAddElementPage;

    @Name("Choose File input on Upload page")
    @FindBy(xpath = "//input[@id='file-upload']")
    public WebElement chooseFileOnUploadPage;

    @Name("Submit button on Upload page")
    @FindBy(xpath = "//input[@id='file-submit']")
    public WebElement submitButtonOnUploadPage;

    @Name("Success Banner on Upload page")
    @FindBy(xpath = "//div[@class='example']")
    public WebElement successBannerOnUploadPage;

    @Name("Success Banner on Frame page")
    @FindBy(xpath = "//a[@href='/iframe']")
    public WebElement iframeOnFramesPage;

    @Name("Iframe on Add/Remove Elements page")
    @FindBy(xpath = baseDeleteButtonOnAddElementPage)
    private List<WebElement> deleteButtonsOnAddElementPage;

    @Name("Editor body in TinyMCE")
    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement editorBodyInTinyMCEOnFramesPage;

    @Name("Link text")
    @FindBy(linkText = "Click Here']")
    public WebElement clickHereOnWindowPage;

    private final String baseDeleteButtonOnAddElementPage = "//button[@class='added-manually']";
    private final String baseDownloadButtonOnDownloadPage = "//a[@href='download/";
    private final String checkBoxOnCheckBoxPage = "//*[@id='checkboxes']/input";

    public HerokuAppPage selectAndCheckCheckbox(int index, boolean isSelected) {
        logger.info("Selecting checkbox for item at index: " + index);
        WebElement checkbox = driver.findElement(By.xpath(String.format(checkBoxOnCheckBoxPage + "[" + index + "]")));
        checkbox.click();
        Assert.assertEquals(checkbox.isSelected(), isSelected, "Checkbox should be " + (isSelected ? "selected" : "not selected"));
        return this;
    }

    public HerokuAppPage clickDeleteButtonsOnAddElementPage(int itemName) {
        logger.info("Click delete button for item with index: " + itemName);
        WebElement item = driver.findElement(By.xpath(String.format(baseDeleteButtonOnAddElementPage + "[" + itemName + "]")));
        item.click();
        return this;
    }

    public HerokuAppPage checkDeleteButtonsCountOnAddElementPage(int count) {
        logger.info("Checking delete button count on Add Element page. Expected: " + count);
        Assert.assertEquals(deleteButtonsOnAddElementPage.size(), count, "Should be Find " + count + "elements");
        return this;
    }

    public HerokuAppPage downloadFileOnDownloadPage(String fileName) {
        logger.info("Download the file with name: " + fileName);
        WebElement name = driver.findElement(By.xpath(baseDownloadButtonOnDownloadPage + fileName + "']"));
        name.click();
        return this;
    }
}
