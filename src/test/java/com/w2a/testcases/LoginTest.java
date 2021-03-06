package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.utilities.Utilities;

public class LoginTest extends BaseTest{
	
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void loginTest(Hashtable<String, String> data) {
		
		HomePage homePage = new HomePage();
		LoginPage loginPage = homePage.goToLogin();
		
		loginPage.doLogin(data.get("userName"), data.get("password"));
		
		//Assert.fail("Login test failed");
	
	}

}
