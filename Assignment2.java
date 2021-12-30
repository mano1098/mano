package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium browser driver\\Chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
				
				driver.get("http://zero.webappsecurity.com/");
				driver.findElement(By.id("signin_button")).click();
				driver.findElement(By.name("user_login")).sendKeys("username");
				driver.findElement(By.id("user_password")).sendKeys("password");
				driver.findElement(By.name("submit")).click();
				
				driver.findElement(By.id("details-button")).click();

			     driver.findElement(By.id("proceed-link")).click();
				driver.findElement(By.linkText("Pay Bills")).click();
				driver.findElement(By.linkText("Add New Payee")).click();
				Thread.sleep(1000);
				driver.findElement(By.tagName("textarea")).sendKeys("test");
				driver.findElement(By.xpath("//input[@name='account']")).sendKeys("1234");
				driver.findElement(By.name("details")).sendKeys("mano");
				driver.findElement(By.id("add_new_payee")).click();
				System.out.println("Filled the details");
				driver.close();
				driver.quit();
				
						
				
						
				
				

	}

}
