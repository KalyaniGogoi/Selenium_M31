package TestNg_Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class SampleTest {
	
	/*
	//@Test
	//@Ignore //this method will not be executed
	@Test(priority=1)
	@Test(invocationCount = 0)// it will not get executed
	@Test(invocationCount = 0) //error
	*/
	@Test(invocationCount = 3)
	public void createProduct()
	{
		System.out.println("Product is created");
	}
	
	/*
	@Test(dependsOnMethods= "createProduct", priority=0) // here the priority will not affect the order of execution as dependsOnMethods will take the lead
	@Test(enabled=true)
	@Test(enabled=false) //this method will not be executed
	@Test(priority=0)
	 * 
	 */
	
	@Test(dependsOnMethods= {"createProduct","deleteProduct"})
	public void modifyProduct()
	{
		System.out.println("Product is modified");
	}
	
	/*
	@Test(dependsOnMethods= "createProduct", priority=-1)
	//@Test(priority=0)
	 * 
	 */
	
	@Test(dependsOnMethods= "createProduct")
	//@Test(dependsOnMethods= {"createProduct","modifyProduct"})
	public void deleteProduct()
	{
		System.out.println("Product is deleted");
	}

}
