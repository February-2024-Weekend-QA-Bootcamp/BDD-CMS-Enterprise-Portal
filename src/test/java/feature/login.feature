# Author: tofael483@gmail.com
# Date: July 6th, 2024
@login
Feature: Log In
  As an User
  I want to Login with my credentials to CMS Enterprise Portal
  In order to get access of the Applications feature

  Background: User navigates to Application URL
    Given User is on the CMS Enterprise Portal page URL

  @smoke
  Scenario: Login with Valid Credential
    When User enter UserId in UserId field
    And User enter Password in Password field
    And User click the check box of I agree to the Terms and Conditions
    And User click on Login Button
    Then User will move to multi factor authentication modal

  @regression
  Scenario: Login with fixed Valid Credential
    When User enter UserId as 'enthrall_12'
    And User enter Password as 'OnthrallTest@1234'
    And User click the check box of I agree to the Terms and Conditions
    And User click on Login Button
    Then User will move to multi factor authentication modal

	@sanity
  Scenario Outline: Login with fixed Valid Credential
    When User enter UserId as <User Id>
    And User enter Password as <Password>
    And User click the check box of I agree to the Terms and Conditions
    And User click on Login Button
    Then User will move to multi factor authentication modal

    Examples: 
      | User Id         | Password            |
      | 'enthrall_12' | 'OnthrallTest@1234' |
      | 'Narima.tushty@gmail.com'  | 'Login@123456789' |
      | 'Pin_77'        | 'Xu@3212'           |
# This is imperative BDD, line by line description
