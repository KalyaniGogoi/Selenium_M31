package DDTPractice;

import java.awt.AWTException;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoFlipkart {
	public static void main(String[] args) throws AWTException, Throwable {
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 WebElement ele = driver.findElement(By.name("q"));
		 ele.click();
		 ele.sendKeys("iphone16", Keys.ENTER);
		 List<WebElement> productName = driver.findElements(By.xpath("//div[contains(@class,'KzDlHZ')]"));
		 List<WebElement> price = driver.findElements(By.xpath("//div[contains(@class,'Nx9bqj')]"));
		 for(int i=0; i<productName.size();i++)
		 {
			 System.out.println(productName.get(i).getText() + "   " + price.get(i).getText());
			 
			 
			 /*
			  If I use this code it will give indexOutOfBound exception
			  
			   String name = productName.get(i).getText();
			 for(int j=0; i<price.size();j++)
			 {
				 String p = price.get(j).getText();
				 System.out.println(productName.size());
				 System.out.println(name+" "+p);
			 }*/
		 }
		}
	}
		 




