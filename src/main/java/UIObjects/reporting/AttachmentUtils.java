package UIObjects.reporting;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AttachmentUtils {
  @Attachment(value = "Page screenshot", type = "image/png")
  public static byte[] takeScreenshot(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @Attachment(value = "Page source", type = "text/html")
  public static String  takePageSource(WebDriver driver) {
    return driver.getPageSource();
  }
}
