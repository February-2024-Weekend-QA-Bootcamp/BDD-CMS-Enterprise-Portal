#Author: tofael483@gmail.com

@Login
Feature: Log In
As an User
I want to Login with my credentials to CMS Enterprise Portal
In order to get access of the Applications feature

Background: User navigates to Application URL
									Given User is on the CMS Enterprise Portal page URL "https://portal.cms.gov/portal/"
									Then User should validate the Title and Logo of the Application
									
Scenario: Login with Valid Credential
									When User enter UserId in UserId field as "enthrall_12"
									And User enter Password in Password field as "OnthrallTest@1234"
									And User click the check box of I agree to the Terms and Conditions
									And User click on Login Button
									Then User will move to multi factor authentication modal

  
# This is imperative BDD, line by line description