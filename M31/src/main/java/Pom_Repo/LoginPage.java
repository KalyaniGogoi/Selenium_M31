package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	//Element initialization
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Elements declaration
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindBy(name="user_password")
	private WebElement PasswordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//getter methods
	public WebElement getUserTextField()
	{
		return UserTextField;	
	}
	
	public WebElement getPasswordTextField()
	{
		return PasswordTextField;	
	}
	
	public WebElement getLoginButton()
	{
		return loginButton;	
	}
	
	//Business Logics/Libraries
	/**
	 * This method is used to login the Application
	 * @param UserName
	 * @param Password
	 */
	
	public void loginToApp(String UserName, String Password)
	{
		UserTextField.sendKeys(UserName);
		PasswordTextField.sendKeys(Password);
		loginButton.click();
	}
	

}
