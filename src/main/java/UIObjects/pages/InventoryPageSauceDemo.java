package UIObjects.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPageSauceDemo extends BaseStorePageSauceDemo {

    private final String itemXPath =
            "//div[@class='inventory_item'][.//div[@class='inventory_item_name' and text()='%s']]";

    public InventoryPageSauceDemo(WebDriver driver) {
        super(driver);
    }

    @Step("Adding item {itemName} to cart")
    public InventoryPageSauceDemo addItemToCart(String itemName) {
        WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
        WebElement addToCartButton = item.findElement(
                By.xpath("//button[contains(@data-test, 'add-to-cart')]"));
        addToCartButton.click();
        return this;
    }
}
