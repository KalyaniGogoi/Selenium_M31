package VtigerPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		/*
		 Login to vtiger application->click on product link->click on create product lookup image->
		 Enter product name->click on save Btn->verify whether the product is created in product Information page 
		 and Logout from the application.
		*/	
		
		//connect the physical file path from commondata.properties file
		//File_Utility.java
		
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValue("browser");
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String pwd = flib.getKeyAndValue("password");
		
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
		
		driver.get(URL);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(pwd);
//		driver.findElement(By.id("submitButton")).click();
		
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, pwd);
		
		//WebDriver_Utility.java
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.addImplicitlyWait(driver);
		
		// click on product link
//		driver.findElement(By.linkText("Products")).click();
		
		HomePage home= new HomePage(driver);
		home.clickProductLink();
		
		// >click on create product lookup image
		driver.findElement(By.cssSelector("[alt='Create Product...']")).click();

		// Enter product name from excelsheet
		//Excel_Utility.java		
		Excel_Utility exfile = new Excel_Utility();
		String prdName=exfile.readDataFromExcelFile("Product",0,0);
		System.out.println(prdName);
		driver.findElement(By.name("productname")).sendKeys(prdName);

		// click on save Btn
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);
		
		// >verify whether the product is created in product Information page
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		if (actData.equals(prdName)) {
			System.out.println("Product Name is Created");
			}
		else {
			System.out.println("Product name is not created");
			}

		// logout from application
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
		home.logoutApp();
	}

	}


