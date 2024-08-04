package baseUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.Profile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ForgotUserId;
import pages.LogIn;
import pages.NewUserRegistration;
import utils.Configuration;
import static utils.IConstant.*;

import java.time.Duration;

public class BaseClass {
	public static WebDriver driver;
	Configuration configuration;
	// Make below static to avoid NullPointerException
	public static LogIn logIn; 
	public static NewUserRegistration newUserRegistration;
	public static ForgotUserId forgotUserId;
	
	// We don't use annotation here. Annotation is used in hook class
	// because step definition class extends base class, if base class contains annotation, 
	// it will show exception because step definition class contain annotation too
	public void setUp() {
		configuration = new Configuration(Profile.GENERAL);
		initDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(configuration.getProperties(URL));
		long pageLoadWait = Long.parseLong(configuration.getProperties(PAGELOAD_WAIT));
		long implicitlyWait = Long.parseLong(configuration.getProperties(IMPLICITLY_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
		initClass();		
	}

	public void initDriver() {
		String browserName = configuration.getProperties(BROWSER);

		switch (browserName) {

		case CHROME:
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver2.exe");
			driver = new FirefoxDriver();
			break;

		case EDGE:
			System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}

	}
		
	public void initClass() {
		logIn = new LogIn(driver);
		newUserRegistration = new NewUserRegistration(driver);
		forgotUserId = new ForgotUserId(driver);
	}
	
	public void tearUp() {
		driver.quit();
	}
		
		
		
	

}
