package regression;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import seleniumAdvanced.BaseTest;

import java.util.logging.Logger;

public class NativelyGETRequestTest extends BaseTest {

    @Test
    public void NativelyGETRequest() {

        logger.info("1. Open page and full screen mode");
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='/frames']")).click();
        driver.findElement(By.xpath("//a[@href='/iframe']")).click();
        logger.info("3. Run natively GET request https://jsonplaceholder.typicode.com/users");
        Response response = (Response)
                RestAssured.get("https://jsonplaceholder.typicode.com/users", new Object[0]).andReturn();
        logger.info("4. Enter data from the page in the input field");
        driver.findElement(By.xpath("//*[@class='tox-edit-area__iframe']"))
                .sendKeys(new CharSequence[]{response.asPrettyString()});
    }
}