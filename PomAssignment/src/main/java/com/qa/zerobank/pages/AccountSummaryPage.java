package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.zerobank.base.TestBase;

public class AccountSummaryPage extends TestBase {
	
	@FindBy(id="pay_bills_tab")
	WebElement pay_bills_tab;
	
	@FindBy(id = "logout_link")
	WebElement logout;

	@FindBy(id="purchase_cash")
	WebElement purchase_cash;

	@FindBy(id="pc_amount")
	WebElement pc_amount;

	@FindBy(linkText= "Purchase Foreign Currency")
	WebElement Purchase_Foreign_Currency;
	
	@FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
	WebElement signoutdropdown;


	public AccountSummaryPage() {
		PageFactory.initElements(driver, this);

	}

	public void assertAccountSummaryPageTitle() {

		assertEquals(driver.getTitle(), "Zero - Account Summary");
	}


	public void payBills() {

		pay_bills_tab.click();
		System.out.println("Transfer Funds");
		assertEquals(driver.getTitle(), "Zero - Pay Bills");
		Purchase_Foreign_Currency.click();

		pc_amount.sendKeys("Keys");

		purchase_cash.click();

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Alert text :"+text);

		Assert.assertEquals(text,"Please, ensure that you have filled all the required fields with valid values.","Alert text is not matching");
		alert.accept();
		return;

	}
	

	public HomePage signOut() {

		signoutdropdown.click();
		logout.click();
		return new HomePage();
	}
}
