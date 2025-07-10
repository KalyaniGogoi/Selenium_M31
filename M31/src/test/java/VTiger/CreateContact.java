package VTiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

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

import Generic_Utilities.File_Utility;

public class CreateContact {

	public static void main(String[] args) throws Throwable {
		// Step1:- connnect the physical file path
//		FileInputStream fis= new FileInputStream("./src/test/resources/commondata.properties.txt");
//
//		// step2:- Create the object of Properties class and load all the Keys
//			Properties pro = new Properties();
//			pro.load(fis);

		// step3:-read the value using getProperty()
//			String BROWSER = pro.getProperty("browser");
//			String URL = pro.getProperty("url");
//			String USERNAME = pro.getProperty("username");
//			String PASSWORD = pro.getProperty("password");
			
			File_Utility flib = new File_Utility();
			
			String BROWSER = flib.getKeyAndValue("browser");
			String URL = flib.getKeyAndValue("url");
			String USERNAME = flib.getKeyAndValue("username");
			String pwd = flib.getKeyAndValue("password");

			WebDriver driver;

			if (BROWSER.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				
				} 
			else if (BROWSER.equalsIgnoreCase("firefox")) 
			{
				driver = new FirefoxDriver();
				
			}
			else if (BROWSER.equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
				
			} else 
			{
				driver = new FirefoxDriver();
			}

			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(pwd);
			driver.findElement(By.id("submitButton")).click();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			//Click on Contact
			driver.findElement(By.linkText("Contacts")).click();
			
			//Click on create contact lookup image
			driver.findElement(By.cssSelector("[alt='Create Contact...']")).click();

			// Enter contact
			FileInputStream fes = new FileInputStream("./src/test/resources/Vtiger.xlsx");

			// step2:- keeps the workbook/Excel file in read mode
			Workbook book = WorkbookFactory.create(fes);

			// step3:- Navigates into mentioned sheetname
			Sheet sheet = book.getSheet("Contact");

			// step 4:- Navigates into mentioned rowNum
			Row row = sheet.getRow(0);

			// step 5:- Navigates into mentioned cellNum
			Cell cell = row.getCell(0);

			// step6:- fetch the cell value
			String firstName = cell.getStringCellValue();
			System.out.println(firstName);
			
			//Dropdown handle
			WebElement dropDown = driver.findElement(By.xpath("//select[@name='salutationtype']"));

			Select select = new Select(dropDown);
			select.selectByValue("Ms.");
			driver.findElement(By.name("firstname")).sendKeys(firstName);
//----------------------------------------------------------------------------------------------------------------
			// step 4:- Navigates into mentioned rowNum
			Row row1 = sheet.getRow(0);

			// step 5:- Navigates into mentioned cellNum
			Cell cell1 = row1.getCell(1);

			// step6:- fetch the cell value
			String lastName = cell1.getStringCellValue();
			System.out.println(lastName);

			driver.findElement(By.name("lastname")).sendKeys(lastName);
			
			//Click on save button
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			// >verify whether the conatc is created in product Information page
			String actData = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();

			if (actData.equals(firstName))
				{
					System.out.println("Contact is Created");
				} 
			else
				{
					System.out.println("Contact is not created");
				}
				
			

	}

}
