package activitiesCRMProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity_2 {
	@Test
	public void urlHeaderImage() {
	WebDriver driver = new FirefoxDriver();
    driver.get("https://alchemy.hguy.co/crm");
    WebElement l =driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
    System.out.println("Src attribute is: "+ l.getAttribute("src"));
    driver.close();
	}
}
