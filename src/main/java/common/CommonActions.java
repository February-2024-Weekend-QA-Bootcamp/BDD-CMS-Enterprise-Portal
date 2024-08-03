package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.io.Files;
import constants.Attribute;

public class CommonActions {

	private static final Logger logger = LoggerFactory.getLogger(CommonActions.class);

	public static WebDriver driver;

	public CommonActions(WebDriver driver) {
		this.driver = driver;
	}

	public static void elementDisplayed(WebElement element) {

		try {
			boolean flag = element.isDisplayed();

			logger.info(element + "<---------> is Displayed, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			logger.info(element + "<----------> is not Displayed\n" + e.getMessage());
		}
	}

	// the below is called Java doc
	
	/**
	 * to verify the element is enable or disable
	 * @param element accept the web element
	 */
	public static void elementEnabled(WebElement element) {
		try {
			boolean flag = element.isEnabled();
			logger.info(element + "<---------> is Enabled, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			logger.info(element + "<----------> is not Displayed\n" + e.getMessage());
		}
	}

	public static void elementSelected(WebElement element) {
		try {
			boolean flag = element.isSelected();
			logger.info(element + "<---------> is Selected, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			logger.info(element + "<----------> is not Displayed\n" + e.getMessage());
		}
	}

	// I will think to change it
	public static void verifyTitle(WebDriver driver, String expectedTitle) {
		try {
			String actualTitle = driver.getTitle();
			logger.info("Actual Title is : " + actualTitle + " ---> And Expected Title is :" + expectedTitle);
			Assert.assertEquals(expectedTitle, actualTitle);
		} catch (NullPointerException e) {
			e.printStackTrace();
			logger.info("Driver is not initiated properly Or Home Page Title doesn't match");
			Assert.fail();
		}
	}

	public static void verifyCurrentUrl(WebDriver driver, String expectedURL) {
		String currentURL = driver.getCurrentUrl();
		logger.info("Current URL : " + currentURL + ", Expected URL : " + expectedURL);
		Assert.assertEquals("Current URL is not correct", expectedURL, currentURL);
	}

	public static void verifyTextOfTheWebElement(WebElement element, String expected) {
		String actual = element.getText();
		logger.info(element + " ---> Actual text : " + actual + ". Expected text : " + expected);
		Assert.assertEquals("Text In the WebElement doesn't match", expected, actual);
	}

	// common method for click ()
	public static void clickElement(WebElement element) {
		try {
			element.click();
			logger.info(element + "<---------> has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			// e.printStackTrace();
			System.out.println("Exception is: " + e);
			logger.info(element + "<----------> has not been found\n" + e.getMessage());
			// getMessage() Returns the detail message string of this throwable.
		}
	}

	// common method for sleep()
	public static void pause(long sec) {
		try {
			Thread.sleep(sec * 1000);
			logger.info("Sleeping ... zZz " + sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.info("Sleep interrupted");
		}
	}

	// common method for sendKeys()
	public static void inputText(WebElement element, String input) {
		try {
			element.sendKeys(input);
			logger.info(input + " <-----> has been put into <-----> " + element);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			logger.info(element + "<----------> has not been found\n" + e.getMessage());
		}
	}

	public static void clickUsingJavascriptExecutor(WebDriver driver, WebElement element) {
		// JavascriptExecutor js = (JavascriptExecutor)driver; // instead of writing
		// this 'js', we can write below one
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		logger.info("Javascript Executor CLICKING ... on element ---> " + element);
	}

	public static void scrollIntoViewUsingJavascriptExecutor(WebDriver driver, WebElement element) {
		// JavascriptExecutor js = (JavascriptExecutor)driver; // instead of writing
		// this 'js', we can write below one
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
		logger.info("Javascript Executor SCROLLING into view the element ---> " + element);
	}

	// we will use it for sending value by JavascriptExecutor
	public static void usingJavascriptExecutor(WebDriver driver, String script, WebElement element) {
		// JavascriptExecutor js = (JavascriptExecutor)driver; // instead of writing
		// this 'js', we can write below one
		((JavascriptExecutor) driver).executeScript(script, element);
		logger.info("Javascript Executor executing ..." + script + " on element ---> " + element);
	}

	public static void validationOfHeader(WebElement element, String expectedHeader) {
		String actualHeader = element.getText();
		Assert.assertEquals("Header doesn't match", expectedHeader, actualHeader);
		logger.info(element + " ---> Actual Header : " + actualHeader + ". Expected Header : " + expectedHeader);
	}

	public static void validationOfSubHeader(WebElement element, String expectedSubHeader) {
		String actualSubHeader = element.getText();
		Assert.assertEquals("Sub Header doesn't match", expectedSubHeader, actualSubHeader);
		logger.info(element + " ---> Actual Sub Header : " + actualSubHeader + ". Expected SubHeader : "
				+ expectedSubHeader);
	}

	public static void validationOfOtherHeader(WebElement element, String expectedOtherHeader) {
		String actualOtherHeader = element.getText();
		Assert.assertEquals("Other Header doesn't match", expectedOtherHeader, actualOtherHeader);
		logger.info(element + " ---> Actual Other Header : " + actualOtherHeader + ". Expected Other Header : "
				+ expectedOtherHeader);
	}

	// Attribute is coming from package constants, we will check the outcome later
	public static String getAttributeValue(WebElement element, Attribute attribute) {
		String atr = attribute.getTheAttribute();
		return element.getAttribute(atr);
	}

	public static void verifyAttribute01(WebElement element, Attribute attribute, String expectedValue) {
		String actualValue = getAttributeValue(element, attribute); // This method from above
		// element.getAttribute(attribute.toString());
		logger.info(element + " ---> We can Enter : " + actualValue
				+ " Character in the field which was similar with the Expected as: " + expectedValue);
		Assert.assertEquals(expectedValue, actualValue);
	}

	public static void verifyLengthOfTheFieldContent(WebElement element, String expected) {
		verifyAttribute01(element, Attribute.MAX_LENGTH, expected);
	}

	public static void inputTextThenClickTab(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.TAB);
			logger.info(input + " <-----> has been put into <-----> " + element + " and then clicked by Tab Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			logger.info(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}

	// Loggers is changed only
	public static void verifyAttribute02(WebElement element, Attribute attribute, String expectedErrorMsg) {
		String actual = getAttributeValue(element, attribute);
		// element.getAttribute(attribute.toString());
		logger.info(element + " ---> Actual Error Message is : " + actual + ". And Expected was: " + expectedErrorMsg);
		Assert.assertEquals(expectedErrorMsg, actual);
	}

	public static void verifyErrorMsgUnderTheField(WebElement element, String expectedErrorMsg) {
		verifyAttribute02(element, Attribute.INNER_TEXT, expectedErrorMsg); // "innerHTML"
	}

	public static void clearTextFromTheField(WebElement element) {
		try {
			element.clear();
			logger.info("The Text from the " + element + " ---> is cleared");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			logger.info(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}

	public static void selectElelementFromDropdownOnebyOne(WebElement element, List<WebElement> elements) {
		try {
			Select select = new Select(element);
			for (int i = 1; i < elements.size(); i++) {
				logger.info(elements.get(i).getText() + " is present in the dropdown");
				select.selectByIndex(i);
				pause(1);
			}
			logger.info("Total Element: " + (elements.size() - 1) + " is present in the dropdown");
		} catch (NullPointerException | NoSuchElementException e) { // elements er exception add korte hobe
			e.printStackTrace();
			logger.info(element + " : This element Not Found");
			Assert.fail();
		}
	}

	public static void selectDropdown(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
			logger.info(value + " has been selected from the dropdown of ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			logger.info(element + " : This element Not Found");
			Assert.fail();
		}
	}
	
	public static void selectDropdown2(WebElement element, String value, Keys key) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value + Keys.TAB);
			logger.info(value + " has been selected from the dropdown of ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			logger.info(element + " : This element Not Found");
			Assert.fail();
		}
	}

	public static void verifyAttribute03(WebElement element, Attribute attribute, String expectedErrorMsg) {
		String actual = getAttributeValue(element, attribute) + " is a required field.";
		// element.getAttribute(attribute.toString());
		logger.info(element + " ---> Actual Error Message is : " + actual + ". And Expected was: " + expectedErrorMsg);
		Assert.assertEquals(expectedErrorMsg, actual);
	}

	public static void verifyErrorMsgTopOfThePage(WebElement element, String expectedErrorMsg) {
		verifyAttribute03(element, Attribute.INNER_TEXT, expectedErrorMsg); // "innerHTML"
	}

	public static void clickElementThenTab(WebElement element) {
		try {
			element.sendKeys(Keys.TAB);
			logger.info(element + "<---------> has been clicked, then click Tab Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			logger.info(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}

	public static void inputTextThenClickEnter(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.ENTER);
			logger.info(input + " <-----> has been put into <-----> " + element + " and then clicked by Enter Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			logger.info(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}

	public static void inputTextThenClickReturn(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.RETURN);
			logger.info(input + " <-----> has been put into <-----> " + element + " and then clicked by Enter Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			logger.info(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}

	public static boolean isPresent(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		if (elements.size() != 0) {
			logger.info(elements + " --- > This element is present and has match of : " + elements.size());
			return true;
		} else {
			logger.info(elements + " --- > This element is NOT present and no match found : " + elements.size());
			return false;
		}
	}

	// very very important interview question
//	public static void failText() {
//		logger.info(getClass().getMethods()[0].getName() + " ---> has failed");
//		Assert.fail();
//	}

	// very very important interview question
	public static String getSreenShot(String testName, WebDriver driver) {
		TakesScreenshot ss = (TakesScreenshot) driver;
		String path = System.getProperty("user.dir") + "/test-output/screenShots";
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hh.mm.ss");
		String formattedDate = dateFormat.format(date);

		File targetFile = new File(path + "/error_" + testName + "_" + formattedDate + ".png");
		try {
			File srcFile = ss.getScreenshotAs(OutputType.FILE);
			Files.copy(srcFile, targetFile);
			logger.info("Screenshot has been successfully capture at: \n" + targetFile.getAbsolutePath());
		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
			logger.info("Screenshot cannot be captured");
		}
		return targetFile.getAbsolutePath();
	}

	public static void switchToChildWindow(WebDriver driver, WebElement element) {
		try {
			clickElement(element);
			Set<String> allWindowHandles = driver.getWindowHandles();
			logger.info("Total Windows Opened: " + allWindowHandles.size());
			String parent = (String) allWindowHandles.toArray()[0];
			String child = (String) allWindowHandles.toArray()[1];
			driver.switchTo().window(child);
			logger.info(" The Window moved to --> " + child);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			logger.info(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}

	public static void verifyErrorMsg(WebElement element, String expectedErrorMsg) {
		verifyAttribute02(element, Attribute.INNER_TEXT, expectedErrorMsg); // "innerHTML"
	}

}