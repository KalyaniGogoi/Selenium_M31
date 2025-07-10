package DDTPractice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchDataFromProperties_File {

	public static void main(String[] args) throws Throwable{
		//WebDriver driver= new ChromeDriver();
		
		FileInputStream fis= new FileInputStream("C:\\Users\\LENOVO\\Downloads\\commondata.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String pwd = pro.getProperty("password");
		
		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			
			driver= new FirefoxDriver();
			
		}
		
		else if (BROWSER.equalsIgnoreCase("edge")) {
			
			driver= new EdgeDriver();
			
		}
		
		else
		{
			driver= new ChromeDriver();
		}
		
		driver.get(url);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(pwd);
		driver.findElement(By.name("login")).click();

	}

}
