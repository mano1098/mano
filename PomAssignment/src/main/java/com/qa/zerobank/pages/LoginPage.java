package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id="user_login")
	WebElement UserLogin;

	@FindBy(id="user_password")
	WebElement UserPassword;

	@FindBy(name="submit")
	WebElement SubmitButton;

	@FindBy(id="details-button")
	WebElement detailbutton;

	@FindBy(id="proceed-link")
	WebElement proceedlink;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void assertLoginPageTitle() {
		assertEquals(driver.getTitle(), "Zero - Log in");
	}
	
	public AccountSummaryPage navigateToAccountSummaryPage() {
		UserLogin.sendKeys("username");
		UserPassword.sendKeys("password");
		SubmitButton.click();
		detailbutton.click();
		proceedlink.click();
		assertEquals(driver.getTitle(), "Zero - Account Summary");
		System.out.println("Positive vibes");
		return new AccountSummaryPage();

	}
	
	public void emptyCredentials() {

		UserLogin.sendKeys("");
		UserPassword.sendKeys("");
		SubmitButton.click();
		assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText(), "Login and/or password are wrong.");
		System.out.println("EmptyCredentials");
		return;
	}
	
	public void emptyUserName() {

		UserLogin.sendKeys("");
		UserPassword.sendKeys("welcome");
		SubmitButton.click();
		assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText(), "Login and/or password are wrong.");
		System.out.println("Empty username");
		return;
	}

	
	public void emptyPassword() {

		UserLogin.sendKeys("Welcome");
		UserPassword.sendKeys("");
		SubmitButton.click();
		assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText(), "Login and/or password are wrong.");
		System.out.println("Empty Password");
		return;
	}
	
	public void enterInvalidPassword() {

		UserLogin.sendKeys("username");
		UserPassword.sendKeys("UrWelcome");
		SubmitButton.click();
		assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText(), "Login and/or password are wrong.");
		System.out.println("Invalid Password");
		return;
	}
	

	
	public void enterInvalidUserName() {

		UserLogin.sendKeys("Welcome");
		UserPassword.sendKeys("password");
		SubmitButton.click();
		assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText(), "Login and/or password are wrong.");
		System.out.println("Invalid USername");
		return;
	}

	
	
	
}
