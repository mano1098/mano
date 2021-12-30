package seleniumbasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium browser driver\\Chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
				
				driver.get("http://zero.webappsecurity.com/");
				driver.manage().window().maximize();


			    driver.findElement(By.id("signin_button")).click();
				driver.findElement(By.name("user_login")).sendKeys("username");
				driver.findElement(By.id("user_password")).sendKeys("password");
				driver.findElement(By.name("submit")).click();
				
				driver.findElement(By.id("details-button")).click();

			     driver.findElement(By.id("proceed-link")).click();
			     driver.findElement(By.linkText("Pay Bills")).click();
			     
			     Thread.sleep(1000);
			     driver.findElement(By.linkText("Purchase Foreign Currency")).click();
			     Thread.sleep(1000);

			     driver.findElement(By.id("purchase_cash")).click();
			     Thread.sleep(1000);
			     Alert Alert = driver.switchTo().alert();
					String alert1 = Alert.getText();
					System.out.println("Just an alert - " + alert1 + "");
					
					Alert.accept();
					
					driver.close();

					driver.quit();        
					
					
			     
			     
				

	}

}
