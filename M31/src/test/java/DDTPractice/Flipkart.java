package DDTPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com");

		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		List<WebElement> allPrice = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));

		for (int i = 0; i < allNames.size(); i++)
		{
			System.out.println(allNames.get(i).getText() + "   " + allPrice.get(i).getText());
		}

	}

}
