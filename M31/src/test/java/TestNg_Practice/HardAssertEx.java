package TestNg_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	
	@Test
	public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(true, true); //Assertion pass
		//Assert.assertEquals(true, false); //Assertion fail
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	@Test
	public void m2()
	{
		String expData="Qspiders";
		String actData="Qspiders";
		Assert.assertEquals(actData, expData);
	}
	
	@Test
	public void m3()
	{
		String expData="A";
		String actData= "A";
		Assert.assertEquals(expData, actData, "Assert Fail");
		System.out.println("Assert pass");
	}
	
	@Test
	public void m4()
	{
		int expData=10;
		int actData= 20;
		Assert.assertEquals(expData, actData, "Assert Fail");
		System.out.println("Assert pass");
	}
	
	@Test
	public void m5()
	{
		int expData=10;
		int actData= 20;
		Assert.assertNotEquals(expData,actData, "Assert equal");
		System.out.println("Assert not equal");
	}
	
	@Test
	public void m6()
	{
		String expData= "Kalyani";
		String actData= "Kalyani";
		Assert.assertTrue(actData.equals(expData), "Assert FAIL");
		System.out.println("Assert pass");
	}
	
	@Test
	public void m7()
	{
		String expData= "Kalyani";
		String actData= "KalyanI";
		Assert.assertTrue(actData.equals(expData), "Assert FAIL");
		System.out.println("Assert pass");
	}
	
	@Test
	public void m8()
	{
		String expData= "Hi";
		String actData= "Hello";
		Assert.assertFalse(actData.equals(expData), "Assert FAIL");
		System.out.println("Assert pass");	
	}
	
	@Test
	public void m9()
	{
		String expData= "Hi";
		String actData= "Hi";
		Assert.assertFalse(actData.equals(expData), "Assert FAIL");
		System.out.println("Assert pass");	
	}
	
	@Test
	public void m10()
	{
		String s= null;
		Assert.assertNull(s, "Assert FAIL");
		System.out.println("Assert pass");
	}
	
	@Test
	public void m11()
	{
		String s= "QSP";
		Assert.assertNull(s, "Assert FAIL");
		System.out.println("Assert pass");
	}
	
	@Test
	public void m12()
	{
		String s="QSP"; //s is not null so the condition "NotNull" is satisfying
		Assert.assertNotNull(s, "Assert FAIL");
		System.out.println("Assert pass");
	}
	
	@Test
	public void m13()
	{
		String s=null; // s is null so the condition "NotNull" is not satisfying
		Assert.assertNotNull(s, "Assert FAIL");
		System.out.println("Assert pass");
	}
	
	@Test
	public void m14()
	{
		int exp= 10;
		int act= 10;
		Assert.assertSame(exp,act, "Assert FAIL");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m15()
	{
		int exp= 10;
		int act= 20;
		Assert.assertSame(exp,act, "Assert FAIL");
		System.out.println("Assert Pass");
	}
	
	
	@Test
	public void m16()
	{
		int exp= 10;
		int act= 20; //exp and act are not same so the condition "NotSame" is satisfied
		Assert.assertNotSame(exp, act, "Assert FAIL");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m17()
	{
		int exp= 10;
		int act= 10; // exp and act are same so the condition "NotSame" is not satisfied
		Assert.assertNotSame(exp, act, "Assert FAIL");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m18()
	{
		Assert.fail("I am failing the script");
	}
}

