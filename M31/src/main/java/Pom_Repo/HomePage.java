package Pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Element Initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Element Declarations
		@FindBy(linkText = "More")
		private WebElement moreLink;
		
		@FindBy(linkText = "Campaigns")
		private WebElement campaignsLink;

		@FindBy(linkText = "Organizations")
		private WebElement orgLink;
		
		@FindBy(linkText = "Products")
		private WebElement prdLink;
		
		@FindBy(linkText = "Contacts")
		private WebElement contactLink;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement AdmLink;
		
		@FindBy(linkText = "Sign Out")
		private WebElement signOutLink;
		
		//getter methods
		public WebElement getMoreLink() {
			return moreLink;
		}

		public WebElement getCampaignsLink() {
			return campaignsLink;
		}
		
		public WebElement getOrgLink() {
			return orgLink;
		}

		public WebElement getPrdLink() {
			return prdLink;
		}

	    public WebElement getContactLink() {
			return contactLink;
		}

		//Business Libraries
		/**
		 * This method is used to click Campaigns Link
		 */
		public void clickCampaignsLink()
		{
			moreLink.click();
			campaignsLink.click();
		}
		
		/**
		 * This method is used to click Organization Link
		 */
		public void clickOrgLink()
		{
			orgLink.click();
		}
		
		/**
		 * This method is used to click product Link
		 */
		public void clickProductLink()
		{
			prdLink.click();
		}
		
		/**
		 * This method is used to click contact Link
		 */
		public void clickContactLink()
		{
			contactLink.click();
		}
		
		/**
		 * This method is used to logout from Application
		 */
		public void logoutApp()
		{
			AdmLink.click();
			signOutLink.click();
		}

}
