package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import basePackage.BasePage;
import basePackage.DriverContext;
import helpers.LogHelpers;
import helpers.WebElementHelper;

public class FacebookLoginPage  extends BasePage {
	
	@FindBy(name = "firstname") WebElement fname;
	@FindBy(name = "lastname") WebElement lname;
	@FindBy(name = "websubmit") WebElement submitbutton;
	@FindBy(xpath = "//div[@class='uiContextualLayer uiContextualLayerBelowLeft']/div/div") WebElement LastNameErrorMessage;
	@FindBy(xpath = "//div[@class='uiContextualLayer uiContextualLayerLeft']/div/div") WebElement FirstNameErrorMessage;


	
	public void EnterFirstName(String firstname) {
		
		WebElementHelper.WaitForElementPresent(fname);
		fname.sendKeys(firstname);
		LogHelpers.info("Entering firstname as :"+firstname);
			
	}
	
public void EnterLastName(String lastName) {
		
		WebElementHelper.WaitForElementPresent(lname);
		lname.sendKeys(lastName);
		LogHelpers.info("Entering lastName as :"+lastName);
			
	}
	
	
	public void clickonbutton() {
		
		WebElementHelper.WaitForElementPresent(submitbutton);
		submitbutton.click();
		DriverContext.waitForPageLoaded();
		LogHelpers.info("Clicked on Sign up button");
	}
	
	public void LastNameErrorMessage() {
		
		WebElementHelper.WaitForElementPresent(LastNameErrorMessage);
		String ExpectedErrorMessage = "What's your name?";
		String ActualErrorMessage = LastNameErrorMessage.getText();
		Assert.assertEquals(ExpectedErrorMessage, ActualErrorMessage);
		LogHelpers.info("Successfully verified LastName Error message: "+ActualErrorMessage);
		
	}
	
public void verifyErrorMessage(String errorMessage) {
		
		WebElementHelper.WaitForElementPresent(FirstNameErrorMessage);
		String ExpectedErrorMessage = errorMessage;
		String ActualErrorMessage = FirstNameErrorMessage.getText();
		Assert.assertEquals(ExpectedErrorMessage, ActualErrorMessage);
		LogHelpers.info("Successfully verified FirstName Error message: "+ActualErrorMessage);
		
	}


}
