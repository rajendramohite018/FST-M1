package activitiesCRMProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity_7 {

	@Test
	public void Readingadditionalinfo() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();

		driver.get("https://alchemy.hguy.co/crm");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='bigbutton']")).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		WebElement Element1 = driver.findElement(By.xpath("(//a[contains(text(),'Sales')])[1]"));
		act.moveToElement(Element1).build().perform();
		Thread.sleep(2000);

		WebElement Element2 = driver.findElement(By.xpath("(//a[@id='moduleTab_9_Leads'])[1]"));
		act.moveToElement(Element2).click().build().perform();
		// System.out.println(driver.findElements(By.tagName("iframe")).size());
		Thread.sleep(3000);

		driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[10]")).click();
		Thread.sleep(2000);

		String mobileno=driver.findElement(By.xpath("(//span[@class='phone'])[1]")).getText();
		System.out.println(mobileno);
		driver.close();
	}
}
