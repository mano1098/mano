	Feature: AccountSummary functionality
  As a user of Zero bank,On sign in with valid creditials I should visit on Account Summary in order to check Account information and the remaining Balance 
  available in the account.
  Background: Open browser, application and go to the LogIn page
   Given A browser initialized
   And Open application "http://zero.webappsecurity.com/"
    And I click on Signin button on home page
 

 
  Scenario: Successful land on 'Account Summary' page of Zero Bank
When I click on Sign-in button
And I navigate to Login Page
And I enter Username as "username"
And I enter Password as "password"
And I click on 'Sign In' button
And I navigate to 'Account summary' page
Then I should see Account details and Balance in Account summary page
 
  Scenario Outline: As a user when I enter invalid userid and password into application
    then I should get an error message.
 
    Given I am on login page
    When I enter user id as <username> and password as <password>
    And Click on Signin button
    Then I validate that I get an error message "Login and/or password are wrong."
 
    Examples: 
      | username        | password     |
      | "name1"    | "pass1"    |
      |  ""        |    ""      |
      |    ""      | "pass1"    |
      | "name2"    |  ""        |
      | "12443"         | "@@%$%"    |