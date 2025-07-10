package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactLookUpImgPage {
	
	public ContactLookUpImgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[alt='Create Contact...']")
	private WebElement lookUp;

	
	public WebElement getLookUp() {
		return lookUp;
	}
	
	public void clickLookUp()
	{
		lookUp.click();
	}

}
