package activitiesCRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity_6 {
	
	@Test
	public void MenuChecking() throws InterruptedException {
	WebDriver driver = new FirefoxDriver();
    driver.get("https://alchemy.hguy.co/crm");
    driver.findElement(By.id("user_name")).sendKeys("admin");
    driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
    Thread.sleep(2000);
	WebElement item=driver.findElement(By.xpath("//a[contains(text(),'Activities')]"));
		System.out.println("Verify the “Activities” menu item exists : "+item.isDisplayed());
	driver.close();
	}
}
