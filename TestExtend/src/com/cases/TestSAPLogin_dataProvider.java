package com.cases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.business.SAP_login_Business;
import com.data.StaticProvider;
import com.util.Selenium2Proxy;

public class TestSAPLogin_dataProvider extends TestBase{
	
		

		
@Test(dataProvider = "dp", dataProviderClass = StaticProvider.class, enabled = true)
public void SAPlogin(Map<String, String> data, Method method)
					throws Exception {
				String methodName = "";
				methodName = method.getName();
				try {
					log.info(methodName + " is running !");
					SAP_login_Business sap_login=new SAP_login_Business(driver);
					
					//companyID, userName,password
					sap_login.loginSAP(data.get("CompanyID"), data.get("userName"), data.get("password"));

					Thread.sleep(1500);
					Assert.assertTrue(driver.getTitle().contains("Success"));
					captureflag = false;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					Assert.fail("fail: " + e.getMessage());
				} catch (AssertionError e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
					captureflag = false;
					Selenium2Proxy se = new Selenium2Proxy(driver);
					se.captureScreenshot(methodName);
					Thread.sleep(1000);
					Assert.fail("fail: " + e1.getMessage());
				} finally {
					log.info(methodName + " is end !");
				}
			}
	  


@Override
public void init() throws Exception {
	// TODO Auto-generated method stub
	
}
}
