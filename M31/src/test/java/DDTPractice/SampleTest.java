package DDTPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pom_Repo.LoginPage1;
import Pom_Repo.LoginPage2;

public class SampleTest {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		//LoginPage1 login = new LoginPage1(driver);
//		login.enterUserName("admin");
//		login.enterPassword("admin");
//		login.clickLoginBtn();
		//login.loginToApp("admin", "admin");
		
		LoginPage2 login = new LoginPage2(driver);
		login.loginToVtiger("admin", "admin");	

	}

}
