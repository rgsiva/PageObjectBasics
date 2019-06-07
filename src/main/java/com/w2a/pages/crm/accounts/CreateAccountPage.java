package com.w2a.pages.crm.accounts;

import com.w2a.BasePage.Page;

public class CreateAccountPage extends Page{
	
	public void createAccount(String accountName) {
		
		Page.type("crm_ACCOUNTNAME_XPATH", accountName);
		
	
	}
	

}
