package Organizations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.OrganizationCreatePage;
import Pom_Repo.OrganizationLookUpImg;
import Pom_Repo.ValidateOrgPage;

public class CreateOrganizationTest extends BaseClass{
	
	@Test(groups= {"smokeTest","regressionTest"})
	public void createOrganizationTest() throws Throwable {
	
		/*
		 * Login to vtiger application
		 * ->click on organizations link
		 * ->click on create organization lookup image
		 * ->Enter organisation name,phone number and email
		 * ->click on save Btn
		 * ->verify whether the organization is created in Organization Information page 
		 * ->Logout from the application. 
		 */
		

		// Branch2

		//Branch1
		
		HomePage home= new HomePage(driver);
		home.clickOrgLink();
		
		//click on create organization lookup image
		OrganizationLookUpImg img = new OrganizationLookUpImg(driver);
		img.clickOrgLookUp();
				
		//To avoid Duplicate values
		//Java_Utility.java
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
				
		//Enter organisation name,phone number and email from excel file
		//Excel_Utility.java		
		Excel_Utility exfile = new Excel_Utility();
		String orgName=exfile.readDataFromExcelFile("Organizations",0,0)+ranNum;
		String orgPhn=exfile.readDataFromExcelFileUsingDataFormatter("Organizations",0,1);
		String orgEmail=exfile.readDataFromExcelFileUsingDataFormatter("Organizations",0,2);
		
		OrganizationCreatePage org = new OrganizationCreatePage(driver);
		org.enterOrgnaizationData(orgName, orgPhn, orgEmail);
		
		System.out.println(orgName);
		System.out.println(orgPhn);
		System.out.println(orgEmail);
				
		//Verify whether the organization is created in Organization Information page
		ValidateOrgPage validate = new ValidateOrgPage(driver);
		validate.validateOrg(driver, orgName);
		
	}



}
