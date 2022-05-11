package googleTasksandKeep;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

public class Activity3 {
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

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath(".//android.widget.Button[contains(@text,\"Get Started!\")]")));
        
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"To-Do\"))")).click();
        
        String pageTitle2 = driver.findElementByXPath(".//android.webkit.WebView/android.view.View/android.view.View[2]").getText();
        System.out.println("Title on Homepage: " + pageTitle2);
        
        
        sendinput("Abhishek");
        
        sendinput("Mondal");
        
        sendinput("Ranjan");
        
        driver.findElementByXPath(".//android.widget.TextView[contains(@text,\"Clear List\")]").click();
        
    }

   
	private void sendinput(String string) {
		
		driver.findElementByXPath(".//android.widget.EditText[contains(@resource-id,'taskInput')]").sendKeys(string);
        
        driver.findElementByXPath(".//android.widget.Button[contains(@text,'Add Task')]").click();
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        List<MobileElement> t=driver.findElements(MobileBy.xpath(".//android.view.View[contains(@resource-id,'tasksList')]/android.view.View/android.view.View"));
		
        String textadded = t.get(t.size()-1).getText();
		System.out.println("Task added : " + textadded);
		assertTrue(textadded.contains(string));
               
	}

	
	 @AfterTest
	    public void tearDown() {
	        driver.quit();
	    } 
}
