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

public class HabitTest {

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
            capabilities.setCapability("appPackage", "org.isoron.uhabits");
            capabilities.setCapability("appActivity", "org.isoron.uhabits.activities.habits.list.ListHabitsActivity");
            capabilities.setCapability("skipUnlock", "true");
            capabilities.setCapability("noReset", "false");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHabit() {
        try {
            // **1. Adding a habit**
            System.out.println("Starting the test for adding a habit...");
            WebElement addButton = driver.findElement(By.id("org.isoron.uhabits:id/actionCreateHabit")); // Click on the Add button
            addButton.click();

            WebElement habitNameField = driver.findElement(By.id("org.isoron.uhabits:id/input_name")); // Enter habit name
            habitNameField.sendKeys("Habit");

            WebElement saveButton = driver.findElement(By.id("org.isoron.uhabits:id/buttonSave")); // Click the Save button
            saveButton.click();

            // Verify the habit is added to the list
            WebElement habitListItem = driver.findElement(By.xpath("//android.widget.TextView[@text='Habit']")); // Locate the newly added habit
            Assert.assertTrue(habitListItem.isDisplayed(), "The habit was not added!");
            System.out.println("✅ Habit successfully added!");

            // **2. Editing a habit**
            System.out.println("Starting the test for editing a habit...");
            habitListItem.click(); // Select the habit to edit

            WebElement editHabitField = driver.findElement(By.id("org.isoron.uhabits:id/input_name")); // Clear and update the habit name
            editHabitField.clear();
            editHabitField.sendKeys("Evening Exercise");

            saveButton.click(); // Save the updated habit

            // Verify the habit name is updated
            WebElement updatedHabit = driver.findElement(By.xpath("//android.widget.TextView[@text='Evening Exercise']"));
            Assert.assertTrue(updatedHabit.isDisplayed(), "The habit was not updated!");
            System.out.println("✅ Habit successfully updated!");

            // **3. Deleting a habit**
            System.out.println("Starting the test for deleting a habit...");
            updatedHabit.click(); // Select the updated habit

            WebElement deleteButton = driver.findElement(By.id("org.isoron.uhabits:id/delete")); // Click the Delete button
            deleteButton.click();

            WebElement confirmDeleteButton = driver.findElement(By.id("android:id/button1")); // Confirm deletion
            confirmDeleteButton.click();

            // Verify the habit is removed from the list
            boolean isDeleted = driver.findElements(By.xpath("//android.widget.TextView[@text='Evening Exercise']")).isEmpty();
            Assert.assertTrue(isDeleted, "The habit was not deleted!");
            System.out.println("✅ Habit successfully deleted!");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An error occurred during the test.");
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("HabitTest.tearDown");
    }
}
