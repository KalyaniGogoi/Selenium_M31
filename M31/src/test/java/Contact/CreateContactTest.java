package Contact;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ValidateContactPage;

public class CreateContactTest extends BaseClass {
	
	@Test(groups="regressionTest")
	public void createContactTest() throws Throwable {
                  //Pull1
			//Click on Contact
			HomePage home= new HomePage(driver);
			home.clickContactLink();
			
			//Click on create contact lookup image
			ContactLookUpImgPage img = new ContactLookUpImgPage(driver);
			img.clickLookUp();
			
			// Enter contact from excel
			//Excel_Utility.java
			Excel_Utility exfile = new Excel_Utility();
			String firstName=exfile.readDataFromExcelFile("Contact",0,0);
			String lastName=exfile.readDataFromExcelFile("Contact",0,1);
			
			CreateContactPage contact = new CreateContactPage(driver);
			contact.selectDropDown(driver); //Dropdown handle
			contact.enterContactData(firstName, lastName);		
			System.out.println(firstName);
			System.out.println(lastName);
			contact.saveBtn();
			
			// >verify whether the conatc is created in product Information page
			ValidateContactPage validateCon = new ValidateContactPage(driver);
			validateCon.validateContactFirstNAme(driver, firstName);
			validateCon.validateContactlastNAme(driver, lastName);
		}

	}
