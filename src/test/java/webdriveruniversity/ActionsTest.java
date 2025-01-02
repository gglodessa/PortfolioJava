package webdriveruniversity;

import UIObjects.data.Url;
import UIObjects.pages.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        agent.openUrl(Url.WEB_DRIVER_UNIVERSITY_URL + "Actions/index.html");
    }

    @Test
    public void testDragAndDrop() {
        new Actions(agent.getDriver()).dragAndDrop(agent.onWebDriverUniversityPage()
                .draggableElement, agent.onWebDriverUniversityPage().droppableElement).perform();

        Assert.assertEquals(agent.onWebDriverUniversityPage().droppableElement
                .findElement(By.tagName("p"))
                .getText(), "Dropped!", "Text should be Dropped!");
    }

    @Test
    public void testDoubleClick() {
        doubleClick(agent.onWebDriverUniversityPage().doubleClickElement);

        Assert.assertEquals(agent.onWebDriverUniversityPage()
                        .doubleClickElement
                        .getCssValue("background-color"), "rgba(147, 203, 90, 1)",
                "Unexpected area color");
    }

    @Test
    public void testHover() {
        hoverElement(agent.onWebDriverUniversityPage()
                .dropDownFirstElement);

        Assert.assertTrue(agent.onWebDriverUniversityPage()
                        .textInDropDownFirstElement.isDisplayed(), "Dropdown should be displayed");
    }
}
