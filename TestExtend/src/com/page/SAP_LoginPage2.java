package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SAP_LoginPage2 {
	//PerfCmpVrpH
	//R1AOACJ8
	private WebDriver driver;
	
	public SAP_LoginPage2(WebDriver driver){
		this.driver=driver;
	}
	
	public void setUserName(String userName) {
		//username
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(userName);
	}
		//password
	public void setPassword(String password) {
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
	}
		//submit button
	public void submit() {
		driver.findElement(By.id("__button2")).click();
	}
	
	
}
