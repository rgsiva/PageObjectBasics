package com.w2a.pages;

import com.w2a.BasePage.Page;
import com.w2a.pages.crm.CRMHomePage;

public class AppPage extends Page{
	
	public void goToBooks() {
		
		click("zicon-apps-books_XPATH");
		
	}
	
	public void goToCalendar() {
		
		click("zicon-apps-calendar_XPATH");
		
	}
	
	public void goToCampaigns() {
		
		click("Campaigns_XPATH");
	
	}
	
	public void goToCliq() {
		
		click("zicon-apps-chat_XPATH");
		
		
	}
	
	public void goToConnect() {
		
		click("zicon-apps-connect_XPATH");
		
	}
	
	public CRMHomePage goToCRM() {
		
		click("zicon-apps-crm_XPATH");
		
		return new CRMHomePage();
		
	}
	
	public void goToDesk() {
		
		click("zicon-apps-support_XPATH");
		
	}
	
	public void goToInvoice() {
		
		click("zicon-apps-invoice_XPATH");
		
	}
	
	public void goToMail() {
		
		click("zicon-apps-mail_XPATH");
		
	}
	
	public void goToMeeting() {
		
		click("zicon-apps-meeting_XPATH");
		
	}
	
	public void goToSite24x7() {
		
		click("zicon-apps-site24x7_XPATH");
		
	}
	
	

}
