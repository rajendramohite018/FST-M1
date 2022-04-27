package activitiesCRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity_4 {
	@Test
	public void homePageOpen() throws InterruptedException {
	WebDriver driver = new FirefoxDriver();
    driver.get("https://alchemy.hguy.co/crm");
    driver.findElement(By.id("user_name")).sendKeys("admin");
    driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
    Thread.sleep(2000);
    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());
    if(driver.getCurrentUrl().contains("https://alchemy.hguy.co/crm/index.php?module=Home&action=index")){
    	  System.out.println("Home Web page is opened");
    	}
    	else{
    	  System.out.println("Home Web page could not open.");
    	}
    driver.close();
	}
}
