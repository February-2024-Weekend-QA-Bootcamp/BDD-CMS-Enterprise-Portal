#Author: tofael483@gmail.com
#Date: July 6th, 2024
@login @smoke
Feature: Log In
  As an User
  I want to Login with my credentials to CMS Enterprise Portal
  In order to get access of the Applications feature

  Background: User navigates to Application URL
    Given User is on the CMS Enterprise Portal page URL

  Scenario: Login with Valid Credential
    When User enter UserId in UserId field
    And User enter Password in Password field
    And User click the check box of I agree to the Terms and Conditions
    And User click on Login Button
    Then User will move to multi factor authentication modal
# This is imperative BDD, line by line description
