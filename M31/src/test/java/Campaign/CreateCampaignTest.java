package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CampLookUpImgPage;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.CreateCampaignPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ValidateContactPage;
import Pom_Repo.ValidationCampaignPage;

//@Listeners(Generic_Utilities.ListenerImp.class)

//@Listeners(Generic_Utilities.ExtentReportImp.class)
public class CreateCampaignTest extends BaseClass{
	
	//  @Test(retryAnalyzer =Generic_Utilities.RetryAnalyserImp.class )
	@Test
	public void createCampaignTest() throws Throwable {
		
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
		
		HomePage home= new HomePage(driver);
		home.clickCampaignsLink(); //click on campaigns	
		
		//click on create campaign lookup image
		CampLookUpImgPage campLookUp = new CampLookUpImgPage(driver);
		campLookUp.clickLookUpImg();
		
		//To avoid Duplicate values
		//Java_Utility.java
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		//Enter campaignName from Excel file
		//Excel_Utility.java
		Excel_Utility exfile = new Excel_Utility();
		String camName=exfile.readDataFromExcelFile("Campaign",0,0)+ranNum;
		System.out.println(camName);		

		CreateCampaignPage camPage = new CreateCampaignPage(driver);
		camPage.enterCampName(camName);
		camPage.clickSaveButton();
		
		//Assert.fail("Failed Script");
		
		//verify whether the campaign is created in campaign Information page 
		ValidationCampaignPage validate = new ValidationCampaignPage(driver);
		validate.validateCamp(driver, camName);
	}

}
