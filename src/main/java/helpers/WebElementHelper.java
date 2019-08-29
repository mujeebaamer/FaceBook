package helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import basePackage.DriverContext;



public class WebElementHelper {

		
	public static void WaitForElementPresent(WebElement webElement)
	{
		DriverContext.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(DriverContext.Driver, 10);
		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
		  try {
			  webElement.isDisplayed();
		     return true;
		  }
		  catch (NoSuchElementException e ) {
			LogHelpers.info(e.getMessage());
		    return false;
		  }
		  catch (StaleElementReferenceException f) {
			  LogHelpers.info(f.getMessage());
		    return false;
		  }
		    }
		};
		wait.until(elementIsDisplayed);
		DriverContext.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public static void WaitForElementNotVisible(WebElement webElement)
	{
		DriverContext.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(DriverContext.Driver, 10);
		ExpectedCondition<Boolean> elementIsNotDisplayed = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
		  try {
			  
			return !( webElement.isDisplayed());			 
		    
		  }
		  catch (NoSuchElementException e ) {
			LogHelpers.info(e.getMessage());
		    return false;
		  }
		  catch (StaleElementReferenceException f) {
			LogHelpers.info(f.getMessage());  
		    return false;
		  }
		    }
		};
		
		wait.until(elementIsNotDisplayed);
		DriverContext.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void scrollIntoView(WebElement ele) {
	    ((JavascriptExecutor)DriverContext.Driver).executeScript("window.scrollTo(" + ele.getLocation().x + "," + ele.getLocation().y + ")");
	}
	
	public static void waitUntilValueIsSelected(final WebDriver driver, WebElement Element, final String value) {
		final FluentWait<WebDriver> wait = new FluentWait<>(DriverContext.Driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
				.ignoring(NoSuchElementException.class);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver webDriver) {
				try {
					
					new Select(Element).selectByValue(value);
					return Element.getAttribute("value").equals(value);
				} catch (final StaleElementReferenceException e) {
					LogHelpers.info(e.getMessage()); 
					return false;
				}
			}
		});
	}
	
	public static void waitUntilTextIsSelected(final WebDriver driver, WebElement Element, final String text) {
		final FluentWait<WebDriver> wait = new FluentWait<>(DriverContext.Driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
				.ignoring(NoSuchElementException.class);

		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver webDriver) {
				try {
					new Select(Element).selectByVisibleText(text);
					return Element.getAttribute("value").equals(text);
				} catch (final StaleElementReferenceException e) {
					LogHelpers.info(e.getMessage());
					return false;
				}
			}
		});
	}
	
	public static void JavaScriptClick(WebElement Element)
	{
		try
		{
			WebElement element = Element;
			JavascriptExecutor executor = (JavascriptExecutor)DriverContext.Driver;
			executor.executeScript("arguments[0].click();", element);
		}
		catch (NoSuchElementException e )
		{
			LogHelpers.info(e.getMessage()); 
		    
		}
		catch (StaleElementReferenceException f) 
		{
			LogHelpers.info(f.getMessage()); 
		   
		}
		
	}
	

}
