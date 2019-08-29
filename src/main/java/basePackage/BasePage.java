package basePackage;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.DriverContext;

public abstract class BasePage {

	 private static final int TIMEOUT = 5;
	    private static final int POLLING = 100;
	    protected WebDriverWait wait;
	    protected Actions actions=new Actions(DriverContext.Driver);
	    

	    public BasePage() {
	         wait = new WebDriverWait(DriverContext.Driver, TIMEOUT, POLLING);
	        PageFactory.initElements(new AjaxElementLocatorFactory(DriverContext.Driver, TIMEOUT), this);
	    }

	   
}
