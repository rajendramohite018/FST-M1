package activitiesCRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity_3 {
	@Test
	public void urlHeaderImage() {
	WebDriver driver = new FirefoxDriver();
    driver.get("https://alchemy.hguy.co/crm");
    WebElement str=driver.findElement(By.xpath("//a[@id='admin_options']"));
    String urlHeaderImageText=str.getText();
    System.out.println("first copyright text in the footer :" + urlHeaderImageText);
    driver.close();
	}
}
