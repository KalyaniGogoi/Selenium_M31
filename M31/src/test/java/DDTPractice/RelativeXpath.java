package DDTPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeXpath {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);

//		driver.findElement(By.xpath("//a[text()='Log in']")).click();
//        driver.findElement(By.xpath("//input[@value='Log in']")).click();
//----------------------------------------------------------------------------------------------------------	
		// start-with()
		// syntax1:- //htmltag[starts-with(@AttributeName='AttributeValue')]
		// syntax2:- //htmltag[start-with(text(),'VisibleText')]

//	String msg = driver.findElement(By.xpath("//span[starts-with(text(),'Login was ')]")).getText();
//	System.out.println(msg);

		// ends-with will not support all the elements
		// syntax1:- //htmltag[ends-with(@AttributeName='AttributeValue')]
		// syntax2:- //htmltag[ends-with(text(),'VisibleText')]
//	driver.findElement(By.xpath("//span[ends-with(text(),'try again.')]"));
//-----------------------------------------------------------------------------------------------------------	
		// Relative Locator
		// *above()
		// *below()
		// *toLeftOf()
		// *toRightOf()
		// *near()

		//near
		//syntax:- driver.findElement(RelativeLocator.with(By.tagName(" ")).near(ref));
//        WebElement searchBar = driver.findElement(By.xpath("//input[@value='Search store']"));
//        driver.findElement(RelativeLocator.with(By.tagName("input")).near(searchBar)).click();
     
//		driver.findElement(By.xpath("//a[text()='Log in']")).click();
//      driver.findElement(By.xpath("//input[@value='Log in']")).click();
        
		//toRightOf()
		//syntax:- driver.findElement(RelativeLocator.with(By.tagName(" ")).toRightOf(ref));
		
//		WebElement searchBar = driver.findElement(By.xpath("//input[@value='Search store']"));
//      driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(searchBar)).click();
		
		//toLeftOf()
	    //syntax:- driver.findElement(RelativeLocator.with(By.tagName(" ")).toLeftOf(ref));
//		WebElement searchIcon = driver.findElement(By.xpath("//input[@value=\"Search\"]"));
//		driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(searchIcon)).sendKeys("Book");
	
		//above()
		//syntax:- driver.findElement(RelativeLocator.with(By.tagName(" ")).above(ref));
//		WebElement PassWordTxt = driver.findElement(By.xpath("//input[@name='Password']"));
//	    driver.findElement(RelativeLocator.with(By.tagName("input")).above(PassWordTxt)).sendKeys("mailto:abc@gmail.com");
	
		//below
		//syntax:- driver.findElement(RelativeLocator.with(By.tagName(" ")).below(ref));
//	    WebElement emailTxt = driver.findElement(http://By.id("Email"));
//	    driver.findElement(RelativeLocator.with(By.tagName("input")).below(emailTxt)).sendKeys("root");    
	  
	}

	}


