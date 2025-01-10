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

public class WordpressTest {

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
            capabilities.setCapability("appPackage", "org.wordpress.android");
            capabilities.setCapability("appActivity", "org.wordpress.android.ui.accounts.SignInActivity");
            capabilities.setCapability("skipUnlock", "true");
            capabilities.setCapability("noReset", "false");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGoogleSignIn() {
        try {
            System.out.println("Google Sign-In test started...");

            // Click the "Continue with Google" button
            WebElement googleSignInButton = driver.findElement(By.id("org.wordpress.android:id/google_button"));
            googleSignInButton.click();

            // Wait for Google account selection screen
            Thread.sleep(3000); // Adjust as necessary for the device/emulator speed

            // Select a Google account
            WebElement accountSelection = driver.findElement(By.xpath("//android.widget.TextView[@text='testuser@gmail.com']"));
            accountSelection.click();

            // Verify that the login process is successful and next screen is displayed
            WebElement dashboard = driver.findElement(By.id("org.wordpress.android:id/dashboard"));
            Assert.assertTrue(dashboard.isDisplayed(), "Google Sign-In failed or dashboard not loaded.");

            System.out.println("✅ Google Sign-In successfully completed!");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An error occurred during Google Sign-In test.");
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("GoogleSignInTest.tearDown");
    }
}
