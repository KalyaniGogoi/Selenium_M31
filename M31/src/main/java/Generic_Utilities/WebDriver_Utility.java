package Generic_Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	
	/**
	 * This method will maximize the window.
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	
	/**
	 * This method will minimize the window.
	 * @param driver
	 */
	
	public void minimizeWindow (WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add implicitly wait for 10 seconds.
	 * @param driver
	 */
	
	public void addImplicitlyWait(WebDriver driver)
	
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for Webelement to be visible
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/** 
	 * This method will wait for 10 secs for the webelement to be clickable
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//PopUps, frame--------------------------------------------------------------------------------------
	
	/**
	 * This method is used to switch to any window based on window title
	 * @param driver
	 * @param partialTitle
	 */
	
	public void WindowSwitching(WebDriver driver, String partialTitle)
	{
		Set<String> allWin = driver.getWindowHandles();
		Iterator<String> it = allWin.iterator();
		
		while(it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			@Nullable
			String title = driver.getTitle();
			if(title.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method is used to switch to Frame Window based on index
	 * @param driver
	 * @param frameindex
	 */
	
	public void handleFrame(WebDriver driver, int frameindex)
	
	{
		driver.switchTo().frame(frameindex);
	}
	
	/**
	 * This method is used to switch to frame window based on name or id attribute
	 * @param driver
	 * @param frameNameOrId
	 */
	
	public void handleFrame(WebDriver driver, String frameNameOrId)
	
	{
		driver.switchTo().frame(frameNameOrId);
	}
	
	/**
	 * THis method will handle frame by frame element
	 * @param driver
	 * @param frameElement
	 */
	
    public void handleFrame(WebDriver driver, WebElement frameElement)
	
	{
		driver.switchTo().frame(frameElement);
	}
    
	
	  /**
     * This method will switch to immediate parent frame
     * @param driver
     */
    
    public void switchToParentFrame(WebDriver driver)
    
    {
    	driver.switchTo().parentFrame();
    }
    
    /**
     * THis method will switch to default frame
     * @param driver
     */
	
    public void switchToDefaultFrame(WebDriver driver)
    
    {
    	driver.switchTo().defaultContent();
    }
    
    /**
     * THis method will accept Alert pop up
     * @param driver
     */
	
	public void acceptAlert(WebDriver driver)
	
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss alert pop up
	 * @param driver
	 */
	
	public void dismissAlert(WebDriver driver)
	
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * THis method will enter data into alert pop up
	 * @param driver
	 * @param data
	 */
	
	public void enterAlertData(WebDriver driver, String data)
	
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
	/**
	 * This method will capture the text from alert pop up and return it to caller.
	 * @param driver
	 * @return
	 */
	
	public String getAlertText(WebDriver driver)
	
	{
		return driver.switchTo().alert().getText();	
	}
	
	/**
	 * THis method will switch to the required window
	 * @param driver
	 * @param windowId
	 */
	
	public void switchToWindow(WebDriver driver,String windowId)
	
	{
		driver.switchTo().window(windowId);
	}
	
	
	//Drop Down------------------------------------------------------------------------------------
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(WebElement element, int index)
	
	{
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by visible text
	 * @param element
	 * @param VisibleText
	 */
	
	public void handleDropDown(WebElement element, String VisibleText)
	
	{
		Select s= new Select(element);
		s.selectByVisibleText(VisibleText);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param value
	 * @param element
	 */
	
	public void handleDropDown(String value,WebElement element)
	
	{
		Select s= new Select(element);
		s.selectByValue(value);
	}
	
	//Mouse-------------------------------------------------------------------------------------
	
	/**
	 * This method will perform mouse hovering action on a web element.
	 * @param driver
	 * @param element
	 */
	
	public void mouseHoverAction(WebDriver driver, WebElement element)
	
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	// drag and drop, Double click, right click, release, scroll
	
	/**
	 * This method will perform drag and drop action on a web element
	 * @param driver
	 * @param scrEle
	 * @param tarEle
	 */
	
	public void dragAndDropAction(WebDriver driver, WebElement scrEle, WebElement tarEle)
	
	{
		Actions act= new Actions(driver);
		act.dragAndDrop(scrEle, tarEle).perform();
	}
	
	/**
	 * This method will perfrom double click action on a web element
	 * @param driver
	 * @param element
	 */
	
	public void doubleClickAction(WebDriver driver, WebElement element)
	
	{
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform click and hold action on a web element
	 * @param driver
	 * @param element
	 */
	
	public void clickAndHoldAction(WebDriver driver, WebElement element)
	
	{
		Actions act= new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	/**
	 * This method will perform release action on a web element
	 * @param driver
	 * @param element
	 */
	
	public void releaseAction(WebDriver driver, WebElement element)
	
	{
		Actions act= new Actions(driver);
		act.release(element).perform();
	}
	
	/**
	 * This method will perform scroll action on a web element
	 * @param driver
	 * @param element
	 */
	
	public void scrollAction(WebDriver driver, WebElement element)
	
	{
		Actions act= new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	/**
	 * This method will scroll down the page 
	 * @throws AWTException
	 */
	
	public void scrollDown() throws AWTException
	
	{
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		//r.keyPress(KeyEvent.VK_PAGE_UP);
		//r.keyRelease(KeyEvent.VK_PAGE_UP);
	}
	
	public static String takeSCreenShotEx(WebDriver driver,String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+screenShotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
		
	}	

}
