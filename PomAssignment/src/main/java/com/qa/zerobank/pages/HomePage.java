package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(linkText="Zero Bank")
	WebElement pageTitle;
	
	@FindBy(name="searchTerm")
	WebElement searchBox;
	
	@FindBy(id="signin_button")
	WebElement SigninButton;
	
	@FindBy(id="details-button")
	WebElement detailbutton;

	@FindBy(id="proceed-link")
	WebElement proceedlink;

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public void assertHomePageTitle() {
		assertEquals(driver.getTitle(), "Zero - Personal Banking - Loans - Credit Cards");

	}

	public boolean brandName() {
		return pageTitle.isDisplayed();
	}

	public LoginPage clickSigninButton(){
		SigninButton.click();
		return new LoginPage();
	}
}
