package com.cases;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.databene.feed4testng.FeedTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.config.DriverManage;
import com.config.GetTestProperties;
import com.util.CommonMethord;
import com.util.DatabaseService;
import com.util.Selenium2Proxy;

public abstract class TestBase extends FeedTest {
	protected WebDriver driver = null;
	protected String browser;
	protected final Logger log = Logger.getLogger(getClass());
	protected boolean captureflag;
	//protected Connection conn = null;xxxxxx
	//protected DatabaseService ds = new DatabaseService();xxxxxxxxxxx

	String dbusername;
	String dbpassword;
	String dbtype;
	String dburl;

	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		captureflag = true;
		
		//杀掉进程
		//CommonMethord.killProcess(getBrowserProcess(browser));xxxxxxxxxxxxxx
		//CommonMethord.killProcess("iedriverserver_32.exe");xxxxxxxxxxxxxxx
		driver = DriverManage.getDriver(browser);
		
		// driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	abstract public void init() throws Exception;

	@AfterMethod
	public void afterMethod() throws Exception {
		try {
			//截图机制 失败之后的最后状态
			Selenium2Proxy se = new Selenium2Proxy(driver);
			if (captureflag) {
				se.captureScreenshot();
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (driver != null) {
				CommonMethord.killProcess(getBrowserProcess(browser));
				Thread.sleep(500);
				if (!browser.equals("1")) {
					driver.quit();
				}
			}
		}
	}

	@Parameters({"driverType"}) //参数传递方式，从testNG。xml传
	@BeforeClass
	public void beforeClass(@Optional("3") String driverType) throws Exception {
		/*dbusername = GetTestProperties.getdbusername();
		dbpassword = GetTestProperties.getdbpassword();
		dbtype = GetTestProperties.getdbtype();
		dburl = GetTestProperties.getdburl();*/ //xxxxxxxxxxxxxxxxxxxxxxxxxxx
		//conn = ds.connectDBDriver(dbtype, dbusername, dbpassword, dburl);xxxxxxxxxxx
		// browser = GetTestProperties.getBrowserType();
		browser = driverType;
		log.info("Start to run test class " + this.getClass().getName()
				+ " on driverType" + browser);
	}

	@AfterClass
	public void afterClass() throws Exception {
		//ds.closeDBDriver(conn); xxxxxxxxxxxxx
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		PropertyConfigurator.configure(CommonMethord.getRealath()
				+ "conf/log4j.properties");
	}

	public String getBrowserProcess(String bs) throws Exception {
		String process = null;

		switch (Integer.parseInt(bs)) {
		case 1:
			process = "firefox.exe";
			break;

		case 2:
			process = "iexplore.exe";
			break;

		case 3:
			process = "chrome.exe";
			break;
		}
		return process;
	}

}