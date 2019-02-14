package com.cases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.business.SAP_login_Business;

public class TestSAPLogin extends TestBase{
  @Test
  public void TestLogin(Method method) throws Exception{
	  
			String methodName = "";
			methodName = method.getName();
			log.info(methodName + " is running !");
			
			SAP_login_Business loginBusiness =new SAP_login_Business(driver);
			
			loginBusiness.loginSAP("PerfCmpVrpH","R1AOACJ8", "pwd");
			
			Thread.sleep(1000);
			
			Assert.assertTrue(driver.getTitle().contains("SuccessxxxFactors"));// 
			captureflag = false;

	  
  }

@Override
public void init() throws Exception {
	// TODO Auto-generated method stub
	
}
}
