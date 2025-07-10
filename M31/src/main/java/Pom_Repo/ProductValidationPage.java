package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductValidationPage {
	
	public ProductValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * 
	 * @param driver
	 * @param name
	 */
	public void prdValidate(WebDriver driver,String name)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

//		if (actData.equals(name)) {
//			System.out.println("Product Name is Created");
//		} else {
//			System.out.println("Product name is not created");
//		}
		
		Assert.assertEquals(actData, name,"Product " +name+ " is not created");
		System.out.println("Product " +name+ " is created ");
	}
	
	

}
