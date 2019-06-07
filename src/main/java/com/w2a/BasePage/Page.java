package com.w2a.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.Utilities;

public class Page {

	public static WebDriver driver;

	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fileInputStream;

	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "//src//test//resources//com//w2a//excel//TestData.xlsx");

	public static Logger log = Logger.getLogger("devpinoyLogger");

	public static WebDriverWait wait;

	public static ExtentReports extentReports = ExtentManager.getInstance();
	public static ExtentTest test;

	public static String browser;
	public static TopMenu topMenu;

	/*
	 * WebDriver 
	 * Logs - Log4j jar log4j.properties 
	 * Properties - OR, Configuration (Browser, Site URL, implicit.wait) 
	 * Extent Reports
	 * DB 
	 * Excel 
	 * Implicit and Explicit Wait
	 * Mail 
	 * ReportNG 
	 * Jenkins
	 * 
	 * 
	 * 
	 * 
	 */

	public Page() {

		if (driver == null) {

			try {
				fileInputStream = new FileInputStream(System.getProperty("user.dir")
						+ "//src//test//resources//com//w2a//properties//Config.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				config.load(fileInputStream);
			} catch (IOException e) {

				e.printStackTrace();
			}

			log.debug("Config file loaded...");

			try {
				fileInputStream = new FileInputStream(
						System.getProperty("user.dir") + "//src//test//resources//com//w2a//properties//OR.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			try {
				OR.load(fileInputStream);
			} catch (IOException e) {

				e.printStackTrace();
			}

			log.debug("Object Repository file loaded...");

			// Jenkins browser filter configuration

			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");

			} else {

				browser = config.getProperty("browser");

			}

			config.setProperty("browser", browser);

			if (config.getProperty("browser").equalsIgnoreCase("firefox")) {

				// Not needed for 2.53.1 - need to give the path for Selenium
				// version above 2.53.1

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "//src//test//resources//com//w2a//executables//geckodriver");
				driver = new FirefoxDriver();

				log.debug("Firefox Browser launched...");

			} else if (config.getProperty("browser").equalsIgnoreCase("chrome")) {

				Map<String, Object> prefs = new HashMap<String, Object>();

				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);

				ChromeOptions chromeOptions = new ChromeOptions();

				chromeOptions.setExperimentalOption("prefs", prefs);
				chromeOptions.addArguments("--disable-extensions");
				chromeOptions.addArguments("--disable-infobars");

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//src//test//resources//com//w2a//executables//chromedriver-75.0.3770.8");

				driver = new ChromeDriver(chromeOptions);

				log.debug("Chrome Browser launched...");

			} else if (config.getProperty("browser").equalsIgnoreCase("ie")) {

				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")
						+ "//src//test//resources//com//w2a//executables//IEDriverServer.exe");
				driver = new InternetExplorerDriver();

				log.debug("IE Browser launched...");

			} else if (config.getProperty("browser").equalsIgnoreCase("edge")) {

				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")
						+ "//src//test//resources//com//w2a//executables//edgedriver.exe");
				driver = new EdgeDriver();

				log.debug("Edge Browser launched...");

			} else if (config.getProperty("browser").equalsIgnoreCase("opera")) {

				System.setProperty("webdriver.opera.driver",
						System.getProperty("user.dir") + "//src//test//resources//com//w2a//executables//operadriver");
				driver = new OperaDriver();

				log.debug("Opera Browser launched...");

			} else if (config.getProperty("browser").equalsIgnoreCase("safari")) {

				driver = new SafariDriver();

				log.debug("Safari Browser launched...");

			}

			driver.get(config.getProperty("testSiteURL"));

			log.debug("Navigated to " + config.getProperty("testSiteURL"));

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);

			topMenu = new TopMenu();

		}

	}
	
	public static void quit() {
		
		driver.quit();
		
	}

	// Common Keywords
	public static void click(String locator) {

		if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator))).click();
		}

		log.debug("Clicking on an Element : " + locator);
		test.log(LogStatus.INFO, "Clicking on : " + locator);

	}

	public static void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);

		}

		log.debug("Typing on an Element : " + locator + ". Entered value as " + value);
		test.log(LogStatus.INFO, "Typing in : " + locator + ". Entered value as " + value);

	}

	static WebElement dropdown;

	public static void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {

			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));

		} else if (locator.endsWith("_XPATH")) {

			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));

		} else if (locator.endsWith("_ID")) {

			dropdown = driver.findElement(By.id(OR.getProperty(locator)));

		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.debug("Selecting from drop down : " + locator + ". Selecting value as " + value);
		test.log(LogStatus.INFO, "Selecting from drop down : " + locator + ". Selecting value as " + value);

	}

	public static boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;
		}
	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			Utilities.captureScreenshot();

			// Report NG
			Reporter.log("<br>" + "Verification failure " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "> <img src= "
					+ Utilities.screenshotName + " height=200 width=200> </img> </a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

			// Extent Reports
			test.log(LogStatus.FAIL, " Verification failed with Exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

		}
	}

}
