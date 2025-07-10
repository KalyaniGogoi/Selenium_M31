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

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {
		/*Login to vtiger application
		 * ->mouseOverOn more Link
		 * ->click on campaigns
		 * ->click on create campaign lookup image
		 * ->Enter campaignName
		 * ->Click on Product plus img
		 * ->Handle the PopUp
		 * ->Product name should be added to campaign createpage
		 * ->click on save Btn
		 * ->verify whether the campaign name is created in campaign Information page 
		 * ->and Logout from the application. 
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
//			driver.findElement(By.linkText("Products")).click();
		HomePage home = new HomePage(driver);
		home.clickProductLink();
				
		// >click on create product lookup image
			driver.findElement(By.cssSelector("[alt='Create Product...']")).click();
						
			//To avoid Duplicate values
			//Java_Utility.java
			Java_Utility jlib = new Java_Utility();
			int ranNum = jlib.getRandomNum();
						
		// Enter product name from excel file
		//Excel_Utility.java
		Excel_Utility exfile = new Excel_Utility();
		String prdName=exfile.readDataFromExcelFile("Product",0,0);
		driver.findElement(By.name("productname")).sendKeys(prdName);
		System.out.println(prdName);
						
		// click on save Btn
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//----------------------------------------------------------------------------------------------------------------------------------						

		
		//mouseOverOn more Link
//		Actions a = new Actions(driver);
//		WebElement ele = driver.findElement(By.linkText("More"));
//		a.moveToElement(ele).perform();
//		
//		//click on campaigns
//		driver.findElement(By.linkText("Campaigns")).click();
			
			home.clickCampaignsLink();
		
		//click on create campaign lookup image
		driver.findElement(By.cssSelector("[alt='Create Campaign...']")).click();
		
		//Enter campaignName from excel file
		//Excel_Utility.java
		String camName=exfile.readDataFromExcelFile("Campaign",0,0)+ranNum;
		driver.findElement(By.name("campaignname")).sendKeys(camName);
		System.out.println(camName);
		
		//Click on Product plus img
		driver.findElement(By.cssSelector("[src='themes/softed/images/select.gif']")).click();
		
		//Handle the PopUp
		//WebDriver_Utility.java
		wlib.WindowSwitching(driver, "Products&action");
		
		driver.findElement(By.name("search_text")).sendKeys(prdName);
		driver.findElement(By.name("search")).click();
		
		//dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();
		
		//Switch back to parent window
		wlib.WindowSwitching(driver, "Campaigns&action");
			
		//click on save Btn
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify whether the campaign is created in campaign Information page 
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
			if(actData.equals(camName))
				{
					System.out.println("Campaign is created");
				}
			else
				{
					System.out.println("Campaign is not created");
				}
				
			//Logout
//			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//			driver.findElement(By.linkText("Sign Out")).click();
//			driver.quit();
			
			home.logoutApp();
		
		

	}

	}

