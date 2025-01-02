import UIObjects.data.Url;
import UIObjects.pages.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NativelyGETRequestTest extends BaseTest {

    @Test
    public void NativelyGETRequest() {
        logger.info("1. Open frames -> iframe test");
        agent.openUrl(Url.INTERNET_HEROKU_APP_URL);
        agent.onHerokuAppPage().framesTest.click();
        agent.onHerokuAppPage().iframeOnFramesPage.click();

        logger.info("3. Run natively GET request https://jsonplaceholder.typicode.com/users");
        Response response = (Response)
                RestAssured.get("https://jsonplaceholder.typicode.com/users", new Object[0]).andReturn();

        logger.info("4. Enter data from the page in the input field");
        driver.findElement(By.xpath("//*[@class='tox-edit-area__iframe']"))
                .sendKeys(new CharSequence[]{response.asPrettyString()});
    }
}