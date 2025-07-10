package Pom_Repo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage {
	
	public DeleteProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[value='Delete']")
	private WebElement deleteButton;
	
	/**
	 * 
	 * @param driver
	 * @param name
	 */
	public void selectPrdCheckBox(WebDriver driver,String prdName)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + prdName
				+ "']/../preceding-sibling::td[2]//input[@type=\"checkbox\"]")).click();
	}
	/**
	 * 
	 */
	public void clickDeleteButton()
	{
		deleteButton.click();
	}
	/**
	 * 
	 * @param driver
	 * @param productName
	 */
	public void validatePrdDeleted(WebDriver driver,String productName)
	{
		List<WebElement> prdData = driver
				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));

		boolean flag = false;
		for (WebElement prd : prdData) {
			String actPrd = prd.getText();
			if (actPrd.contains(productName)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Product " +productName+ " is Deleted");
		} else {
			System.out.println("Product " +productName+ " is not Deleted");
		}
	}
	

}
