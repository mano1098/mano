package com.qa.zerobank.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.AccountSummaryPage;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;


public class LoginPageTestCase extends TestBase {

	//HomePage homepage;
	LoginPage loginpage;
	//AccountSummaryPage accountsummarypage;

	public LoginPageTestCase() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		//homepage = new HomePage();
		loginpage = new LoginPage();
		//accountsummarypage = new AccountSummaryPage();

	}

	
	

	@Test
	public void navigateToAccountSummaryPage() throws InterruptedException {
		//loginpage = homepage.clickSigninButton();
		AccountSummaryPage accountsummarypage = loginpage.navigateToAccountSummaryPage();
		//accountsummarypage.assertAccountSummaryPageTitle();

	}
	
	@AfterMethod
	public void quitBrowser() {
		driver.close();
		driver.quit();

	}


}
