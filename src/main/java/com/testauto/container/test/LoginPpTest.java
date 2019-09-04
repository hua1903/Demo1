package com.testauto.container.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testauto.container.pages.LoginPP;

public class LoginPpTest {
	private WebDriver driver;
	private LoginPP loginPP;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		// DesiredCapabilities dc = DesiredCapabilities.chrome();
		// driver = new RemoteWebDriver(new URL("http://10.0.75.2:5555/wd/hub"),
		// dc);
		// driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), dc);
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		driver = new RemoteWebDriver(new URL("http://10.0.75.2:5454/wd/hub"), dc);
		// driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444"), dc);
		loginPP = new LoginPP(driver);
		Reporter.log("Open browser");
	}

	@Test
	public void loginPPSuccessfully() throws Exception {
		loginPP.goTo();
		System.out.println("Direct to Partner Portal website");
		loginPP.enterUserName("tmaTestAdmin");
		System.out.println("enter user name: tmaTestAdmin");
		loginPP.enterPassword("tmaTestAdmin0");
		System.out.println("enter pw: tmaTestAdmin0");
		loginPP.clickLogin();
		System.out.println("click on Login button");
		Assert.assertTrue(loginPP.visibleBTBLogo());
	}

	@Test
	public void loginPPFailed() throws Exception {
		loginPP.goTo();
		System.out.println("Direct to Partner Portal website");
		loginPP.enterUserName("tmaTestAdmin");
		System.out.println("enter user name: tmaTestAdmin");
		loginPP.enterPassword("tmaTestAdmin000");
		System.out.println("enter pw: tmaTestAdmin000");
		loginPP.clickLogin();
		System.out.println("click on Login button");
		Assert.assertTrue(loginPP.visibleWrongUserNameOrPassowrfMsg());
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
