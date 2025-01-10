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

public class BitwardenTest {

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
            capabilities.setCapability("appPackage", "com.x8bit.bitwarden");
            capabilities.setCapability("appActivity", "com.x8bit.bitwarden.ui.splash.SplashActivity");
            capabilities.setCapability("skipUnlock", "true");
            capabilities.setCapability("noReset", "false");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateAccount() {
        try {
            System.out.println("Account creation test started...");

            // Navigate to "Create Account" screen
            WebElement createAccountButton = driver.findElement(By.id("com.x8bit.bitwarden:id/buttonCreateAccount"));
            createAccountButton.click();

            // Fill in the email address
            WebElement emailField = driver.findElement(By.id("com.x8bit.bitwarden:id/inputEmail"));
            emailField.sendKeys("testuser@example.com");

            // Enter master password
            WebElement passwordField = driver.findElement(By.id("com.x8bit.bitwarden:id/inputMasterPassword"));
            passwordField.sendKeys("TestPassword123");

            // Confirm master password
            WebElement confirmPasswordField = driver.findElement(By.id("com.x8bit.bitwarden:id/inputMasterPasswordConfirm"));
            confirmPasswordField.sendKeys("TestPassword123");

            // Enter master password hint
            WebElement hintField = driver.findElement(By.id("com.x8bit.bitwarden:id/inputPasswordHint"));
            hintField.sendKeys("MyTestHint");

            // Toggle to check for known data breaches
            WebElement checkBreachesToggle = driver.findElement(By.id("com.x8bit.bitwarden:id/toggleCheckBreaches"));
            checkBreachesToggle.click();

            // Agree to terms and privacy policy
            WebElement termsToggle = driver.findElement(By.id("com.x8bit.bitwarden:id/toggleAcceptTerms"));
            termsToggle.click();

            // Submit the form
            WebElement submitButton = driver.findElement(By.id("com.x8bit.bitwarden:id/buttonSubmit"));
            submitButton.click();

            // Verify the success message
            WebElement successMessage = driver.findElement(By.id("com.x8bit.bitwarden:id/successMessage"));
            Assert.assertTrue(successMessage.isDisplayed(), "Account creation failed!");
            System.out.println("✅ Account successfully created!");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An error occurred during account creation.");
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("CreateAccountTest.tearDown");
    }
}
