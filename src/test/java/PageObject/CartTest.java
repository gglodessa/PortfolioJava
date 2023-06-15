package PageObject;

import jdk.jfr.Description;
import UIObjects.data.Account;
import UIObjects.pages.InventoryPageSauceDemo;
import UIObjects.pages.LoginPageSauceDemo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTestTwo {
  private final String ITEM = "Sauce Labs Backpack";

  private InventoryPageSauceDemo inventoryPageSauceDemo;

  @BeforeMethod
  public void setUp() {
   new LoginPageSauceDemo(driver)
       .login(Account.STANDARD_USER)
       .shouldSeePrimaryHeader();
    inventoryPageSauceDemo = new InventoryPageSauceDemo(driver);
  }

  @Description("Test adding item to cart")
  @Test
  public void testAddingItemToCart() {
    inventoryPageSauceDemo
        .addItemToCart(ITEM)
        .openCart()
        .checkItemPresence(ITEM);
  }
}
