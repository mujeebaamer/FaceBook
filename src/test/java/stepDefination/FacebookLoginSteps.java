package stepDefination;

import basePackage.DriverContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FacebookLoginPage;

public class FacebookLoginSteps {

	FacebookLoginPage loginPage = new FacebookLoginPage();
	
	
	@When("I enter firstname as {string} and leaveout lastname as blank")
	public void i_enter_firstname_as_and_leaveout_lastname_as_blank(String firstname) {
		
		loginPage.EnterFirstName(firstname);  
	}

	@When("I click on signup button")
	public void i_click_on_signup_button() {
	 loginPage.clickonbutton();
	}

	@Then("i should see the error message related to lastname")
	public void i_should_see_the_error_message_related_to_lastname() {
	loginPage.LastNameErrorMessage();
	}
	
	@When("I enter firstname as blank and lastname as {string}")
	public void i_enter_firstname_as_blank_and_lastname_as(String lastname) {
	   loginPage.EnterLastName(lastname);
	}

	@Then("i should see the error message as {string}")
	public void i_should_see_the_error_message_as(String errorMessage) {
	   loginPage.verifyErrorMessage(errorMessage);
	}
	
	
	
}
