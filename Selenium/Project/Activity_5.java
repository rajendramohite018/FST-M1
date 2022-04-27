package activitiesCRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class Activity_5 {
	
	@Test
	public void homePageOpen() throws InterruptedException {
	WebDriver driver = new FirefoxDriver();
    driver.get("https://alchemy.hguy.co/crm");
    driver.findElement(By.id("user_name")).sendKeys("admin");
    driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
    Thread.sleep(2000);
    
    WebElement td_Home = driver.findElement(By.xpath("//div[@id='toolbar']"));
    String bgColor = td_Home.getCssValue("color");
    System.out.println("Navigation background color : " + bgColor);
    String hexBackColor=Color.fromString(bgColor).asHex();
    System.out.println(hexBackColor);
    driver.close();
	}
}
