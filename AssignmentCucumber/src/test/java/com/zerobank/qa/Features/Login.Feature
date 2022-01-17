	Feature: Login functionality
  As a user I should be able to log into the application with only valid credentials
  and should get error message when entered invalid credentials in order to validate login feature.
 
  Background: Open browser, application and go to the LogIn page
   Given A browser initialized
   And Open application "http://zero.webappsecurity.com/"
    And I click on Signin button on home page
 

  @smoke
  Scenario: As a user with valid username and password I should be able to log into the application
    Given I am on login page
    When I enter user id as "username" and password as "password"
    And Click on Signin button
    Then I validate that I am able to log into the application and I land on Account summery page
 
 
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