package testNgAssignment;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Assignment5 {
  
  




	  public WebDriver driver ;



	  @BeforeTest
	  public void setupTest() {
		  System.setProperty("webdriver.chrome.driver","C:\\Selenium browser driver\\Chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
	  
	  
	  
	  driver.get("http://zero.webappsecurity.com/");
	  System.out.println("****Launched the browser****");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  @Test (priority = 1, groups = {"Regression"})
	  public void loginTest() {
	  driver.findElement(By.id("signin_button")).click();
	  System.out.println("Clicked sigin button");
	  driver.findElement(By.cssSelector("input#user_login")).sendKeys("username");
	  driver.findElement(By.xpath("//input[contains(@name, 'user_password')]")).sendKeys("password123");
	  driver.findElement(By.name("submit")).click();
	  String loginAndorPassword = driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText();
	  AssertJUnit.assertEquals(loginAndorPassword, "Login and/or password are wrong.");
	  }
	  @Test(priority = 2, groups = {"Regression"})
	  public void userName() {
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	  driver.findElement(By.id("btnLogin")).click();
	  String usernameCannotBe = driver.findElement(By.xpath("//span[text()='Username cannot be empty']")).getText();
	  AssertJUnit.assertEquals(usernameCannotBe, "Username cannot be empty");
	  }
	  @Test(priority = 4, groups = {"Regression"})
	  public void emptyPassword() {
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("btnLogin")).click();
	  String passwordnameCannotBe = driver.findElement(By.xpath("//span[text()='Password cannot be empty']")).getText();
	  AssertJUnit.assertEquals(passwordnameCannotBe, "Password cannot be empty");
	  }
	  @Test(priority = 3, groups = {"Regression"})
	  public void invalidCred() {
	  driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
  driver.findElement(By.id("txtUsername")).sendKeys("Admin123");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).click();
	  String invalidCred = driver.findElement(By.xpath("//span[text()='Invalid credentials']")).getText();
	  AssertJUnit.assertEquals(invalidCred, "Invalid credentials");
	  }
	  @AfterMethod
	@AfterTest
	  public void tearDown() {
	  driver.close();
	  driver.quit();
	  }
	  
}