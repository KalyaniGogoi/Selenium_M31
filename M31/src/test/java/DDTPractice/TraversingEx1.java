package DDTPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TraversingEx1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Traversing using Parent Child RelationShip
//		String price = driver.findElement(By.xpath("//div[text()='Apple iPhone 16 (White, 128 GB)']/../..//div[@class='Nx9bqj _4b5DiR']")).getText();
//	    System.out.println(price);
		
		//Traversing using sibling relationship
//		String price = driver.findElement(By.xpath("//div[text()='Apple iPhone 16 (White, 128 GB)']/../following-sibling::div//div[@class='Nx9bqj _4b5DiR']")).getText();
//	    System.out.println(price);
	
		//Traversing using ancestor and descendant relationship
//		String price = driver.findElement(By.xpath("//div[text()='Apple iPhone 16 (Black, 128 GB)']/ancestor::div[@class='yKfJKb row']/descendant::div[@class='Nx9bqj _4b5DiR']")).getText();
//	    System.out.println(price);
	
		//Traversing using ancestor and without descendant
//		String price = driver.findElement(By.xpath("//div[text()='Apple iPhone 16 (Black, 128 GB)']/ancestor::div[@class='yKfJKb row']//div[@class='Nx9bqj _4b5DiR']")).getText();
//	    System.out.println(price);
		
		String price = driver.findElement(By.xpath("//div[text()='Apple iPhone 16 (Black, 128 GB)']/parent::div[@class='col col-7-12']/parent::div[@class='yKfJKb row']//div[@class='hl05eU']/child::div[@class='Nx9bqj _4b5DiR']")).getText();
	    System.out.println(price);
	}

	}


