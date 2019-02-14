package com.business;

import org.openqa.selenium.WebDriver;

import com.config.GetTestProperties;
import com.page.SAP_LoginPage1;
import com.page.SAP_LoginPage2;

public class SAP_login_Business {
	private WebDriver driver;
	
	public SAP_login_Business(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void goToUrl() {
		driver.get(GetTestProperties.getTestUrl());
	}
	
	public void loginSAP(String CompanyID,String userName,String password)throws Exception {
		this.goToUrl();// login SAP url
		
		SAP_LoginPage1 login_page1 = new SAP_LoginPage1(driver);
		
		login_page1.setCompanyID(CompanyID);
		
		login_page1.clickButton();
		
		Thread.sleep(2000);
		
		SAP_LoginPage2 loginPage2=new SAP_LoginPage2(driver);
		loginPage2.setUserName(userName);
		
		loginPage2.setPassword(password);
		
		loginPage2.submit();
	}
	
	
	
	
	
}
