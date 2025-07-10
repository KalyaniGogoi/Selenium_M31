package TestNg_Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	
	@Test
	public void m()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(false, true,"Assert Fail");
		System.out.println("Step3");
		System.out.println("Step4");
		soft.assertAll();
	}

}
