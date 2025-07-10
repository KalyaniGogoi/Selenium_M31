package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class CreateContactPage {
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "firstname")
	private WebElement Contactname;
	
	@FindBy(name = "lastname")
	private WebElement contactLastNAme;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public void selectDropDown(WebDriver driver)
	{
		WebElement dropDown = driver.findElement(By.xpath("//select[@name=\"salutationtype\"]"));

        WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.handleDropDown(dropDown, "Ms.");
	}
	
	public void enterContactData(String firstName,String lastName)
	{
		Contactname.sendKeys(firstName);
		contactLastNAme.sendKeys(lastName);
		//saveButton.click();
	}
	public void saveBtn()
	{
		saveButton.click();
	}

}
