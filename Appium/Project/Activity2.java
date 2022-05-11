package googleTasksandKeep;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "320014cec028b579");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "uiAutomator2");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noreset", true);

		// Instantiate Appium Driver
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 200);
	}

	@Test
	public void add_task() {

		System.out.println("Note is open");

		Sendtext("Complete Activity with Google Tasks");

		Sendtext("Complete Activity with Google Keep");

		Sendtext("Complete the second Activity Google Keep");

		wait.until(ExpectedConditions
				.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/tasks_list")));

	}

	private void Sendtext(String msg) {
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("New text note")));
		driver.findElement(MobileBy.AccessibilityId("New text note")).click();
		wait.until(
				ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/editable_title")));
		driver.findElement(MobileBy.id("com.google.android.keep:id/editable_title")).sendKeys("Title : " + msg);
		driver.findElement(MobileBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Note : " + msg);
		driver.findElement(MobileBy.AccessibilityId("Open navigation drawer")).click();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/browse_text_note")));

		List<MobileElement> t = driver.findElements(MobileBy.id("com.google.android.keep:id/browse_text_note"));
		String sentMessageText = t.get(0).getAttribute("content-desc");
		System.out.println(sentMessageText);
		assertTrue(sentMessageText.contains(msg + ". "));

	}

	@AfterClass(enabled = false)
	public void afterClass() {
		driver.quit();
	}
}
