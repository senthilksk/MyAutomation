package MyPrograms;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InitializeDriver {

	WebDriver driver;

	@Test
	public  WebDriver initDriver() {
		/*
		 * ChromeOptions chromeOptions = new ChromeOptions();
		 * WebDriverManager.chromedriver().driverVersion("85.0.4183.38").setup();
		 * or
		 * WebDriverManager.chromedriver().setup(); 
		 * driver = new ChromeDriver(chromeOptions);
		 */

		/*
		 * WebDriverManager.chromedriver() .driverVersion("83.0.0") .arch32()
		 * .proxy("proxyhostname:80") .proxyUser("username") .proxyPass("password")
		 * .setup();
		 */


		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;
	}

}
