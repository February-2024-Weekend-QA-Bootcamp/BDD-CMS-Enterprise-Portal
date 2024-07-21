@forgotUserId
Feature: Forgot User ID
  As an User
  I want to use Forgot User ID feature from CMS Enterprise Portal Home Page
  In order to retrieve forgotten user id

  Background: User navigates to Application URL
    Given User is on the CMS Enterprise Portal page URL
  
  # Scenario  Outline is used when we have to test the scenario for multiple sets of data line 26-28  
  Scenario Outline: User click on Forgot User Id Button to retrieve user id
    When User click on Forgot User Id in Home Page
    Then User navigate to Forgot User ID page
    When User enter First Name <First Name>
    And User enter Last Name <Last Name>
    And Select Birth Month 'April'
    And Select Birth Date '03'
    And Select Birth Year '1980'
    And User enter email address 'tofael483@gmail.com'
    And User enter zip code '10019'
    And User click on Submit button
    Then User will receive a confirmation message for the change
    
    Examples:
    | First Name    |  Last Name  |
    | 'Mohammad' |  'Sharkar'     |
    | 'Michael'       |  'Bolt'           |
    | 'Pin'     				  |   'Xu'    	       |
    
    
    
    