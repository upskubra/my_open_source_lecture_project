package uhabitsotomasyon;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class Divkit {

    public AppiumDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "14");
            capabilities.setCapability("deviceName", "Pixel 9 Pro API 34");
            capabilities.setCapability("udid", "emulator-5554");
            capabilities.setCapability("appPackage", "com.yandex.divkit.demo");
            capabilities.setCapability("appActivity", "com.yandex.divkit.demo.MainActivity");
            capabilities.setCapability("skipUnlock", "true");
            capabilities.setCapability("noReset", "false");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJsonDisplay() {
        try {
            System.out.println("JSON Display test started...");

            // Enter JSON into the input field
            WebElement jsonInputField = driver.findElement(By.id("com.yandex.divkit.demo:id/json_input_field"));
            String jsonData = "{ \"templates\": { \"tutorialCard\": { \"type\": \"container\", \"items\": [{ \"type\": \"text\", \"font_size\": 21, \"font_weight\": \"bold\", \"margins\": { \"bottom\": 16 }, \"$text\": \"title\" }, { \"type\": \"text\", \"font_size\": 16, \"margins\": { \"bottom\": 16 }, \"$text\": \"body\" }, { \"type\": \"container\", \"$items\": \"links\" }], \"margins\": { \"bottom\": 6 }, \"orientation\": \"vertical\", \"paddings\": { \"top\": 10, \"bottom\": 0, \"left\": 30, \"right\": 30 } }, \"link\": { \"type\": \"text\", \"action\": { \"$url\": \"link\", \"$log_id\": \"log\" }, \"font_size\": 14, \"margins\": { \"bottom\": 2 }, \"text_color\": \"#0000ff\", \"underline\": \"single\", \"$text\": \"link_text\" } }, \"card\": { \"log_id\": \"div2_sample_card\", \"states\": [{ \"state_id\": 0, \"div\": { \"type\": \"container\", \"items\": [{ \"type\": \"image\", \"image_url\": \"https://yastatic.net/s3/home/divkit/logo.png\", \"margins\": { \"top\": 10, \"right\": 60, \"bottom\": 10, \"left\": 60 } }, { \"type\": \"tutorialCard\", \"title\": \"DivKit\", \"body\": \"What is DivKit and why did I get here?\\n\\nDivKit is a new Yandex open source framework that helps speed up mobile development.\\n\\niOS, Android, Web — update the interface of any applications directly from the server, without publishing updates.\\n\\nFor 5 years we have been using DivKit in the Yandex search app, Alice, Edadeal, Market, and now we are sharing it with you.\\n\\nThe source code is published on GitHub under the Apache 2.0 license.\", \"links\": [{ \"type\": \"link\", \"link_text\": \"More about DivKit\", \"link\": \"https://divkit.tech/\", \"log\": \"landing\" }, { \"type\": \"link\", \"link_text\": \"Documentation\", \"link\": \"https://divkit.tech/doc/\", \"log\": \"docs\" }, { \"type\": \"link\", \"link_text\": \"News channel\", \"link\": \"https://t.me/divkit_news\", \"log\": \"tg_news\" }, { \"type\": \"link\", \"link_text\": \"EN Community chat\", \"link\": \"https://t.me/divkit_community_en\", \"log\": \"tg_en_chat\" }, { \"type\": \"link\", \"link_text\": \"RU Community chat\", \"link\": \"https://t.me/divkit_community_ru\", \"log\": \"tg_ru_chat\" }] }] } }] } }";
            jsonInputField.sendKeys(jsonData);

            // Click on "Show the result" button
            WebElement showResultButton = driver.findElement(By.id("com.yandex.divkit.demo:id/show_result_button"));
            showResultButton.click();

            // Verify that the result is displayed correctly
            WebElement resultView = driver.findElement(By.id("com.yandex.divkit.demo:id/result_view"));
            Assert.assertTrue(resultView.isDisplayed(), "Result view is not displayed!");

            System.out.println("✅ JSON successfully processed and displayed!");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An error occurred during the JSON Display test.");
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("JsonDisplayTest.tearDown");
    }
}
