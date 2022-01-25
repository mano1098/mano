	Feature: Login functionality
  As a user I should be able to log into the application with only valid credentials
  and should be able to create a candidate in recruitement tab.
 
  Background: Open browser, application and go to the LogIn page
   Given A browser initialized
   And Open application "https://opensource-demo.orangehrmlive.com/"
    

  @smoke
  Scenario: As a user with valid username and password I should be able to log into the application
    Given I am on login page
    When I enter user id as "username" and password as "password"
    And Click on Signin button
    And user creates a user in recruitement
    Then user validates whether the user is created
 
 