package com.cases;

import java.lang.reflect.Method;
import java.util.Map;

import org.databene.benerator.anno.Database;
import org.databene.benerator.anno.InvocationCount;
import org.databene.benerator.anno.Source;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.business.Kfgl_LoginBusiness;
import com.data.KfglTestData;
import com.data.StaticProvider;
import com.util.Selenium2Proxy;

//import com.config.ExcelDataProvider;

@Database(id = "db", environment = "conf/fee4db")
public class KfglTest extends TestBase {

	Kfgl_LoginBusiness kfgl_lb = new Kfgl_LoginBusiness();

	// static DBSystem db;

	// 鐢ㄦ埛鎴愬姛鐧婚檰
	@Test(dataProvider = "LoginSucc", dataProviderClass = KfglTestData.class, enabled = true)
	public void kfgl_0001_LoginSucc(Integer n, String username,
			String password, String name, Method method) throws Exception {
		String methodName = "";
		methodName = method.getName();
		try {
			//log.info(message)
			log.info(methodName + " is running !");
			
			
			
			
			String sql = "select codename,codevalue from codedata";
			
			// String a = "SELECT COUNT(*) from userinfo where useruuid like 'zhangsan%'";
			
			
			//log.info("DB value is  --- : " + ds.getData(conn, sql, 5, 2));xxxxxxxxxxxxxxx
			
			// System.out.println("鏁版嵁搴撶粨鏋滄槸锛�"+ds.getData(conn, sql, 1, 1));
			
			
			
			
			
			
			
			//-----------------
			//kfgl_lb.loginTest(driver, username, password);//璋冪敤鐧诲綍鐨勪竴涓簨鍔�
			// kfgl_qb.query();//
			
			//-----------------
			
			
			//Thread.sleep(1500);
			//Assert.assertTrue(driver.getTitle().contains("杞欢搴旂敤妗嗘灦"));//楠岃瘉鐐�
			captureflag = false;//鏂█鎵ц鎴愬姛鎵嶆墽琛屾琛屼唬鐮侊紝鍚﹀垯璺宠繃
			// } catch (Error e) {
			// log.info("鏂█澶辫触"+e.getMessage());
			// e.printStackTrace();
			// Assert.fail("fail"+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			captureflag = false;
			Selenium2Proxy se = new Selenium2Proxy(driver);
			se.captureScreenshot(methodName);
			Thread.sleep(1000);
			Assert.fail("fail: " + e.getMessage());
		} catch (AssertionError e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			captureflag = false;
			Selenium2Proxy se = new Selenium2Proxy(driver);
			se.captureScreenshot(methodName);
			Thread.sleep(1000);
			log.info(e1.getMessage());
			Assert.fail("fail: " + e1.getMessage());
		} finally {
			log.info(methodName + " is end !");
		}
	}

	// 鐢ㄦ埛鐧诲綍澶辫触
	@Test(dataProvider = "LoginFail", dataProviderClass = KfglTestData.class, enabled = false)
	public void kfgl_0002_LoginFail(Integer n, String username,
			String password, String name, Method method) throws Exception {
		String methodName = "";
		methodName = method.getName();
		try {
			log.info(methodName + " is running !");
			kfgl_lb.loginTest(driver, username, password);
			Thread.sleep(1500);
			Assert.assertTrue(driver.getPageSource().contains("閿欒浠ｇ爜"));
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

	// 鐢ㄦ埛鎴愬姛鐧婚檰--excel鏁版嵁椹卞姩1--杩欎釜妗堜緥浼氬拰绗簲涓渚嬪啿绐侊紝鏆傛椂搴熷純
	@Test(dataProvider = "feeder", enabled = false)
	@Source("testdata/test.xls")
	public void kfgl_0003_LoginSucc(Integer n, String username, String password)
			throws Exception {
		String methodName = "";
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			log.info(methodName + " is running !");
			kfgl_lb.loginTest(driver, username, password);
			Thread.sleep(1500);
			Assert.assertTrue(driver.getTitle().contains("杞欢搴旂敤妗嗘灦"));
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

	// 鐢ㄦ埛鎴愬姛鐧婚檰--excel鏁版嵁椹卞姩2
	@Test(dataProvider = "dp", dataProviderClass = StaticProvider.class, enabled = false)
	public void kfgl_0004_LoginSucc(Map<String, String> data, Method method)
			throws Exception {
		String methodName = "";
		methodName = method.getName();
		try {
			log.info(methodName + " is running !");
			
			
			
			
			kfgl_lb.loginTest(driver, data.get("鐢ㄦ埛鍚�"), data.get("瀵嗙爜"));
			
			
			
			
			
			
			
			Thread.sleep(1500);
			Assert.assertTrue(driver.getTitle().contains("杞欢搴旂敤妗嗘灦"));
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

	// 鐢ㄦ埛鎴愬姛鐧婚檰--鏁版嵁搴撴暟鎹┍鍔�--浣跨敤feed4testng鏃�,浼犲叆鍙傛暟涓湁鏂规硶鍚嶇殑璇濓紝浼氬鑷寸┖鎸囬拡寮傚父锛熷緟澶勭悊
	@Test(dataProvider = "feeder", enabled = false)
	@Source(id = "db", selector = "select t.userid from usertable t where t.userid like 'xuwei%'")
	@InvocationCount(2)
	public void kfgl_0005_LoginSucc(String userid) throws Exception {
		String methodName = "";
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			log.info(methodName + " is running !");
			kfgl_lb.loginTest(driver, userid, userid);
			Thread.sleep(1500);
			Assert.assertTrue(driver.getTitle().contains("杞欢搴旂敤妗嗘灦"));
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

	/*
	 * @DataProvider public Object[][] dp1() { return new Object[][] { new
	 * Object[] { 1, "admin", "admin", "绯荤粺绠＄悊鍛�" }, new Object[] { 2, "xuwei",
	 * "xuwei", "寰愪紵" }, }; }
	 * 
	 * @DataProvider public Object[][] dp2() { return new Object[][] { new
	 * Object[] { 1, "admin", "admin1", "绯荤粺绠＄悊鍛�" }, new Object[] { 2, "xuwei1",
	 * "xuwei", "寰愪紵" }, }; }
	 */

	// @DataProvider(name = "dp")
	// public Iterator<Object[]> dataFortestMethod(Method method)
	// throws IOException {
	// return new ExcelDataProvider(this.getClass().getName(),
	// method.getName());
	// }

	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub

	}

}
