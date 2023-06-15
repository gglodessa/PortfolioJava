package UIObjects.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPageSauceDemo extends BaseStorePageSauceDemo {

  private final String itemXPath = "//div[@class='cart_item'][.//div[@class='inventory_item_name' and text()='%s']]";

  public CartPageSauceDemo(WebDriver driver) {
    super(driver);
  }

  public CartPageSauceDemo checkItemPresence(String itemName) {
    String itemXPathFormatted = String.format(itemXPath, itemName);
    assertTrue(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
            && driver.findElement(By.xpath(itemXPathFormatted)).isDisplayed(),
        "Item " + itemName + " was not added to cart");
    return this;
  }
}
