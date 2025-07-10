package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidateContactPage {
	
	public ValidateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateContactFirstNAme(WebDriver driver,String name)
	{
		String actdata = driver.findElement(By.id("dtlview_First Name")).getText();
//		if (actdata.contains(name)) {
//			System.out.println("contact first Name is Created " +name);
//		} else {
//
//			System.out.println("contact first name is not Created");
//		}
		
		Assert.assertEquals(actdata, name, "contact first name " +name+ " is not Created");
		System.out.println("contact first name " +name+ " is Created");
	}
	
	
	public void validateContactlastNAme(WebDriver driver,String name)
	{
		String actdata = driver.findElement(By.id("dtlview_Last Name")).getText();
//		if (actdata.contains(name)) {
//			System.out.println("contact last Name is Created " +name);
//		} else {
//
//			System.out.println("contact last is not Created");
//		}
		
		Assert.assertEquals(actdata, name, "contact last name " +name+ " is not Created");
		System.out.println("contact last name " +name+ " is Created");
	}

}
