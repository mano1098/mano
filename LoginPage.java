package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.zerobank.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "txtUsername")
	WebElement UserLogin;

	@FindBy(id = "txtPassword")
	WebElement UserPassword;

	@FindBy(name = "Submit")
	WebElement SubmitButton;

	@FindBy(xpath = "//a[@id='menu_recruitment_viewRecruitmentModule']")
	WebElement detailbutton;

	@FindBy(xpath = "//a[@id='menu_recruitment_viewCandidates']")
	WebElement proceedlink;
	
	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement addbutton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}



	public AccountSummaryPage navigateToAccountSummaryPage() throws InterruptedException {
		Thread.sleep(5000);
		UserLogin.sendKeys("admin");
		UserPassword.sendKeys("admin123");
		SubmitButton.click();
		Actions rec = new Actions(driver);
		rec.moveToElement(detailbutton).build().perform();
		proceedlink.click();
		addbutton.click();
		


		driver.findElement(By.xpath("//input[@class='formInputText']")).click();
		driver.findElement(By.xpath("//input[@class='formInputText']")).sendKeys("Mno");

		driver.findElement(By.xpath("//input[@id='addCandidate_lastName']")).click();
		driver.findElement(By.xpath("//input[@id='addCandidate_lastName']")).sendKeys("Kedar");







		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='addCandidate_email']")).sendKeys("Bhoom123456@gmail.com");
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		Actions rec1 = new Actions(driver);
		rec1.moveToElement(detailbutton).build().perform();
		proceedlink.click();
		String text= driver.findElement(By.xpath("//a[contains(text(),'Kedar')]")).getText();
				
		
		Assert.assertEquals(text, "Mno  Kedar");
		
		return new AccountSummaryPage();

	}

	public void emptyCredentials() {

		UserLogin.sendKeys("");
		UserPassword.sendKeys("");
		SubmitButton.click();
		assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText(),
				"Login and/or password are wrong.");
		System.out.println("EmptyCredentials");
		return;
	}

	public void emptyUserName() {

		UserLogin.sendKeys("");
		UserPassword.sendKeys("welcome");
		SubmitButton.click();
		assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText(),
				"Login and/or password are wrong.");
		System.out.println("Empty username");
		return;
	}

	public void emptyPassword() {

		UserLogin.sendKeys("Welcome");
		UserPassword.sendKeys("");
		SubmitButton.click();
		assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText(),
				"Login and/or password are wrong.");
		System.out.println("Empty Password");
		return;
	}

	public void enterInvalidPassword() {

		UserLogin.sendKeys("username");
		UserPassword.sendKeys("UrWelcome");
		SubmitButton.click();
		assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText(),
				"Login and/or password are wrong.");
		System.out.println("Invalid Password");
		return;
	}

	public void enterInvalidUserName() {

		UserLogin.sendKeys("Welcome");
		UserPassword.sendKeys("password");
		SubmitButton.click();
		assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText(),
				"Login and/or password are wrong.");
		System.out.println("Invalid USername");
		return;
	}

}
