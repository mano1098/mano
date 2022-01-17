	Feature: fundtransfer functionality
  As a user, I should be able to use transfer funds option to transfer money to different accounts.
  Background: Open browser, application and go to the LogIn page
   Given A browser initialized
   And Open application "http://zero.webappsecurity.com/"
    And I click on Signin button on homepage
 

  
  Scenario: As a user with valid username and password I should be able to log into the application and successfully transfer amount in transfer funds.
    Given  I am on Account Summary Page

When I click on Transfer Funds
And I enter amount as “800”
And I enter from Account as “Current”
And I enter To Amount as “Savings”
And I enter Description as “My Savings”
And click on submit button
Then I should get message “You successfully transferred money
 
  Scenario Outline: As a user I should not to be able to enter the special characters in the amount field.
 
    
 Given  I am on Account Summary Page

When I click on Transfer Funds
And I enter amount as “@#$%”
And I enter from Account as “Current”
And I enter To Amount as “Savings”
And I enter Description as “My Savings”
And click on submit button
Then I should receive the error message

   