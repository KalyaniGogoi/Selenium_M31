package VtigerPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		

		/*
		 * Login to vtiger application
		 * ->click on organizations link
		 * ->click on create organization lookup image
		 * ->Enter organisation name,phone number and email
		 * ->click on save Btn
		 * ->verify whether the organization is created in Organization Information page 
		 * ->Logout from the application. 
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
				
		//Click on Organization link
//		driver.findElement(By.linkText("Organizations")).click();
		
		HomePage home= new HomePage(driver);
		home.clickOrgLink();
		
		//click on create organization lookup image
		driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
				
		//To avoid Duplicate values
		//Java_Utility.java
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
				
		//Enter organisation name,phone number and email from excel file
		//Excel_Utility.java		
		Excel_Utility exfile = new Excel_Utility();
		String orgName=exfile.readDataFromExcelFile("Organizations",0,0)+ranNum;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		System.out.println(orgName);
				
		String orgPhn=exfile.readDataFromExcelFileUsingDataFormatter("Organizations",0,1);
		driver.findElement(By.name("phone")).sendKeys(orgPhn);
		System.out.println(orgPhn);
		
		String orgEmail=exfile.readDataFromExcelFileUsingDataFormatter("Organizations",0,2);
		driver.findElement(By.name("email1")).sendKeys(orgEmail);
		System.out.println(orgEmail);
				
				
		//click on save Btn
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//Verify whether the organization is created in Organization Information page
		String name = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
				
		if(name.equals(orgName))
			{
				System.out.println("Organization created");
			}
		else
			{
				System.out.println("Organization not created");
			}
				
		//Logout
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
//		driver.quit();	
		
		home.logoutApp();
		

	}

}
