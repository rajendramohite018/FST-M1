package activitiesCRMProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity_1 {
	
	@Test
	public void websiteTitle() {
	WebDriver driver = new FirefoxDriver();
    driver.get("https://alchemy.hguy.co/crm");
    String pageTitle=driver.getTitle();
    if(pageTitle.contains("SuiteCRM")) {
    	System.out.println(" Display the page title of url : " +pageTitle);
    	driver.close();
    }
	}
}
