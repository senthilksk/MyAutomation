package seleniumPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class chromeoption {

	WebDriver driver;

	@Test
	public void browserOptions() {

		/*
		 * Fix “java.io.IOException: Invalid Status code=403 text=Forbidden” Error for  ChromeDriver 111 Version 
		 *ChromeOptions chromeoption = new ChromeOptions();
		 * chromeoption.addArguments("--remote-allow-origins=*"); driver = new
		 * ChromeDriver(chromeoption);
		 */

		/* Without opening the url means Headless Mode - we can get the values
		 * ChromeOptions chromeoption = new ChromeOptions();
		 * chromeoption.addArguments("--headless"); driver = new
		 * ChromeDriver(chromeoption);
		 */


		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
