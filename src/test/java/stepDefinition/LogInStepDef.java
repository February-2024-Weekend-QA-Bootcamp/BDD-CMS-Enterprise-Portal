package stepDefinition;

import baseUtil.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInStepDef extends BaseClass {
	@Given("User is on the CMS Enterprise Portal page URL")
	public void user_is_on_the_cms_enterprise_portal_page_url() {
	    logIn.validateLogoAndTitle();
	    logIn.validateLogInModal();
	}

	@When("User enter UserId in UserId field")
	public void user_enter_user_id_in_user_id_field() {
	   logIn.validateUserId();
	}

	@When("User enter Password in Password field")
	public void user_enter_password_in_password_field() {
	   logIn.validatePassword();
	}
	
	@When("User enter UserId as {string}")
	public void user_enter_user_id_as(String string) {
	    logIn.validateUserId(string);
	}

	@When("User enter Password as {string}")
	public void user_enter_password_as(String string) {
	   logIn.validatePassword(string);
	}

	@When("User click the check box of I agree to the Terms and Conditions")
	public void user_click_the_check_box_of_i_agree_to_the_terms_and_conditions() {
	   logIn.validateCheckBox();
	}

	@When("User click on Login Button")
	public void user_click_on_login_button() {
	   logIn.validateLogin();
	}

	@Then("User will move to multi factor authentication modal")
	public void user_will_move_to_multi_factor_authentication_modal() {
	   logIn.landingOnMultiFactorAuthentication();
	}




}
