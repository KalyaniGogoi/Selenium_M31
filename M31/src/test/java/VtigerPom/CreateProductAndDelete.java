package VtigerPom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;

public class CreateProductAndDelete {

	public static void main(String[] args) throws Throwable {
		/*
		 * Login to vtiger application
		 * ->click on products link
		 * ->click on create product lookup image
		 * ->Enter product name
		 * ->click on save Btn
		 * ->verify whether the product is created in product Information page
		 * ->click on product link
		 * ->navigate to product table page 
		 * ->select the product created checkbox
		 * ->click on delete
		 * ->Handle the Alert popup 
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
//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(By.name("user_password")).sendKeys(pwd);
//			driver.findElement(By.id("submitButton")).click();
			
			LoginPage login = new LoginPage(driver);
			login.loginToApp(USERNAME, pwd);
			
			//WebDriver_Utility.java
			WebDriver_Utility wlib = new WebDriver_Utility();
			wlib.maximizeWindow(driver);
			wlib.addImplicitlyWait(driver);			
				
		// click on product link
//			driver.findElement(By.linkText("Products")).click();
			
			HomePage home= new HomePage(driver);
			home.clickProductLink();
				
		// >click on create product lookup image
			//driver.findElement(By.cssSelector("[alt='Create Product...']")).click();
			
			
			//To avoid Duplicate values
			//Java_Utility.java
			Java_Utility jlib = new Java_Utility();
			int ranNum = jlib.getRandomNum();
			
			// Enter product name from excelsheet
			//Excel_Utility.java		
			Excel_Utility exfile = new Excel_Utility();
			String prdName=exfile.readDataFromExcelFile("Product",0,0)+ranNum;
			System.out.println(prdName);
			driver.findElement(By.name("productname")).sendKeys(prdName);

		// click on save Btn
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		// >verify whether the product is created in product Information page
			String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

			if (actData.equals(prdName))
			{
				System.out.println("Product Name is Created");
			} 
			else
			{
				System.out.println("Product name is not created");
			}
			
			//Click on product link again to navigate to the product table page 
			driver.findElement(By.linkText("Products")).click();
			
			//select the product created checkbox
			driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+prdName+"']/../preceding-sibling::td[2]//input[@type=\"checkbox\"]")).click();
			
			//click on delete
			driver.findElement(By.cssSelector("[value='Delete']")).click();
			
			//Handle the Alert popup 
			wlib.acceptAlert(driver);
//			driver.switchTo().alert().accept();
			
		List<WebElement> prdData = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
			
		boolean flag=false;
		for (WebElement prd : prdData)
		{
			String actPrd = prd.getText();
			if(actPrd.contains(prdName))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Product Name is Deleted");
		}
		else
		{
			System.out.println("Product Name is not Deleted");
		}
		
		//Logout
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
//		driver.quit();
		home.logoutApp();

	}

}
