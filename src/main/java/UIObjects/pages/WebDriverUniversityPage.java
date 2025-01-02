package UIObjects.pages;

import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebDriverUniversityPage extends BaseComponent {

    public WebDriverUniversityPage(WebDriver driver) {
        super(driver);
    }

    @Name("Draggable Element")
    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement draggableElement;

    @Name("Droppable Element")
    @FindBy(xpath = "//div[@id='droppable']")
    public WebElement droppableElement;

    @Name("Double-click Element")
    @FindBy(xpath = "//div[@id='double-click']")
    public WebElement doubleClickElement;

    @Name("Drop down first element")
    @FindBy(css = ".dropdown:nth-of-type(1)")
    public WebElement dropDownFirstElement;

    @Name("Text in drop down first element")
    @FindBy(xpath = "//a[text()='Link 1']")
    public WebElement textInDropDownFirstElement;

    @Name("Text in drop down first element")
    @FindBy(id = "button4")
    public WebElement alertButton;
}
