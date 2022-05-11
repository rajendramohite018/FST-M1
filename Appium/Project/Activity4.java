package googleTasksandKeep;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4 {
	WebDriverWait wait;
	AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void beforeTest() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "320014cec028b579");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "uiAutomator2");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		URL location = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(location, caps);
		driver.get("https://www.training-support.net/selenium");
		wait = new WebDriverWait(driver, 30);

	}

	@Test
	public void todoList() {

		String[] str = { "Add tasks to list", "Get number of tasks", "Clear the list" };

		wait.until(
				ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Selenium']")));

		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		driver.findElementByAndroidUIAutomator(UiScrollable + ".flingToEnd(5)");
		driver.findElementByXPath("//android.view.View[contains(@text, 'To-Do List')]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		for (int i = 0; i < str.length; i++) {

			driver.findElementByXPath("//android.view.View[1]/android.widget.EditText[@index=\"0\"]").sendKeys(str[i]);
			driver.findElementByXPath("//android.view.View[1]/android.widget.Button[@index=\"1\"]").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.view.View/android.view.View[@index=\"0\"]")));
		List<MobileElement> totalTasks = driver
				.findElementsByXPath("//android.view.View[2]/android.view.View/android.view.View[@index=\"0\"]");
		System.out.println(totalTasks.get(0).getText());
		System.out.println(totalTasks.get(1).getText());
		System.out.println(totalTasks.get(2).getText());
		System.out.println(totalTasks.get(3).getText());

		Assert.assertEquals(totalTasks.get(1).getText(), "Add tasks to list");
		totalTasks.get(1).click();

		Assert.assertEquals(totalTasks.get(2).getText(), "Get number of tasks");
		totalTasks.get(2).click();

		Assert.assertEquals(totalTasks.get(3).getText(), "Clear the list");
		totalTasks.get(3).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.view.View[3]/android.view.View[@index=\"1\"]")));
		driver.findElementByXPath("//android.view.View[3]/android.view.View[@index=\"1\"]").click();

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
