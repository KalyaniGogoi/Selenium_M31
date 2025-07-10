package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidateOrgPage {
	
	public ValidateOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateOrg(WebDriver driver,String name)
	{
		String actdata = driver.findElement(By.id("dtlview_Organization Name")).getText();
//		if (actdata.contains(name)) 
//		{
//			System.out.println("Organization Name is Created " +actdata);
//		} 
//		else 
//		{
//
//			System.out.println("Organization Name is not Created");
//		}
		
		Assert.assertEquals(actdata, name, "Organization Name "+name+ " is not Created");
		System.out.println("Organization Name " +actdata+ " is Created ");
	}

}
