package com.zerobank.qa.TestCode;
 

 


import static org.junit.Assert.*;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
public class LogIn_steps {
	
	public WebDriver driver;
	


@Given("A browser initialized$")
public void a_browser_initialized() throws Throwable {
	
	System.setProperty("webdriver.chrome.driver","C:\\SeleniumDriver\\Chromedriver.exe");
	//C:\Selenium browser driver
	driver = new ChromeDriver();
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
}

@Given("^Open application \"([^\"]*)\"$")
public void open_application(String url) throws Throwable {
	//open URL into browser
    driver.get(url);
    assertEquals(driver.getTitle(), "Zero - Personal Banking - Loans - Credit Cards");  
}

@Given("^I click on Signin button on home page$")
public void i_click_on_Signin_button_on_home_page() throws Throwable {
	driver.findElement(By.id("signin_button")).click(); 
}

@Given("^I am on login page$")
public void i_am_on_login_page() throws Throwable {
	 assertEquals(driver.getTitle(), "Zero - Log in"); 
}

@When("^I enter user id as \"([^\"]*)\" and password as \"([^\"]*)\"$")
public void i_enter_user_id_as_and_password_as(String uname, String pass) throws Throwable {
	 driver.findElement(By.id("user_login")).sendKeys(uname);
     driver.findElement(By.id("user_password")).sendKeys(pass);  
}

@When("^Click on Signin button$")
public void click_on_Signin_button() throws Throwable {
	driver.findElement(By.name("submit")).click();

    if (driver.findElements(By.id("details-button")).size() != 0) {
        //click on advance button
        driver.findElement(By.id("details-button")).click();        
        //click on link to proceed
        driver.findElement(By.linkText("Proceed to zero.webappsecurity.com (unsafe)")).click();
}
}

@Then("^I validate that I am able to log into the application and I land on Account summery page$")
public void i_validate_that_I_am_able_to_log_into_the_application_and_I_land_on_Account_summery_page() throws Throwable {
	assertEquals(driver.getTitle(), "Zero - Account Summary");
}

@Then("^I validate that I get an error message \"([^\"]*)\"$")
public void i_validate_that_I_get_an_error_message(String emsg) throws Throwable {
	assertEquals(driver.findElement(By.xpath("//form[@id='login_form']/div[1]")).getText(), emsg);

}

//@After
//public void cleanUp() {
//    driver.close();
//    driver.quit();
//}
}