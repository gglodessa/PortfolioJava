package UIObjects.pages;

import UIObjects.data.Account;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageSauceDemo extends BaseComponent {
    @FindBy(css = "input[data-test='username']")
    public WebElement usernameInput;

    @FindBy(css = "input[data-test='password']")
    public WebElement passwordInput;

    @FindBy(css = "input[data-test='login-button']")
    public WebElement loginButton;

    public LoginPageSauceDemo(WebDriver driver) {
        super(driver);
    }

    @Step("Perform login as {account.login} with password {account.password}")
    public InventoryPageSauceDemo login(Account account) {
        usernameInput.sendKeys(account.getLogin());
        passwordInput.sendKeys(account.getPassword());
        loginButton.click();
        return new InventoryPageSauceDemo(driver);
    }
}
