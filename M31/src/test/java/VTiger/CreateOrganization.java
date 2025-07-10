package VTiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {

		/*
		 * Login to vtiger application
		 * ->click on organizations link
		 * ->click on create organization lookup image
		 * ->Enter organisation name,phone number and email
		 * ->click on save Btn
		 * ->verify whether the organization is created in Organization Information page 
		 * ->Logout from the application. 
		 */
		
				/* Step1:- connnect the physical file path
				FileInputStream fis= new FileInputStream("./src/test/resources/commondata.properties.txt");
				
				// step2:- Create the object of Properties class and load all the Keys
				Properties pro = new Properties();
				pro.load(fis);
				
				// step3:-read the value using getProperty()
				String BROWSER = pro.getProperty("browser");
				String url = pro.getProperty("url");
				String username = pro.getProperty("username");
				String pwd = pro.getProperty("password");
				*/
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
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
				wlib.addImplicitlyWait(driver);
				
		//Click on Organization link
		driver.findElement(By.linkText("Organizations")).click();
				
		//click on create organization lookup image
		driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
				
		//To avoid Duplicate values
		//Random ran = new Random();
		//int ranNum = ran.nextInt(1000);
				
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
				
				//Enter organisation name,phone number and email
				
//				FileInputStream fs= new FileInputStream("./src/test/resources/Vtiger.xlsx");
//				Workbook book = WorkbookFactory.create(fs);
//				Sheet sheet = book.getSheet("Organizations");
//				Row row = sheet.getRow(0);
//				Cell cell = row.getCell(0);
//				String orgName = cell.getStringCellValue()+ranNum;
//				System.out.println(orgName);
//				driver.findElement(By.name("accountname")).sendKeys(orgName);
//				
//				Cell cell1 = row.getCell(1);
//				DataFormatter format = new DataFormatter();
//				String orgPhn = format.formatCellValue(cell1);
//				System.out.println(orgPhn);
//				driver.findElement(By.name("phone")).sendKeys(orgPhn);
//				
//				Cell cell2 = row.getCell(2);
//				DataFormatter format1 = new DataFormatter();
//				String orgEmail = format1.formatCellValue(cell2);
//				System.out.println(orgEmail);
//				driver.findElement(By.name("email1")).sendKeys(orgEmail);
				
				Excel_Utility exfile = new Excel_Utility();
				String orgName=exfile.readDataFromExcelFile("Organizations",0,0)+ranNum;
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				
				String orgPhn=exfile.readDataFromExcelFileUsingDataFormatter("Organizations",0,1);
				driver.findElement(By.name("phone")).sendKeys(orgPhn);
				
				String orgEmail=exfile.readDataFromExcelFileUsingDataFormatter("Organizations",0,2);
				driver.findElement(By.name("email1")).sendKeys(orgEmail);
				
				
				//click on save Btn
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Verify whether the organization is created in Organization Information page
				String name = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
				
				if(name.equals(orgName))
				{
					System.out.println("Organization created");
				}
				else
				{
					System.out.println("Organization not created");
				}
				
				//Logout
				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				driver.findElement(By.linkText("Sign Out")).click();
				driver.quit();			

	}

}
