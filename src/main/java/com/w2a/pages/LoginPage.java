package com.w2a.pages;

import com.w2a.BasePage.Page;


public class LoginPage extends Page{
		
	public AppPage doLogin(String userName,String password) {
		
		type("email_CSS", userName);
		type("password_CSS", password);
		click("signInBtn_CSS");
		/*
		 * driver.findElement(By.cssSelector("#lid")).sendKeys(userName);
		 * driver.findElement(By.cssSelector("#pwd")).sendKeys(password);
		 * driver.findElement(By.cssSelector("#signin_submit")).click();
		 */
		
		return new AppPage();
		
		
	}

}
