package activitiesCRMProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Activity_9 {
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
		
		int c=driver.findElements(By.xpath("//table[@class='list view table-responsive']/thead/tr/th")).size();
		System.out.println("col size :" +c);
		Thread.sleep(2000);
		int r=driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr")).size();
		System.out.println("row size :" +r);
		
		 List<WebElement> column3 = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr/td[3]"));
		  System.out.println("NUMBER OF ROWS IN THIS TABLE = "+ column3 .size());
		  int row_num=1;
		  for (WebElement tdElement : column3 )
		  {		
			  if(row_num<=10) {
		        System.out.println("row# :" +row_num+",Name_Column= " +tdElement.getText());
		   row_num++; 
		   }
		  }
		  
		  List<WebElement> column8 = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr/td[8]"));
		  System.out.println("NUMBER OF ROWS IN THIS TABLE = "+ column8.size());
		  int row_num1=1;
		  for (WebElement tdElement : column8 )
		  {		
			  if(row_num1<=10) {
		        System.out.println("row# :" +row_num1+",User_column= " +tdElement.getText());
		   row_num1++; 
		   }
		  }
		  
		driver.close();
	}
}
