package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public WebDriver_Utility wlib=new WebDriver_Utility();
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void BS()
	{
		System.out.println("Database connection");
	}
	
	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	
	//@Parameters("BROWSER")
	//public void BC(String BROWSER) throws Throwable//used for crossBrowser execution
	
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void BC() throws Throwable
	{
		
		//reading keys from propertoes file
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValue("browser");
		
		//reading keys from cmd prompt
		//String BROWSER = System.getProperty("browser");
		
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
		System.out.println("Browser Launching");
		
		sdriver=driver;
	}
	
	//@Parameters({"URL", "USERNAME", "PASSWORD"})
	//public void BM(String URL, String USERNAME, String pwd) throws Throwable
	// used for crossBroser execution
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void BM() throws Throwable
	{
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String pwd = flib.getKeyAndValue("password");
		
		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, pwd);
		
		//WebDriver_Utility.java
		//WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.addImplicitlyWait(driver);
		
		System.out.println("Login to Application");
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void AM()
	{
		HomePage home= new HomePage(driver);
		home.logoutApp();
		System.out.println("Logout from Application");
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void AC()
	{
		driver.quit();
		System.out.println("Close the browser");
	}
	
	@AfterTest(groups= {"smokeTest","regressionTest"})
	public void AT()
	{
		System.out.println("Parallel execution close");
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void AS()
	{
		System.out.println("Close Database");
	}

}
