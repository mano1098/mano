	Feature: Search functionality
  As a user I should be able to use Search button for the desired result. 
 
  Background: Open browser, application and go to the Home page
   Given A browser initialized
   And Open application "http://zero.webappsecurity.com/"
    And I click on search button on home page
 

  
  Scenario: As a user i should see the search result for "Hello"
     Given I am on login page
    When I Enter the word Hello in search box
    Then I should get desired search result for hello
 
 
 