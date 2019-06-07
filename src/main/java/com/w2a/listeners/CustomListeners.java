package com.w2a.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.BasePage.Page;
import com.w2a.utilities.MonitoringMail;
import com.w2a.utilities.TestConfig;
import com.w2a.utilities.Utilities;;

public class CustomListeners extends Page implements ITestListener, ISuiteListener {

	public String messageBody;

	public void onTestStart(ITestResult result) {

		test = extentReports.startTest(result.getName().toUpperCase());

		// run-modes - Y

		/*
		 * if (!Utilities.isTestRunnable(result.getName(), excel)) {
		 * 
		 * throw new SkipException( "Skipping the test " +
		 * result.getName().toUpperCase() + " as the Run mode is NO....");
		 * 
		 * }
		 */

	}

	public void onTestSuccess(ITestResult result) {

		test.log(LogStatus.PASS, result.getName().toUpperCase() + " PASS");
		extentReports.endTest(test);
		extentReports.flush();

	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");

		try {
			Utilities.captureScreenshot();

		} catch (IOException e) {

			e.printStackTrace();
		}

		test.log(LogStatus.FAIL, result.getName().toUpperCase() + " Failed with Exception : " + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

		Reporter.log("Click to see Screenshot...");
		Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "> Screenshot </a>");

		Reporter.log("<br>");
		Reporter.log("<br>");

		Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "> <img src= " + Utilities.screenshotName
				+ " height=200 width=200> </img> </a>");

		extentReports.endTest(test);
		extentReports.flush();
	}

	public void onTestSkipped(ITestResult result) {

		test.log(LogStatus.SKIP, result.getName().toUpperCase() + " Skipped the tests as the run mode is NO...");
		extentReports.endTest(test);
		extentReports.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

	public void onStart(ISuite suite) {
	

	}

	public void onFinish(ISuite suite) {

		
		/*
		 * MonitoringMail mail = new MonitoringMail();
		 * 
		 * try { messageBody = "http://" + InetAddress.getLocalHost().getHostAddress() +
		 * ":8080/job/LiveProject-PageObjectMode/Extent_20Report/"; } catch
		 * (UnknownHostException e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * try { mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,
		 * TestConfig.subject, messageBody);
		 * 
		 * } catch (AddressException e) {
		 * 
		 * e.printStackTrace(); } catch (MessagingException e) {
		 * 
		 * e.printStackTrace(); }
		 */

	}

}
