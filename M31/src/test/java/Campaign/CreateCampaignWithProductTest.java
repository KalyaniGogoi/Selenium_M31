package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CampLookUpImgPage;
import Pom_Repo.CreateCampaignPage;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLookUpImgPage;
import Pom_Repo.ValidationCampaignPage;
import Pom_Repo.WindowSwitchingPage;
import VTiger.CreateProduct;

public class CreateCampaignWithProductTest extends BaseClass {
	
	@Test(groups="smokeTest")
	public void createCampaignWithProductTest() throws Throwable {
		
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
		
		// click on product link
		HomePage home = new HomePage(driver);
		home.clickProductLink();
				
		// >click on create product lookup image
		ProductLookUpImgPage prdLookupImg = new ProductLookUpImgPage(driver);
		prdLookupImg.clickLookupImg();
						
		//To avoid Duplicate values
		//Java_Utility.java
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
						
		// Enter product name from excel file
		//Excel_Utility.java
		Excel_Utility exfile = new Excel_Utility();
		String prdName=exfile.readDataFromExcelFile("Product",0,0)+ranNum;
		System.out.println(prdName);
		
		CreateProductPage product = new CreateProductPage(driver);
		product.enterProductData(prdName);
		
//----------------------------------------------------------------------------------------------------------------------------------						
		
//		//click on campaigns		
		home.clickCampaignsLink();
		
		//click on create campaign lookup image
		CampLookUpImgPage campLookUp = new CampLookUpImgPage(driver);
		campLookUp.clickLookUpImg();
		
		//Enter campaignName from excel file
		//Excel_Utility.java
		String camName=exfile.readDataFromExcelFile("Campaign",0,0)+ranNum;
		System.out.println(camName);
		
		CreateCampaignPage camPage = new CreateCampaignPage(driver);
		camPage.enterCampName(camName);
		
		WindowSwitchingPage winSwitch = new WindowSwitchingPage(driver);
		winSwitch.clickPrdLookUpImgInCamp(); //Click on Product plus img
		
//		//Handle the PopUp
//		//WebDriver_Utility.java
		wlib.WindowSwitching(driver, "Products&action");
		winSwitch.enterPrdDetails(prdName);
		
//		//dynamic xpath
		winSwitch.enterPrdNameInCamp(driver, prdName);
			
//		//Switch back to parent window
		wlib.WindowSwitching(driver, "Campaigns&action");
	
		camPage.clickSaveButton();
		
		//verify whether the campaign is created in campaign Information page 
		ValidationCampaignPage validate = new ValidationCampaignPage(driver);
		validate.validateCamp(driver, camName);
		validate.validateProduct(driver, prdName);
	}

}
