package seleniumPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class WithoutdriverSetting {

	WebDriver driver;

	@Test
	public void openUrl() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "D:\\Browser"); From selenium 4, we dont want this line
		//SeleniumManager will find the driver path
		
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		// Height and Width of the element
		System.out.println("Height of the username textbox - "+driver.findElement(By.id("login1")).getRect().getDimension().getHeight());
		System.out.println("Width of the username textbox - "+driver.findElement(By.id("login1")).getRect().getDimension().getWidth());
		
		// Clicking the checkbox which is in the lefthand side of the link
		//above(), Below(),toLeftOf, toLRightOf are available
		WebElement forgotPwdLink = driver.findElement(By.xpath("//u[normalize-space(text())='Forgot Password?']"));		
		Thread.sleep(3000);
		driver.findElement(with(By.tagName("input")).toLeftOf(forgotPwdLink)).click();		
		Thread.sleep(3000);
		driver.findElement(with(By.tagName("input")).above(forgotPwdLink)).sendKeys("RAm");
		Thread.sleep(3000);
		driver.quit();
	}

}
