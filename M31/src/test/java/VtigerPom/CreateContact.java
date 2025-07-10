package VtigerPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;

public class CreateContact {

	public static void main(String[] args) throws Throwable {
		
		//connect the physical file path from commondata.properties file
				//File_Utility.java	
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
//					driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//					driver.findElement(By.name("user_password")).sendKeys(pwd);
//					driver.findElement(By.id("submitButton")).click();
					
					LoginPage login = new LoginPage(driver);
					login.loginToApp(USERNAME, pwd);
					
					//WebDriver_Utility.java
					WebDriver_Utility wlib = new WebDriver_Utility();
					wlib.maximizeWindow(driver);
					wlib.addImplicitlyWait(driver);

					//Click on Contact
//					driver.findElement(By.linkText("Contacts")).click();
					
					HomePage home= new HomePage(driver);
					home.clickContactLink();
					
					//Click on create contact lookup image
					driver.findElement(By.cssSelector("[alt='Create Contact...']")).click();

					// Enter contact from excel
					//Excel_Utility.java
					Excel_Utility exfile = new Excel_Utility();
					String firstName=exfile.readDataFromExcelFile("Contact",0,0);
					//Dropdown handle
					WebElement dropDown = driver.findElement(By.xpath("//select[@name='salutationtype']"));
					wlib.handleDropDown("Ms.", dropDown);
		//----------------------------------------------------------------------------------------------------------------------			
					//Enter First name
					driver.findElement(By.name("firstname")).sendKeys(firstName);
					System.out.println(firstName);
					
		//----------------------------------------------------------------------------------------------------------------
					//Enter Last name
					String lastName=exfile.readDataFromExcelFile("Contact",0,1);
					driver.findElement(By.name("lastname")).sendKeys(lastName);
					System.out.println(lastName);
					
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
					
					//Logout
//					driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//					driver.findElement(By.linkText("Sign Out")).click();
//					driver.quit();	
					home.logoutApp();
						
					}

	}


