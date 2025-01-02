package apiDownloadImage;

import UIObjects.data.Url;
import io.restassured.internal.util.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import static UIObjects.data.Base64.BASE64_ALARM_PHOTO;
import static UIObjects.pages.BaseTest.logger;

public class apiDownloadImageTest {

    @Test
    public void testImageDownload() throws IOException {
        logger.info("1. Get an image from a link via a GET request");
        byte[] imageBytes = downloadImage(Url.ALARM_PHOTO_URL);
        String exampleBase64 = BASE64_ALARM_PHOTO;
        String downloadedBase64 = Base64.getEncoder().encodeToString(imageBytes);

        logger.info("2. Check that the image matches example.jpeg in base64");
        Assert.assertEquals(exampleBase64.substring(0, 55512), downloadedBase64.substring(0, 55512));
    }

    private byte[] downloadImage(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to download image. Response Code: " + connection.getResponseCode());
        }

        return IOUtils.toByteArray(connection.getInputStream());
    }
}
