package com.w2a.pages;

import com.w2a.BasePage.Page;

public class HomePage extends Page{
	
	public void goToCustomers() {
		
		click("zh-customers_XPATH ");
		
	}
	
	public void goToSupport() {
		
		click("zh-support_XPATH");
		
	}
	
	public void goToContactSales() {
		
		click("zh-contact_XPATH ");
		
	}

	public LoginPage goToLogin() {
		
		click("loginLink_CSS");
		
		return new LoginPage();
		
	}
	
	public void goToFreeSignUp() {
		
		click("zh-signup_CSS");
		
	}
	
	public void goToLearnMore() {
		
		click("learnMore_CSS");
		
	}
	
	public void validateFooterLinks() {
		
	}

}