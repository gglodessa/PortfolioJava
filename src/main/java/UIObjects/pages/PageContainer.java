package UIObjects.pages;

import org.openqa.selenium.*;

public class PageContainer {
    private final WebDriver driver;
    private final HerokuAppPage herokuAppPage;
    private final SauceDemoPage onSauceDemoPage;
    private final WebDriverUniversityPage onWebDriverUniversityPage;
    private final UiTestingPlaygroundPage onUiTestingPlaygroundPage;

    public PageContainer(WebDriver driver) {
        this.driver = driver;
        this.herokuAppPage = new HerokuAppPage(driver);
        this.onSauceDemoPage = new SauceDemoPage(driver);
        this.onWebDriverUniversityPage = new WebDriverUniversityPage(driver);
        this.onUiTestingPlaygroundPage = new UiTestingPlaygroundPage(driver);
    }

    public HerokuAppPage onHerokuAppPage() {
        return herokuAppPage;
    }

    public SauceDemoPage onSauceDemoPage() {
        return onSauceDemoPage;
    }

    public WebDriverUniversityPage onWebDriverUniversityPage() {
        return onWebDriverUniversityPage;
    }

    public UiTestingPlaygroundPage onUiTestingPlaygroundPage() {
        return onUiTestingPlaygroundPage;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void openUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
}
