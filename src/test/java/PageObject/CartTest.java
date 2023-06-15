package PageObject;

import jdk.jfr.Description;
import UIObjects.data.Account;
import UIObjects.pages.InventoryPage;
import UIObjects.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTestTwo {
  private final String ITEM = "Sauce Labs Backpack";

  private InventoryPage inventoryPage;

  @BeforeMethod
  public void setUp() {
   new LoginPage(driver)
       .login(Account.STANDARD_USER)
       .shouldSeePrimaryHeader();
    inventoryPage = new InventoryPage(driver);
  }

  @Description("Test adding item to cart")
  @Test
  public void testAddingItemToCart() {
    inventoryPage
        .addItemToCart(ITEM)
        .openCart()
        .checkItemPresence(ITEM);
  }
}
