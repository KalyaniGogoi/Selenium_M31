package Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
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
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLookUpImgPage;
import Pom_Repo.ProductValidationPage;

public class CreateProductTest extends BaseClass {

	@Test
	public void createProductTest() throws Throwable {
		
		/*
		 Login to vtiger application->click on product link->click on create product lookup image->
		 Enter product name->click on save Btn->verify whether the product is created in product Information page 
		 and Logout from the application.
		*/	
		
		// click on product link
		HomePage home= new HomePage(driver);
		home.clickProductLink();
		
		// >click on create product lookup image
		ProductLookUpImgPage prdImg = new ProductLookUpImgPage(driver);
		prdImg.clickLookupImg();
		
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
		ProductValidationPage validate = new ProductValidationPage(driver);
		validate.prdValidate(driver, prdName);
			
	}
	
//	@Test
//	public void m()
//	{
//		System.out.println("hello");
//	}
	
}


