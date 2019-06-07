package com.w2a.pages.crm.accounts;

import com.w2a.BasePage.Page;

public class AccountsPage extends Page{
	
	public CreateAccountPage goToCreateAccounts() {
		
		Page.click("createIcon_XPATH");
		
		Page.click("submenu_Accounts_XPATH");
		
		return new CreateAccountPage();
		
	}
	
	public void goToImportAccounts() {
		
	}

}
