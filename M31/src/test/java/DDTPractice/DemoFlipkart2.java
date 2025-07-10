package DDTPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoFlipkart2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys("iphone" , Keys.ENTER);
		//driver.findElement(By.className("_2iLD__")).click();
		
		List<WebElement> allPrice = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
	
	for (WebElement price : allPrice) 
	{
		String actPrc = price.getText();
		String expPrc = actPrc.replace("₹", "").replace(",", "");
	
	int price1 = Integer.parseInt(expPrc);
	
	if(price1>70000)
	{
		System.out.println(price1);
	}
	
	}
	}
}


