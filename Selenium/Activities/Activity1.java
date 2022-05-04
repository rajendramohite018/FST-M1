package selenumActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.training-support.net");
			//System.out.println("Successfully launched");
			driver.close();

	}

}
