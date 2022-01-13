package com.qa.zerobank.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.AccountSummaryPage;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;

public class AccountSummaryPageTestCases extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	AccountSummaryPage accountsummarypage;

	public AccountSummaryPageTestCases() {

		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		accountsummarypage = new AccountSummaryPage();

	}


		
	@Test (priority = 1)
	public void validateAccountSummaryPageTitle() {
		loginpage = homepage.clickSigninButton();
		accountsummarypage = loginpage.navigateToAccountSummaryPage();
		accountsummarypage.assertAccountSummaryPageTitle();
		accountsummarypage.signOut();
		System.out.println("Verifying");
		System.out.println("Positive");


	}

	@Test (priority = 2)
	public void payBillsTest() {

		loginpage = homepage.clickSigninButton();
		accountsummarypage = loginpage.navigateToAccountSummaryPage();
		accountsummarypage.payBills();
		System.out.println("Positive");

	}

	@Test (priority = 3)
	public void signOutTest() {
		loginpage = homepage.clickSigninButton();
		accountsummarypage = loginpage.navigateToAccountSummaryPage();
		accountsummarypage.signOut();
		System.out.println("Sign out");
	}
	
	@AfterMethod
	public void quitBrowser() {
		driver.close();
		driver.quit();

	}

}
