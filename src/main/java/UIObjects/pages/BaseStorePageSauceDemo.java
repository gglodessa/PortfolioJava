package UIObjects.pages;

import UIObjects.components.PrimaryHeader;
import org.openqa.selenium.WebDriver;

public abstract class BaseStorePageSauceDemo extends BaseComponent {

    private final PrimaryHeader header = new PrimaryHeader(driver);

    public BaseStorePageSauceDemo(WebDriver driver) {
        super(driver);
    }

    public BaseStorePageSauceDemo shouldSeePrimaryHeader() {
        header.shouldSeePrimaryHeader();
        return this;
    }

    public CartPageSauceDemo openCart() {
        return header.openCart();
    }
}
