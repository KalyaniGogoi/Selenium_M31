package Product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CreateProductPage;
import Pom_Repo.DeleteProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLookUpImgPage;
import Pom_Repo.ProductValidationPage;

public class CreateProductAndDeleteTest extends BaseClass {
	
	@Test
	public void createProductTest() throws Throwable {
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
				
		// click on product link			
			HomePage home= new HomePage(driver);
			home.clickProductLink();
				
		// >click on create product lookup image
			ProductLookUpImgPage img = new ProductLookUpImgPage(driver);
			img.clickLookupImg();
	
			//To avoid Duplicate values
			//Java_Utility.java
			Java_Utility jlib = new Java_Utility();
			int ranNum = jlib.getRandomNum();
			
			// Enter product name from excelsheet
			//Excel_Utility.java		
			Excel_Utility exfile = new Excel_Utility();
			String prdName=exfile.readDataFromExcelFile("Product",0,0)+ranNum;
			System.out.println(prdName);
			
			CreateProductPage product = new CreateProductPage(driver);
			product.enterProductData(prdName);
			
			// >verify whether the product is created in product Information page
			ProductValidationPage validatePrd = new ProductValidationPage(driver);
			validatePrd.prdValidate(driver, prdName);
		
			//Click on product link again to navigate to the product table page 
			home.clickProductLink();
			
			//select the product created checkbox
			DeleteProductPage deletePrd = new DeleteProductPage(driver);
			deletePrd.selectPrdCheckBox(driver, prdName);
			
			//click on delete
			deletePrd.clickDeleteButton();
			
			//Handle the Alert popup 
			wlib.acceptAlert(driver);
			
			deletePrd.validatePrdDeleted(driver, prdName);
			
			Thread.sleep(2000);

	}

}
