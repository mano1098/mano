	Feature: Feedback functionality
  As a user I should be able to use feedback button and  want to provide the feedback about the zerobank experience whenver am using .
 
  Background: Open browser, application and go to the Home page
   Given A browser initialized
   And Open application "http://zero.webappsecurity.com/"
    And I click on feeback button on home page
 

  
  Scenario: As a user I should provide the feedback on the application
    Given I am on homepage page
    When I enter into the feebback button "
    And  Provide the feedback and Click on Signin button
    Then user fills the feedback form
 
 
  Scenario Outline: feedback submission with invalid data
Given I'm on the feedback page
When I enter <name>, <email>, <subject> and <comment>
And click on the 'send-message' button
Then I get the error message as "please fill out the fields"
 
Examples:
| name   | email                       | subject              | comment             |
| "mano"| --                              | "mano2"      | "invalid 1"|
| -      | "cucumber"     | "cucumber2"    | --                             | 