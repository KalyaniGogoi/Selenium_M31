package VTiger;

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

public class CreateContactWithOrganization {

	public static void main(String[] args) throws Throwable {
		// Step1:- connnect the physical file path
		FileInputStream fis= new FileInputStream("./src/test/resources/commondata.properties.txt");

		// step2:- Create the object of Properties class and load all the Keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:-read the value using getProperty()
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

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
								
			} 
		else 
			{
			driver = new FirefoxDriver();
			}

		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					
		//Click on Organization link
		driver.findElement(By.linkText("Organizations")).click();
					
		//click on create organization lookup image
		driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
					
		//To avoid Duplicate values
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
					
		//Enter organisation name,phone number and email
					
		FileInputStream fs= new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook book = WorkbookFactory.create(fs);
		Sheet sheet = book.getSheet("Organizations");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String orgName = cell.getStringCellValue()+ranNum;
		System.out.println(orgName);
		driver.findElement(By.name("accountname")).sendKeys(orgName);
					
		Cell cell1 = row.getCell(1);
		DataFormatter format = new DataFormatter();
		String orgPhn = format.formatCellValue(cell1);
		System.out.println(orgPhn);
		driver.findElement(By.name("phone")).sendKeys(orgPhn);
					
		Cell cell2 = row.getCell(2);
		DataFormatter format1 = new DataFormatter();
		String orgEmail = format1.formatCellValue(cell2);
		System.out.println(orgEmail);
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

//---------------------------------------------------------------------------------------------------------------
					
		//Click on Contact
		driver.findElement(By.linkText("Contacts")).click();
							
		//Click on create contact lookup image
		driver.findElement(By.cssSelector("[alt='Create Contact...']")).click();

		// Enter contact
		FileInputStream fes = new FileInputStream("./src/test/resources/Vtiger.xlsx");

		// step2:- keeps the workbook/Excel file in read mode
		Workbook book1 = WorkbookFactory.create(fes);

		// step3:- Navigates into mentioned sheetname
		Sheet sheet1 = book1.getSheet("Contact");

		// step 4:- Navigates into mentioned rowNum
		Row row1 = sheet1.getRow(0);

		// step 5:- Navigates into mentioned cellNum
		Cell cell11 = row1.getCell(0);

		// step6:- fetch the cell value
		String firstName = cell11.getStringCellValue();
		System.out.println(firstName);
							
		//Dropdown handle
		WebElement dropDown = driver.findElement(By.xpath("//select[@name='salutationtype']"));

		Select select = new Select(dropDown);
		select.selectByValue("Ms.");
		driver.findElement(By.name("firstname")).sendKeys(firstName);
//----------------------------------------------------------------------------------------------------------------
		// step 4:- Navigates into mentioned rowNum
		Row row2 = sheet1.getRow(0);

		// step 5:- Navigates into mentioned cellNum
		Cell cell21 = row2.getCell(1);

		// step6:- fetch the cell value
		String lastName = cell21.getStringCellValue();
		System.out.println(lastName);

		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.cssSelector("[alt='Select']")).click();
					
		//Window handle
			Set<String> allWin = driver.getWindowHandles();
			Iterator<String> it = allWin.iterator();
					
			while(it.hasNext())
				{
				String win = it.next();
				driver.switchTo().window(win);
				@Nullable
				String title = driver.getTitle();
				if(title.contains("Accounts&action"))
					{
					break;
					}
				}
					
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
					
			//dynamic xpath
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
					
			//Switch back to parent window
			Set<String> allWin1 = driver.getWindowHandles();
			Iterator<String> it1 = allWin1.iterator();
					
			while(it1.hasNext())
				{
					String win1 = it1.next();
					driver.switchTo().window(win1);
					@Nullable
					String title1 = driver.getTitle();
					if(title1.contains("Contacts&action"))
					{
						break;
					}
				}
					
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
