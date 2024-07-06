#Author: tofael483@gmail.com

@newUserRegistration

Feature: As an user
I want to enroll as a new user to CMS Enterprise Portal
In order to get access of the Applications feature

Background: User navigates to Application URL
									Given User is on the CMS Enterprise Portal page URL "https://portal.cms.gov/portal/"
									Then User should validate the Title and Logo of the Application
									
Scenario: New User Registration
									When User click on New User Registration Button
									Then User navigate to Step one of the enrollment process
									When User complete Step one process
									Then User navigate to Step two of the enrollment process
									When User complete Step two process
									Then User navigate to Step three of the enrollment process
									
# This is declarative BDD, not line by line description 