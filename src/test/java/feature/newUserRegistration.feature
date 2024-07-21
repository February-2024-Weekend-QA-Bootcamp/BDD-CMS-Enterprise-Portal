#Author: tofael483@gmail.com
#Date: July 6th, 2024
@newUserRegistration
Feature: As an user
  I want to enroll as a new user to CMS Enterprise Portal
  In order to get access of the Applications feature

  Background: User navigates to Application URL
    Given User is on the CMS Enterprise Portal page

# This is declarative BDD, not line by line description 

  Scenario: User click on Next Button in Step Two puting value in each field
    When User click on New User Registration Button
    Then User navigate to Step one of the enrollment process
    When User complete Step one process
    Then User navigate to Step two of the enrollment process
    When User complete Step two process 
    And click on Next Button
    Then User navigate to Step three of the enrollment process
  
  @smoke  
  Scenario: User click on Cancel Button in Step One
    When User click on New User Registration Button
    Then User navigate to Step one of the enrollment process
    When User click on Cancel Button on Step One
    Then User navigate to HomePage from Step One
    
  Scenario: User click on Cancel Button in Step Two
    When User click on New User Registration Button
    Then User navigate to Step one of the enrollment process
    When User complete Step one process
    Then User navigate to Step two of the enrollment process
    When User click on Cancel Button on Step Two
    Then User navigate to HomePage from Step Two  
    
  Scenario: User click on Back Button in Step Two
    When User click on New User Registration Button
    Then User navigate to Step one of the enrollment process
    When User complete Step one process
    Then User navigate to Step two of the enrollment process
    When User click on Back Button on Step Two
    Then User navigate to Step One
    
  Scenario: User click on Next Button in Step Two without puting value in each field
    When User click on New User Registration Button
    Then User navigate to Step one of the enrollment process
    When User complete Step one process
    Then User navigate to Step two of the enrollment process
    When User click on Next Button without any data in fields
    Then User will see error message on the top of the page and under the required field
