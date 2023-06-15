package PageObject;

import static org.testng.Assert.fail;

import UIObjects.data.Account;
import UIObjects.pages.InventoryPageSauceDemo;
import UIObjects.pages.LoginPageSauceDemo;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestTwo {
  Account account = Account.STANDARD_USER;

  @Test(description = "Test successful Login")
  public void testSuccessfulLogin() {
    LoginPageSauceDemo loginPageSauceDemo = new LoginPageSauceDemo(driver);
    loginPageSauceDemo.usernameInput.sendKeys(account.getLogin());
    loginPageSauceDemo.passwordInput.sendKeys(account.getPassword());
    loginPageSauceDemo.loginButton.click();

    new InventoryPageSauceDemo(driver).shouldSeePrimaryHeader();

    fail("Failing test");
  }
}
