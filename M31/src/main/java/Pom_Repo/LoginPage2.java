package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	
	//Element initialization
	public LoginPage2 (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Elements declaration
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement PasswordTextField;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(css="[type='submit']")})
	private WebElement loginButton;
	
	public void loginToVtiger(String name, String pwd)
	{
		UserTextField.sendKeys(name);
		PasswordTextField.sendKeys(pwd);
		loginButton.click();
	}

}
