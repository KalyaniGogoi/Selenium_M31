package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitchContactWithOrg {
	public WindowSwitchContactWithOrg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement orgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement orgName;
	
	@FindBy(name = "search")
	private WebElement searchBar;

	public WebElement getOrgLookUpImg() {
		return getOrgLookUpImg();
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}
	public void clickOrgLookUpInCon()
	{
		orgLookUpImg.click();
	}
	public void enterOrgDetails(String name)
	{
		orgName.sendKeys(name);
		searchBar.click();
	}
	
	public void enterOrgNameInContact(WebDriver driver,String orgName)
	{
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	}
	
}
