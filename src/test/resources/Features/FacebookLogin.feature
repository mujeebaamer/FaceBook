Feature: Testing Facebook login functionality


Scenario: Testing the lastname error message
Given I have navigated to facebook website
When I enter firstname as "Mujeeb" and leaveout lastname as blank
And I click on signup button
Then i should see the error message related to lastname  
 
 
 Scenario: Testing the firstname error message
Given I have navigated to facebook website
When I enter firstname as blank and lastname as "muhammad"
And I click on signup button
Then i should see the error message as "What's your name?"  
 