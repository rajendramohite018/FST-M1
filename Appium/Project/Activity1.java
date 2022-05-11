package googleTasksandKeep;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
	WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;
	
	@BeforeClass
    public void setup() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "320014cec028b579");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "uiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);
 
        // Instantiate Appium Driver
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }
	
	@Test
	public void add_task()
	{
		System.out.println("Task is open");
		Sendtext("Complete Activity with Google Tasks");
		Sendtext("Complete Activity with Google Keep");
		Sendtext("Complete the second Activity Google Keep");
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/tasks_list")));
	}
	private void Sendtext(String msg) 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));
		driver.findElement(MobileBy.AccessibilityId("Create new task")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
		driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(msg);
		driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/tasks_list")));

		List<MobileElement> t=driver.findElements(MobileBy.xpath(".//android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout"));
		String sentMessageText = t.get(0).getAttribute("content-desc");
		System.out.println(sentMessageText);
		assertTrue(sentMessageText.contains(msg));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit(); 
	}
	
}
