package com.w2a.BasePage;

import com.w2a.pages.crm.accounts.AccountsPage;

public class TopMenu {
	
	/*
	 * HomePage HAS A TOP MENU
	 * Account Page HAS A TOP MENU
	 * 
	 */
	
	public void goToHome() {
		
		
	}
	
	public void goToLeads() {
		
	}
	
	public void goToContacts() {
		
	}
	
	public AccountsPage goToAccounts() {
		
		Page.click("createAccount_XPATH");
		
		return new AccountsPage();
		
	}
	
	public void goToDeals() {
		
	}
	
	public void goToActivities() {
			
		}
	
	public void goToReports() {
		
	}
	
	public void goToAnalytics() {
		
	}
	
	public void goToProjects() {
		
	}
	
	public void logOut() {
		
	}

}
