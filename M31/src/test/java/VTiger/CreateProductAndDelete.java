package VTiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class CreateProductAndDelete {

	public static void main(String[] args) throws Throwable {

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
		
		// Step1:- connnect the physical file path
			FileInputStream fis= new FileInputStream("./src/test/resources/commondata.properties.txt");
				
		// step2:- Create the object of Properties class and load all the Keys
			Properties pro = new Properties();
			pro.load(fis);
				
		// step3:-read the value using getProperty()
			String BROWSER = pro.getProperty("browser");
			String url = pro.getProperty("url");
			String username = pro.getProperty("username");
			String pwd = pro.getProperty("password");
				
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
				
			driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(pwd);
			driver.findElement(By.id("submitButton")).click();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));				
				
		// click on product link
			driver.findElement(By.linkText("Products")).click();
				
		// >click on create product lookup image
			driver.findElement(By.cssSelector("[alt='Create Product...']")).click();
			Random ran = new Random();
			int ranNum = ran.nextInt(1000);

		// Enter product name
			FileInputStream fes = new FileInputStream("./src/test/resources/Vtiger.xlsx");

		// step2:- keeps the workbook/Excel file in read mode
			Workbook book = WorkbookFactory.create(fes);

		// step3:- Navigates into mentioned sheetname
			Sheet sheet = book.getSheet("Product");

		// step 4:- Navigates into mentioned rowNum
			Row row = sheet.getRow(0);

		// step 5:- Navigates into mentioned cellNum
			Cell cell = row.getCell(0);

		// step6:- fetch the cell value
			String prdName = cell.getStringCellValue()+ranNum;
			System.out.println(prdName);

			driver.findElement(By.name("productname")).sendKeys(prdName);

		// click on save Btn
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			Thread.sleep(2000);
			
		// >verify whether the product is created in product Information page
			String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

			if (actData.equals(prdName))
			{
				System.out.println("Product Name is Created");
			} 
			else
			{
				System.out.println("Product name is not created");
			}
			
			//Click on product link again to navigate to the product table page 
			driver.findElement(By.linkText("Products")).click();
			
			//select the product created checkbox
			driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+prdName+"']/../preceding-sibling::td[2]//input[@type=\"checkbox\"]")).click();
			
			//click on delete
			driver.findElement(By.cssSelector("[value='Delete']")).click();
			
			//Handle the Alert popup 
			driver.switchTo().alert().accept();
			
		List<WebElement> prdData = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
			
		boolean flag=false;
		for (WebElement prd : prdData)
		{
			String actPrd = prd.getText();
			if(actPrd.contains(prdName))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Product Name is Deleted");
		}
		else
		{
			System.out.println("Product Name is not Deleted");
		}
		
		//Logout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();


	}

}
