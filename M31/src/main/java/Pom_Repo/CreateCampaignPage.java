package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveButton;

	public WebElement getCampNAme() {
		return campName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This method is used to enter campagin Name
	 * @param name
	 */
	public void enterCampName(String name)
	{
		campName.sendKeys(name);
	}
	
	/**
	 * This method is used to click on save Button
	 */
	public void clickSaveButton()
	{
		saveButton.click();
	}

}
