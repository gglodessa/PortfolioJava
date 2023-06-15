package seleniumAdvanced;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Actions/index.html");
    }

    @Test
    public void testDragAndDrop() {
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver).dragAndDrop(draggable, droppable).perform();

        assertEquals(droppable.findElement(By.tagName("p")).getText(), "Dropped!",
                "Element was not dropped");
    }

    @Test
    public void testDoubleClick() {
        WebElement doubleClickArea = driver.findElement(By.id("double-click"));
        new Actions(driver).doubleClick(doubleClickArea).perform();

        assertEquals(doubleClickArea.getCssValue("background-color"), "rgba(147, 203, 90, 1)",
                "Unexpected area color");
    }

    @Test
    public void testHover() {
        WebElement dropdown = driver.findElement(By.cssSelector(".dropdown:nth-of-type(1)"));
        new Actions(driver).moveToElement(dropdown).perform();

        assertTrue(driver.findElement(By.xpath("//a[text()='Link 1']")).isDisplayed(),
                "Dropdown was not displayed");
    }


}
