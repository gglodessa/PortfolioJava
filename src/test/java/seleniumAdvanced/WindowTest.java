package seleniumAdvanced;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://the-internet.herokuapp.com/windows");
    }

    @Test
    public void testSwitchToWindow() {
        String initialWindow = driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();

        assertEquals(driver.getWindowHandles().size(), 2, "Unexpected number of windows");

        String newWindowHandle = driver.getWindowHandles().stream()
                .filter(handle -> !handle.equals(initialWindow))
                .findFirst()
                .orElseThrow(() -> new AssertionError("New windows handle was not added"));

        driver.switchTo().window(newWindowHandle);
        assertEquals(driver.getTitle(), "New Window", "New Window has invalid title");

        driver.switchTo().window(initialWindow);
        assertEquals(driver.getTitle(), "The Internet", "Switching tab haven't happened");
    }
}
