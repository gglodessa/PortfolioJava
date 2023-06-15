package UIObjects.pages;

import io.qameta.allure.Step;
import UIObjects.data.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseComponent {
  @FindBy(css = "input[data-test='username']")
  public WebElement usernameInput;

  @FindBy(css = "input[data-test='password']")
  public WebElement passwordInput;

  @FindBy(css = "input[data-test='login-button']")
  public WebElement loginButton;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Step("Perform login as {account.login} with password {account.password}")
  public InventoryPage login(Account account) {
    usernameInput.sendKeys(account.getLogin());
    passwordInput.sendKeys(account.getPassword());
    loginButton.click();
    return new InventoryPage(driver);
  }
}
