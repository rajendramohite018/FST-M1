package activitiesCRMProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Activity_8 {
	@Test
	public void Traversingtables1() throws InterruptedException {
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

		WebElement Element2 = driver.findElement(By.xpath("(//a[@id='moduleTab_9_Accounts'])[1]"));
		act.moveToElement(Element2).click().build().perform();
		Thread.sleep(2000);
		////table[@class='list view table-responsive']/tbody/tr/td
		//table[@class='list view table-responsive']/tbody/tr[position() mod 2=1]
		int c=driver.findElements(By.xpath("//table[@class='list view table-responsive']/thead/tr/th")).size();
		System.out.println("col size :" +c);
		Thread.sleep(2000);
		int r=driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr[position() mod 2=1]")).size();
		System.out.println("row size :" +r);
		Thread.sleep(2000);
		for ( int i=1; i<=r;i++) {
			if(i%2 !=0) {
			for(int j=1; j<=c; j++) {
				System.out.print(driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr["+i+"]/td["+j+"]")).getText()+" ");
			}
			System.out.println();
			}
		}	
		driver.close();
		}
}
