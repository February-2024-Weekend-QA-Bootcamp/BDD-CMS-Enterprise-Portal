package common;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommonWaits {
	private static final Logger logger = LoggerFactory.getLogger(CommonActions.class);
	static WebDriver driver;
	static WebDriverWait wait;
	
	public CommonWaits(WebDriverWait wait) {
		CommonWaits.wait = wait;
	}
	
	public static void waitThenClick(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			logger.info("The element was clickable and here it clicked ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			logger.info(element + "<----------> has not been found\n");
			Assert.fail();
		}
	}
}