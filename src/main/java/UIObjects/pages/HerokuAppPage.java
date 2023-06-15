package UIObjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HerokuAppPage extends BaseComponent {
    public HerokuAppPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/add_remove_elements/']")
    public WebElement addRemoveTest;

    @FindBy(css = "body h3")
    public WebElement titleOnPage;

    @FindBy(xpath = "//button[text()='Add Element']")
    public WebElement addElementButton;
}
