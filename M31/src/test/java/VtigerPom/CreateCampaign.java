package VtigerPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CampLookUpImgPage;
import Pom_Repo.CreateCampaignPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ValidationCampaignPage;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable {
		/*
		 * Login to vtiger application
		 * ->mouseOverOn more Link
		 * ->click on campaigns
		 * ->click on create campaign lookup image
		 * ->Enter campaignName
		 * ->click on save Btn
		 * ->verify whether the campaign is created in campaign Information page 
		 * and Logout from the application. 
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
		
		//mouseOverOn more Link
//		Actions a = new Actions(driver);
//		WebElement ele = driver.findElement(By.linkText("More"));
//		a.moveToElement(ele).perform();
		
		HomePage home= new HomePage(driver);
		home.clickCampaignsLink();
		
		//click on campaigns
//		driver.findElement(By.linkText("Campaigns")).click();
		
		//click on create campaign lookup image
//		driver.findElement(By.cssSelector("[alt='Create Campaign...']")).click();
		
		CampLookUpImgPage campLookUp = new CampLookUpImgPage(driver);
		campLookUp.clickLookUpImg();
		
		//Enter campaignName from Excel file
		//Excel_Utility.java
		Excel_Utility exfile = new Excel_Utility();
		String camName=exfile.readDataFromExcelFile("Campaign",0,0);
		
//		driver.findElement(By.name("campaignname")).sendKeys(camName);
//		System.out.println(camName);
//		
//		//click on save Btn
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		CreateCampaignPage camPage = new CreateCampaignPage(driver);
		camPage.enterCampName(camName);
		camPage.clickSaveButton();
		
		//verify whether the campaign is created in campaign Information page 
//		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
//		if(actData.equals(camName))
//		{
//			System.out.println("Campaign is created");
//		}
//		else
//		{
//			System.out.println("Campaign is not created");
//		}
		
		ValidationCampaignPage validate = new ValidationCampaignPage(driver);
		validate.validateCamp(driver, camName);
		
		//Logout
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
//		driver.quit();
		home.logoutApp();
		


	}

}
