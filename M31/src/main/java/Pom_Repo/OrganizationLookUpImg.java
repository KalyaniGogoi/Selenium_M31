package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationLookUpImg {
	
	public OrganizationLookUpImg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement lookUp;

	public WebElement getLookUp() {
		return lookUp;
	}
	
	public void clickOrgLookUp()
	{
		lookUp.click();
	}

}
