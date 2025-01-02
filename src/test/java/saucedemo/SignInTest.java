package saucedemo;

import UIObjects.data.Account;
import UIObjects.data.Url;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import UIObjects.pages.BaseTest;

import static UIObjects.data.errorMessages.ERROR_LOGIN_FAILED;
import static UIObjects.data.errorMessages.LOCKED_LOGIN;

public class SignInTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        agent.openUrl(Url.SAUCE_DEMO_URL);
    }

    @Test
    public void logIn() {
        logger.info("1. Sign In");
        agent.onSauceDemoPage().signIn(Account.STANDARD_USER);

        logger.info("2. Check basket");
        boolean isCartEmpty = agent.onSauceDemoPage()
                .basketButton.findElements(By.cssSelector(".shopping_cart_badge")).isEmpty();

        Assert.assertTrue(isCartEmpty, "Basket should be empty");
    }

    @Test
    public void wrongPassworld() {
        logger.info("1. Sign in with wrong password");
        agent.onSauceDemoPage().signIn(Account.STANDARD_USER_WITH_WRONG_PASS);

        logger.info(("2. Check error message"));
        Assert.assertEquals(agent.onSauceDemoPage().errorMessage.getText(),
                ERROR_LOGIN_FAILED, "Error message should be " + ERROR_LOGIN_FAILED);
    }

    @Test
    public void lockedOutUser() {
        logger.info("1. Sign in with used locked_out_user");
        agent.onSauceDemoPage().signIn(Account.LOCKED_USER);

        logger.info(("2. Check error message"));
        Assert.assertEquals(agent.onSauceDemoPage().errorMessage.getText(),
                LOCKED_LOGIN, "Error message should be " + LOCKED_LOGIN);
    }
}
