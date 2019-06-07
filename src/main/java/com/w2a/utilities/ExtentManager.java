package com.w2a.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extentRep;

	public static ExtentReports getInstance() {

		if (extentRep == null) {

			extentRep = new ExtentReports(
					System.getProperty("user.dir") + "//target//surefire-reports//html//extentReport.html", true,
					DisplayOrder.OLDEST_FIRST);
			
			extentRep.loadConfig(new File(System.getProperty("user.dir") + "//src//test//resources//com//w2a//extentConfig//ReportsConfig.xml"));

		}

		return extentRep;
	}

}
