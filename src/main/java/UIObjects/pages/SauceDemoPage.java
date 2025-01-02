package UIObjects.pages;

import UIObjects.data.Account;
import io.qameta.allure.Step;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SauceDemoPage extends BaseComponent {

    public SauceDemoPage(WebDriver driver) {
        super(driver);
    }

    @Name("User name input field")
    @FindBy(css = "input[data-test='username']")
    public WebElement usernameInput;

    @Name("Password input field")
    @FindBy(css = "input[data-test='password']")
    public WebElement passwordInput;

    @Name("Sign in button")
    @FindBy(css = "input[data-test='login-button']")
    public WebElement loginButton;

    @Name("Basket button")
    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    public WebElement basketButton;

    @Name("Error message on sign in page")
    @FindBy(xpath = "//*[contains(text(),'Epic sadface:')]")
    public WebElement errorMessage;

    private final String addToCartButton =
            "//div[@class='inventory_item' and .//div[text()='%s']]//button";

    private final String inventoryItemName = "//div[@class='cart_item'][.//div[@class='inventory_item_name'" +
            " and text()='%s']]";

    @Step("Perform login as {account.login} with password {account.password}")
    public SauceDemoPage signIn(Account account) {
        usernameInput.sendKeys(account.getLogin());
        passwordInput.sendKeys(account.getPassword());
        loginButton.click();
        return this;
    }

    public SauceDemoPage openCart() {
        basketButton.click();
        return this;
    }

    @Step("Adding item {itemName} to cart")
    public SauceDemoPage addItemToCart(String itemName) {
        WebElement item = driver.findElement(By.xpath(String.format(addToCartButton, itemName)));
        item.click();
        return this;
    }

    public SauceDemoPage checkItemPresence(String itemName) {
        String itemXPathFormatted = String.format(inventoryItemName, itemName);
        Assert.assertTrue(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
                        && driver.findElement(By.xpath(itemXPathFormatted)).isDisplayed(),
                "Item " + itemName + " was not added to cart");
        return this;
    }
}
