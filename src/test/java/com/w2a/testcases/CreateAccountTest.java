package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.BasePage.Page;
import com.w2a.pages.AppPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;
import com.w2a.utilities.Utilities;

public class CreateAccountTest {
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String, String> data) {
		
		AppPage appPage = new AppPage();
		appPage.goToCRM();
		
		AccountsPage accountsPage = Page.topMenu.goToAccounts();
		CreateAccountPage createAccountPage = accountsPage.goToCreateAccounts();
		createAccountPage.createAccount(data.get("accountName"));
		
		//Assert.fail("Create Account test failed");
		
	}

}
