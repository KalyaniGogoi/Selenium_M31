package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreatePage {
	
	public OrganizationCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(name = "phone")
	private WebElement orgPhn;
	
	@FindBy(id = "email1")
	private WebElement orgEmail;

	@FindBy(css = "[title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getPhnNum() {
		return orgPhn;
	}

	public WebElement getMailId() {
		return orgEmail;
	}
	/**
	 * 
	 * @param name
	 * @param PhoneNum
	 * @param email
	 */
	public void enterOrgnaizationData(String name,String PhoneNum,String email)
	
	{
		orgName.sendKeys(name);
		orgPhn.sendKeys(PhoneNum);
		orgEmail.sendKeys(email);
		saveButton.click();
	}

}
