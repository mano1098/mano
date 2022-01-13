package com.qa.zerobank.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.AccountSummaryPage;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;


public class LoginPageTestCase extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	AccountSummaryPage accountsummarypage;

	public LoginPageTestCase() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		accountsummarypage = new AccountSummaryPage();

	}

	
	@Test
	public void validateLogInPageFunctionality() {
		
		loginpage = homepage.clickSigninButton();


	}
	
	@Test
	public void emptyUserName() {
		loginpage = homepage.clickSigninButton();
		loginpage.emptyUserName();

	}
	@Test
	public void emptyPassword() {
		loginpage = homepage.clickSigninButton();
		loginpage.emptyPassword();

	}


	@Test
	public void enterInvalidUserNameTest() {
		loginpage = homepage.clickSigninButton();
		loginpage.enterInvalidUserName();

	}

	//@Test
	public void enterInvalidPasswordTest() {
		loginpage = homepage.clickSigninButton();
		loginpage.enterInvalidPassword();

	}
	
	@Test
	public void emptyCredentials() {
		loginpage = homepage.clickSigninButton();
		loginpage.emptyCredentials();

	}

	@Test
	public void navigateToAccountSummaryPageTest() {
		loginpage = homepage.clickSigninButton();
		accountsummarypage = loginpage.navigateToAccountSummaryPage();
		accountsummarypage.assertAccountSummaryPageTitle();

	}
	
	@AfterMethod
	public void quitBrowser() {
		driver.close();
		driver.quit();

	}


}
