package googleTasksandKeep;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity6 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "320014cec028b579");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "uiAutomator2");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void testSearchAppium() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.training-support.net/selenium");

		String pageTitle = driver.findElementByClassName("android.webkit.WebView").getText();
		System.out.println("Title on Homepage: " + pageTitle);

		wait.until(ExpectedConditions
				.elementToBeClickable(MobileBy.xpath(".//android.widget.Button[contains(@text,\"Get Started!\")]")));

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Popups\"))"))
				.click();

		String pageTitle2 = driver.findElementByXPath(".//android.view.View/android.widget.TextView").getText();
		System.out.println("Title on Homepage: " + pageTitle2);

		// sendinput("Username","Password");

		sendinput("admin", "password");

		sendinput("admin", "ppassword");

	}

	private void sendinput(String Username, String Password) {

		driver.findElementByXPath(".//android.widget.Button[contains(@text,'Sign In')]").click();
		driver.findElementByXPath(".//android.widget.EditText[contains(@resource-id,'username')]").sendKeys(Username);
		driver.findElementByXPath(".//android.widget.EditText[contains(@resource-id,'password')]").sendKeys(Password);
		driver.findElementByXPath(".//android.widget.Button[contains(@text,\"Log in\")]").click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String text = driver
				.findElement(MobileBy.xpath(".//android.view.View[contains(@resource-id,\"action-confirmation\")]"))
				.getText();

		if (text.contains("Welcome Back")) {
			assertTrue(text.contains("Welcome Back"));
			System.out.println("Task : " + text);
		} else {
			assertFalse(text.contains("Welcome Back"));
			System.out.println("Task : " + text);
		}

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
