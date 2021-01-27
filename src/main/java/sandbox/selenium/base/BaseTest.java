package sandbox.selenium.base;

import static sandbox.selenium.log.LoggerHelper.logger;

//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import sandbox.selenium.util.Screenshot;

public class BaseTest {

	protected static WebDriver driver;
	protected static WorkingSet workingSet;
	
	String className = this.getClass().getSimpleName();

	@BeforeTest
	public void setUp() throws Exception {
		setupWebDriver();
		login();
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) throws Exception {
		String testName = className + "." + method.getName();
		logger.info("BEGIN TEST - " + testName + " -> STARTED****************************************");
	}

	@AfterMethod
	public void afterMethod(ITestResult result, Method method) throws Exception {
		String testName = className + "." + method.getName();
		if (ITestResult.FAILURE == result.getStatus()) {
			logger.error("END TEST - " + testName + " -> FAILED******************************************");
			Screenshot.takeScreenshot(driver, testName);
		} else {
			logger.info("END TEST - " + testName + " -> PASSED*******************************************\n");

		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		closeBrowser();
	}
	
	public void setupWebDriver() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chrome\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");

		// disabling message -> "Chrome is been controlled by automated test software"
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 

		// disabling save password prompt in chrome
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("safebrowsing.enabled", true);
		options.setExperimentalOption("prefs", prefs);

		// Creating new driver instance (browser is opening)
		driver = new ChromeDriver(options);
		workingSet = new WorkingSet(driver);

		// Maximize browser and setup implicitly wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void login() {
		logger.info("---------------LOGIN START---------------");
		workingSet.basePage.navigateUrl();
		workingSet.login.initialLogin();
		logger.info("----------------LOGIN END----------------\n");
	}

	public void closeBrowser() {
		workingSet.basePage.waitFor(1000);
		driver.quit();
	}

}
