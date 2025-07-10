package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage1 {
	private WebDriver driver;
	//Locators
	private By userTextField= By.name("user_name");
	private By passwordTextField= By.name("user_password");
	private By loginButton= By.id("submitButton");
	
	//constructor
	public LoginPage1(WebDriver driver)
	{
		this.driver= driver;
	}
	
	//methods to interact with webelements
	public void enterUserName(String name)
	{
		driver.findElement(userTextField).sendKeys(name);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(passwordTextField).sendKeys(pwd);
	}
	
	public void clickLoginBtn()
	{
		driver.findElement(loginButton).click();
	}
	
	public void loginToApp(String name, String pwd)
	{
		enterUserName(name);
		enterPassword(pwd);
		clickLoginBtn();
	}

}
