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
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;

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
		 * ->and Logout from the application. */
		

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
		
		// click on product link
			driver.findElement(By.linkText("Products")).click();
				
		// >click on create product lookup image
			driver.findElement(By.cssSelector("[alt='Create Product...']")).click();
						
//			Random ran = new Random();
//			int ranNum = ran.nextInt(1000);
			
			Java_Utility jlib = new Java_Utility();
			int ranNum = jlib.getRandomNum();
						
//		// Enter product name
//			FileInputStream fes = new FileInputStream("./src/test/resources/Vtiger.xlsx");
//
//		// step2:- keeps the workbook/Excel file in read mode
//			Workbook book = WorkbookFactory.create(fes);
//
//		// step3:- Navigates into mentioned sheetname
//			Sheet sheet = book.getSheet("Product");
//
//		// step 4:- Navigates into mentioned rowNum
//			Row row = sheet.getRow(0);
//
//		// step 5:- Navigates into mentioned cellNum
//			Cell cell = row.getCell(0);
//
//		// step6:- fetch the cell value
//			String prdName = cell.getStringCellValue()+ranNum;
//			System.out.println(prdName);
			
			Excel_Utility exfile = new Excel_Utility();
			String prdName=exfile.readDataFromExcelFile("Product",0,0);

			driver.findElement(By.name("productname")).sendKeys(prdName);
						
		// click on save Btn
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//----------------------------------------------------------------------------------------------------------------------------------						

		
		//mouseOverOn more Link
		Actions a = new Actions(driver);
		WebElement ele = driver.findElement(By.linkText("More"));
		a.moveToElement(ele).perform();
		
		//click on campaigns
		driver.findElement(By.linkText("Campaigns")).click();
		
		//click on create campaign lookup image
		driver.findElement(By.cssSelector("[alt='Create Campaign...']")).click();
		
//		//Enter campaignName
//		FileInputStream fes1 = new FileInputStream("./src/test/resources/Vtiger.xlsx");
//
//		// step2:- keeps the workbook/Excel file in read mode
//		Workbook book1 = WorkbookFactory.create(fes1);
//
//		// step3:- Navigates into mentioned sheetname
//		Sheet sheet1 = book1.getSheet("Campaign");
//
//		// step 4:- Navigates into mentioned rowNum
//		Row row1 = sheet1.getRow(0);
//
//		// step 5:- Navigates into mentioned cellNum
//		Cell cell1 = row1.getCell(0);
//
//		// step6:- fetch the cell value
//		String camName = cell1.getStringCellValue()+ranNum;
//		System.out.println(camName);
		
	
		String camName=exfile.readDataFromExcelFile("Campaign",0,0)+ranNum;

		driver.findElement(By.name("campaignname")).sendKeys(camName);
		
		//Click on Product plus img
		driver.findElement(By.cssSelector("[src='themes/softed/images/select.gif']")).click();
		
		//Handle the PopUp
		
//		Set<String> allWin = driver.getWindowHandles();
//		Iterator<String> it = allWin.iterator();
//		
//		while(it.hasNext())
//		{
//			String win = it.next();
//			driver.switchTo().window(win);
//			@Nullable
//			String title = driver.getTitle();
//			if(title.contains("Products&action"))
//			{
//				break;
//			}
//		}
		wlib.WindowSwitching(driver, "Products&action");
		
		driver.findElement(By.name("search_text")).sendKeys(prdName);
		driver.findElement(By.name("search")).click();
		
		//dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();
		
		//Switch back to parent window
//		Set<String> allWin1 = driver.getWindowHandles();
//		Iterator<String> it1 = allWin1.iterator();
//		
//		while(it1.hasNext())
//		{
//			String win1 = it1.next();
//			driver.switchTo().window(win1);
//			@Nullable
//			String title1 = driver.getTitle();
//			if(title1.contains("Campaigns&action"))
//			{
//				break;
//			}
//		}
		
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
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
		
		

	}

	}


