/**
 * 
 */
package com.w2a.rough;

import com.w2a.BasePage.Page;
import com.w2a.pages.AppPage;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;

/**
 * @author r632871
 *
 */
public class LoginTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HomePage homePage = new HomePage();
		LoginPage loginPage = homePage.goToLogin();
		
		AppPage appPage = loginPage.doLogin("siva.cambia@gmail.com", "Amma2018#");
		appPage.goToCRM();
		
		AccountsPage accountsPage = Page.topMenu.goToAccounts();
		CreateAccountPage createAccountPage = accountsPage.goToCreateAccounts();
		
		createAccountPage.createAccount("Sivakumar");
		 
	}

}
