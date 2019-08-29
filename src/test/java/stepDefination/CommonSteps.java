package stepDefination;

import basePackage.DriverContext;
import cucumber.api.java.en.Given;

public class CommonSteps {

	
	@Given("I have navigated to facebook website")
	public void i_have_navigated_to_facebook_website() {
	   DriverContext.Driver.get("https://www.facebook.com/");
	}
	
}
