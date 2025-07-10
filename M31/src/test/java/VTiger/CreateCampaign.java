package VTiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;

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

//		// Step1:- connnect the physical file path
//		FileInputStream fis= new FileInputStream("./src/test/resources/commondata.properties.txt");
//		
//		// step2:- Create the object of Properties class and load all the Keys
//		Properties pro = new Properties();
//		pro.load(fis);
//		
//		// step3:-read the value using getProperty()
//		String BROWSER = pro.getProperty("browser");
//		String url = pro.getProperty("url");
//		String username = pro.getProperty("username");
//		String pwd = pro.getProperty("password");
		
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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.addImplicitlyWait(driver);
		
		//mouseOverOn more Link
		Actions a = new Actions(driver);
		WebElement ele = driver.findElement(By.linkText("More"));
		a.moveToElement(ele).perform();
		
		//click on campaigns
		driver.findElement(By.linkText("Campaigns")).click();
		
		//click on create campaign lookup image
		driver.findElement(By.cssSelector("[alt='Create Campaign...']")).click();
		
//		//Enter campaignName
//		FileInputStream fes = new FileInputStream("./src/test/resources/Vtiger.xlsx");
//
//		// step2:- keeps the workbook/Excel file in read mode
//		Workbook book = WorkbookFactory.create(fes);
//
//		// step3:- Navigates into mentioned sheetname
//		Sheet sheet = book.getSheet("Campaign");
//
//		// step 4:- Navigates into mentioned rowNum
//		Row row = sheet.getRow(0);
//
//		// step 5:- Navigates into mentioned cellNum
//		Cell cell = row.getCell(0);
//
//		// step6:- fetch the cell value
//		String camName = cell.getStringCellValue();
//		System.out.println(camName);
		
		Excel_Utility exfile = new Excel_Utility();
		String camName=exfile.readDataFromExcelFile("Campaign",0,0);

		driver.findElement(By.name("campaignname")).sendKeys(camName);
		
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
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		

	}

	}

