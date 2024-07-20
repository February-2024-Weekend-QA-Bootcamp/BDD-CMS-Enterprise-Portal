package stepDefinition;

import baseUtil.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewUserRegistrationStepDef extends BaseClass {

	@Given("User is on the CMS Enterprise Portal page")
	public void user_is_on_the_cms_enterprise_portal_page() {
	   newUserRegistration.landingOnhomePage();
	}
	
	@When("User click on New User Registration Button")
	public void user_click_on_new_user_registration_button() {
	   newUserRegistration.thenDirectingToNewUserRegistration();
	}

	@Then("User navigate to Step one of the enrollment process")
	public void user_navigate_to_step_one_of_the_enrollment_process() {
		newUserRegistration.navigateToStepOne();
	}
	
	@When("User click on Cancel Button on Step One")
	public void user_click_on_cancel_button_on_step_one() {
		 newUserRegistration.stepOneClickOnCancelButton();
	}
	
	@Then("User navigate to HomePage from Step One")
	public void user_navigate_to_home_page_from_step_one() {
		newUserRegistration.stepOneClickOnCancelButtonNavigateToHomePage();
	}

	@When("User complete Step one process")
	public void user_complete_step_one_process() {
	   newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
	}

	@Then("User navigate to Step two of the enrollment process")
	public void user_navigate_to_step_two_of_the_enrollment_process() {
		newUserRegistration.stepTwoTitleAndHeaderValidation();
	}
	
	@When("User click on Cancel Button on Step Two")
	public void user_click_on_cancel_button_on_step_two() {
	   newUserRegistration.stepTwoClickOnCancelButton();
	}
	
	@Then("User navigate to HomePage from Step Two")
	public void user_navigate_to_home_page_from_step_two() {
	   newUserRegistration.stepTwoClickOnCancelButtonNavigateToHomePage();
	}
	
	@When("User click on Back Button on Step Two")
	public void user_click_on_back_button_on_step_two() {
	    newUserRegistration.stepTwoClickOnBackButton();
	}

	@Then("User navigate to Step One")
	public void user_navigate_to_step_one() {
	    newUserRegistration.stepTwoClickOnBackButtonNavigateToStepOne();
	}
	
	@When("User click on Next Button without any data in fields")
	public void user_click_on_next_button_without_any_data_in_fields() {
		newUserRegistration.clickOnNextButtonInStep2();
	}

	@Then("User will see error message on the top of the page and under the required field")
	public void user_will_see_error_message_on_the_top_of_the_page_and_under_the_required_field() {
	    newUserRegistration.clickOnNextButtonInStep2WithoutAnyData();
	}

	@When("User complete Step two process")
	public void user_complete_step_two_process() {
	  newUserRegistration.untilClickOnNextButtonInStep2WithData();
	}
	
	@When("click on Next Button")
	public void click_on_next_button() {
		newUserRegistration.clickOnNextButtonInStep2();
	}

	@Then("User navigate to Step three of the enrollment process")
	public void user_navigate_to_step_three_of_the_enrollment_process() {
		newUserRegistration.stepThreeTitleAndHeaderValidation();
	}

}
