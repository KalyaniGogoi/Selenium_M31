package DDTPractice;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataIntoPropertiesFile {

	public static void main(String[] args) throws Throwable {
			//Inserting data into properties file
				Properties pro = new Properties();
				pro.setProperty("browser", "edge");
				pro.setProperty("url", "https://www.facebook.com/");
				pro.setProperty("username", "admin");
				pro.setProperty("password", "admin");
				
				FileOutputStream fos = new FileOutputStream("C:\\Users\\LENOVO\\Downloads\\commondata.properties.txt");
				pro.store(fos, "CommonData");
				System.out.println("Inserted the data");
				
			//fetching Data from Properties File
				FileInputStream fis= new FileInputStream("C:\\Users\\LENOVO\\Downloads\\commondata.properties.txt");
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
