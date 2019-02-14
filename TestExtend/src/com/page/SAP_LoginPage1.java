package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;

import com.util.LogsInit;

	public class SAP_LoginPage1 extends LogsInit{
		
	private WebDriver driver;
		
	public 	SAP_LoginPage1(WebDriver driver) {
		this.driver = driver;
		
	}
	
	
	public void setCompanyID(String CompanyID) throws NotFoundException{
		driver.findElement(By.id("__input0-inner")).clear();
		driver.findElement(By.id("__input0-inner")).sendKeys(CompanyID);
	}
	
	//__button0
	public void clickButton() throws NotFoundException{
		driver.findElement(By.id("__button0")).click();
	}	
}
