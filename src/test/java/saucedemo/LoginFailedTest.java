package saucedemo;

import UIObjects.data.Account;
import UIObjects.data.Url;
import org.testng.annotations.Test;
import UIObjects.pages.BaseTest;

import static org.testng.Assert.fail;

public class LoginFailedTest extends BaseTest {
    @Test(description = "Test successful Login")
    public void testSuccessfulLogin() {
        agent.openUrl(Url.SAUCE_DEMO_URL);
        agent.onSauceDemoPage().signIn(Account.STANDARD_USER);

        fail("Failing test");
    }
}
