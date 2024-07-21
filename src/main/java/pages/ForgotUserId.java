package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static common.CommonActions.*;

import java.util.List;

public class ForgotUserId {
	public WebDriver driver;
	public Select select;

	public ForgotUserId(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//em[@id='cms-homepage-header-logo-unauth']//parent::a//parent::div//parent::nav")
	WebElement logo;
	
	@FindBy(xpath = "//a[contains(text(), 'User I')]")
	WebElement forgetUserid;
	
	@FindBy(xpath = "//h1[contains(text(), 'Forgot User ID')]")
	WebElement forgotUserIdHeader;
	
	@FindBy(xpath = "//p[contains(text(), 'Please e')]")
	WebElement forgotUserIdSubHeader;
		
	@FindBy(xpath = "//p[contains(@id, 'cms-allfields-req')]")
	WebElement allFieldsRequired;
	
	@FindBy(xpath = "//input[contains(@id, 'cms-forgotid-fi')]")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='cms-forgotid-lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//select[@name='cms-forgotid-birthDate']")
	WebElement birthDate;
	
	@FindBy(xpath = "//select[@id='cms-forgotid-birthYear']")
	WebElement birthYear;
	
	@FindBy(xpath = "//select[contains(@name, 'cms-forgotid-birthM')]")
	WebElement birthMonth;
	
	@FindBy(xpath = "//select[@name='cms-forgotid-birthMonth']//option")
	List<WebElement> birthMonthList;
	
	@FindBy(xpath = "//input[@id='cms-forgotid-forgotEmail']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='cms-forgotid-usZipCode']")
	WebElement zipCode;
	
	@FindBy(xpath = "//button[contains(text(), 'Su')]")
	WebElement submitButton;
	
	@FindBy(xpath = "//h2[text()='Confirmation ']")
	WebElement confirmationHeader;
	
	@FindBy(xpath = "//span[@id='happyDIV']")
	WebElement confirmationMessage;
	
	
	public void landingOnhomePage() {
		elementDisplayed(logo);
		verifyTitle(driver, "CMS Enterprise Portal");
		pause(3);	
	}
	
	public void directingToForgotUserId() {
		elementEnabled(forgetUserid);
		verifyTextOfTheWebElement(forgetUserid, "User ID");
		clickElement(forgetUserid);
		pause(3);	
	}
	
	public void landingOnForgotUserId() {
		verifyTitle(driver, "CMS Enterprise Portal - Forgot User ID");
		verifyCurrentUrl(driver, "https://portal.cms.gov/portal/forgotuserid");
		validationOfHeader(forgotUserIdHeader, "Forgot User ID");
		validationOfSubHeader(forgotUserIdSubHeader, "Please enter the following information to retrieve your User ID.");
		validationOfOtherHeader(allFieldsRequired, "All fields are required.");
		pause(3);
	}
	
	public void inputFirstname(String fName) {
		inputText(firstName, fName);
	}
	
	public void inputLastname(String lName) {
		inputText(lastName, lName);
	}
	
	public void selectBirthMonth(String bMonth) {
		selectDropdown(birthMonth, bMonth);
		inputTextThenClickTab(birthMonth, "");
		pause(3);
	}
	
	public void selectBirthDate(String bDate) {
		inputTextThenClickTab(birthDate, "");
		inputTextThenClickTab(birthMonth, "");
		selectDropdown(birthDate, bDate);
	}
	
	public void selectBirthYear(String bYear) {
		selectDropdown(birthYear, bYear);
	}
	
	public void inputEmail(String em) {
		inputText(email, em);
	}
	
	public void inputZipCode(String zc) {
		inputText(zipCode, zc);
	}
	
	public void clickSubmit() {
		clickElement(submitButton);
	}
	
	public void validationOfConfirmation() {
		validationOfHeader(confirmationHeader, "Confirmation");
		verifyTextOfTheWebElement(confirmationMessage, "Your request has been received, if the information provided matches your account profile then a message will be sent to your email account for the requested information. You can now login.");
	}
	


}