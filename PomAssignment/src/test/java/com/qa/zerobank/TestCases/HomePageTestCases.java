package com.qa.zerobank.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;

public class HomePageTestCases extends TestBase {

	HomePage homepage;
	LoginPage loginpage;

	public HomePageTestCases() {
		super();
	}

	@BeforeMethod
	public void setup() {

		initialization();
		homepage = new HomePage();
		loginpage = new LoginPage();
	}

	@Test
	public void ValidateHomePage() {
		homepage.assertHomePageTitle();
	}

	@Test
	public void ValidateLogo() {
		homepage.assertHomePageTitle();
	}

	@Test
	public void signInButtonTest() {
		loginpage = homepage.clickSigninButton();
		loginpage.assertLoginPageTitle();

	}
	
	@AfterMethod
	public void quitBrowser() {

		driver.close();
		driver.quit();
	}


}
