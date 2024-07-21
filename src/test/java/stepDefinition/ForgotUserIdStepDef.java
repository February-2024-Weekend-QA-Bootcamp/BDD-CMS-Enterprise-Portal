package stepDefinition;

import baseUtil.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotUserIdStepDef extends BaseClass {
	@When("User click on Forgot User Id in Home Page")
	public void user_click_on_forgot_user_id_in_home_page() {
	  forgotUserId.landingOnhomePage();
	  forgotUserId.directingToForgotUserId();
	}

	@Then("User navigate to Forgot User ID page")
	public void user_navigate_to_forgot_user_id_page() {
	   forgotUserId.landingOnForgotUserId();
	}

	@When("User enter First Name {string}")
	public void user_enter_first_name(String string) {
	   forgotUserId.inputFirstname(string);
	}

	@When("User enter Last Name {string}")
	public void user_enter_last_name(String string) {
	    forgotUserId.inputLastname(string);
	}

	@When("Select Birth Month {string}")
	public void select_birth_month(String string) {
	    forgotUserId.selectBirthMonth(string);
	}

	@When("Select Birth Date {string}")
	public void select_birth_date(String string) {
	   forgotUserId.selectBirthDate(string);
	}

	@When("Select Birth Year {string}")
	public void select_birth_year(String string) {
	  forgotUserId.selectBirthYear(string);
	}

	@When("User enter email address {string}")
	public void user_enter_email_address(String string) {
	   forgotUserId.inputEmail(string);
	}

	@When("User enter zip code {string}")
	public void user_enter_zip_code(String string) {
	   forgotUserId.inputZipCode(string);
	}

	@When("User click on Submit button")
	public void user_click_on_submit_button() {
	    forgotUserId.clickSubmit();
	}

	@Then("User will receive a confirmation message for the change")
	public void user_will_receive_a_confirmation_message_for_the_change() {
	   forgotUserId.validationOfConfirmation();
	}



	



}
