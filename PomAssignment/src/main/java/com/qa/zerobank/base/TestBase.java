package com.qa.zerobank.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {



	public static WebDriver driver;
	public static Properties prop;


	public TestBase() {
		prop = new Properties();


	try {
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\zerobank\\config\\config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {



		e.printStackTrace();
	} catch (IOException e) {

		e.printStackTrace();
	}



}



	public static void initialization() {

		String browserName = prop.getProperty("browser");
		String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\com\\qa\\zerobank\\\\SeleniumBrowserDriver\\";
		System.out.println(driverPath);


		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath +"chromedriver.exe");

			driver = new ChromeDriver();



		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", driverPath + "C://EdgeDriver.exe");

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(prop.getProperty("url"));
	}
}