package PageObject;

import static org.testng.Assert.fail;

import UIObjects.data.Account;
import UIObjects.pages.InventoryPage;
import UIObjects.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestTwo {
  Account account = Account.STANDARD_USER;

  @Test(description = "Test successful Login")
  public void testSuccessfulLogin() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.usernameInput.sendKeys(account.getLogin());
    loginPage.passwordInput.sendKeys(account.getPassword());
    loginPage.loginButton.click();

    new InventoryPage(driver).shouldSeePrimaryHeader();

    fail("Failing test");
  }
}
