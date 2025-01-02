package UIObjects.pages;

import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UiTestingPlaygroundPage extends BaseComponent {

    public UiTestingPlaygroundPage(WebDriver driver) {
        super(driver);
    }

    @Name("Ajax button")
    @FindBy(id = "ajaxButton")
    public WebElement ajaxButton;

    @Name("Ajax content")
    @FindBy(css = "#content > p")
    public WebElement ajaxContent;

    @Name("Start button")
    @FindBy(id = "startButton")
    public WebElement startButton;

    @Name("Progress bar")
    @FindBy(id = "progressBar")
    public WebElement progressBar;

    @Name("Upload file")
    @FindBy(id = "myFile")
    public WebElement uploadFileButton;

    @Name("Submit file")
    @FindBy(id = "submit-button")
    public WebElement submitFileButton;
}
