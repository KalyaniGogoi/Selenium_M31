package Debugging;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DebugggingEx2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
			
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		/*
		 Methods data = new Methods();
		data.maximizeWindow(driver);
		data.wait(driver);
		*/
			
			driver.findElement(By.name("q")).sendKeys("Puma");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		}

	}


