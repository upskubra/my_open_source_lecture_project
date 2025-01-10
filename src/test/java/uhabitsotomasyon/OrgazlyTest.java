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

    class OrgzlyTest {

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
            capabilities.setCapability("appPackage", "com.orgzlyrevived");
            capabilities.setCapability("appActivity", "com.orgzlyrevived.ui.activity.MainActivity");
            capabilities.setCapability("skipUnlock", "true");
            capabilities.setCapability("noReset", "false");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddNotebook() {
        try {
            System.out.println("Notebook addition test started...");

            // Click the "+" button to add a new notebook
            WebElement addButton = driver.findElement(By.id("com.orgzlyrevived:id/fab_add_notebook"));
            addButton.click();

            // Enter the notebook name
            WebElement notebookNameField = driver.findElement(By.id("com.orgzlyrevived:id/notebook_name_input"));
            notebookNameField.sendKeys("Test Notebook");

            // Click the "Save" button
            WebElement saveButton = driver.findElement(By.id("com.orgzlyrevived:id/save_notebook_button"));
            saveButton.click();

            // Verify the notebook is added to the list
            WebElement newNotebook = driver.findElement(By.xpath("//android.widget.TextView[@text='Test Notebook']"));
            Assert.assertTrue(newNotebook.isDisplayed(), "Notebook was not added successfully!");

            System.out.println("✅ Notebook successfully added!");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An error occurred during the notebook addition test.");
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("AddNotebookTest.tearDown");
    }
}
