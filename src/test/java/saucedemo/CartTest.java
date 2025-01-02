package saucedemo;

import UIObjects.data.Account;
import UIObjects.data.Url;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import UIObjects.pages.BaseTest;

public class CartTest extends BaseTest {
    private final String ITEM = "Sauce Labs Backpack";

    @BeforeMethod
    public void setUp() {
        agent.openUrl(Url.SAUCE_DEMO_URL);
        agent.onSauceDemoPage().signIn(Account.STANDARD_USER);
    }

    @Description("Test adding item to cart")
    @Test
    public void testAddingItemToCart() {
        agent.onSauceDemoPage()
                .addItemToCart(ITEM)
                .openCart()
                .checkItemPresence(ITEM);
    }
}
