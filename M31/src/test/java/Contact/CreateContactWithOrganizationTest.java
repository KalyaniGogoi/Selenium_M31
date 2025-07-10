package Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.OrganizationCreatePage;
import Pom_Repo.OrganizationLookUpImg;
import Pom_Repo.ValidateContactPage;
import Pom_Repo.ValidateOrgPage;
import Pom_Repo.WindowSwitchContactWithOrg;

public class CreateContactWithOrganizationTest extends BaseClass {
	
	@Test
	public void createContactWithOrganizationTest() throws Throwable {
			
			//Click on Organization link
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
			org.enterOrgnaizationData(orgName,orgPhn, orgEmail);
			
			//Verify whether the organization is created in Organization Information page
			ValidateOrgPage validateOrg = new ValidateOrgPage(driver);
			validateOrg.validateOrg(driver, orgName);
//-----------------------------------------------------------------------------------------------------			
			
			//Click on Contact
			home.clickContactLink();
					
			//Click on create contact lookup image
			ContactLookUpImgPage imgCon = new ContactLookUpImgPage(driver);
			imgCon.clickLookUp();

			// Enter contact
			String firstName=exfile.readDataFromExcelFile("Contact",0,0);
			String lastName=exfile.readDataFromExcelFile("Contact",0,1);
			
			CreateContactPage contact = new CreateContactPage(driver);
			
			contact.selectDropDown(driver);//Dropdown handle
			contact.enterContactData(firstName, lastName);
			System.out.println(firstName);
			System.out.println(lastName);
			
			WindowSwitchContactWithOrg win = new WindowSwitchContactWithOrg(driver);
			win.clickOrgLookUpInCon();
			//driver.findElement(By.xpath("//img[@title='Select']"));
			
			//Handle the PopUp
			//WebDriver_Utility.java
			wlib.WindowSwitching(driver, "Accounts&action");
			win.enterOrgDetails(orgName);
			win.enterOrgNameInContact(driver, orgName); //dynamic xpath
			
//			//dynamic xpath
//			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			
			//Switch back to parent window
			wlib.WindowSwitching(driver, "Contacts&action");
			
			//click on save Btn
			contact.saveBtn();
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			// >verify whether the conatc is created in product Information page
			ValidateContactPage validateCon = new ValidateContactPage(driver);
			validateCon.validateContactFirstNAme(driver, firstName);
			validateCon.validateContactlastNAme(driver, lastName);

	}

}
