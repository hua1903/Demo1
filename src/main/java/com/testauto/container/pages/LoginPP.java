package com.testauto.container.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPP {
	WebDriver driver;

	public LoginPP(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "userName")
	private WebElement txtbx_UserName;

	@FindBy(how = How.NAME, using = "password")
	private WebElement txtbxPassword;

	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Login')]")
	private WebElement btnLogin;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Username or password invalid')]")
	private WebElement wrongUserNameOrPasswordMsg;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Please login again')]")
	private List<WebElement> msgLoginAgain;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Close')]")
	private WebElement btnClosedMsg;

	@FindBy(how = How.XPATH, using = "//div[@class='navbar-item']")
	private WebElement btn_Logo;

	@FindBy(how = How.XPATH, using = "//div[@class='content']")
	private WebElement anyMsg;

	public void goTo() {
		this.driver.get("https://cindy.telecombilling.com.au/bureau-portal/?bureau=CORTEL");
		driver.manage().window().maximize();
	}

	public void enterUserName(String name) throws Exception {
		try {
			txtbx_UserName.clear();
			txtbx_UserName.sendKeys(name);
		} catch (Exception ex) {
			Reporter.log("The element of UserName textbox is changed.");
		}
	}

	public void enterPassword(String pw) throws Exception {
		try {
			txtbxPassword.clear();
			txtbxPassword.sendKeys(pw);
		} catch (Exception ex) {
			Reporter.log("The element of Password textbox is changed.");
		}
	}

	public void clickLogin() throws Exception {

		try {
			btnLogin.click();
			Thread.sleep(2000);
		} catch (Exception ex) {
			Reporter.log("The element of Login button is changed.");
		}
	}

	public boolean visibleWrongUserNameOrPassowrfMsg() {
		try {
			Thread.sleep(10000);
			return wrongUserNameOrPasswordMsg.isDisplayed();
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean visibleBTBLogo() {
		try {
			return btn_Logo.isDisplayed();
		} catch (Exception ex) {
			return false;
		}
	}
}
