package MyPrograms;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGProgram extends InitializeDriver{

	static WebDriver driver;	

	@BeforeSuite
	public void getDriver(){
		driver = initDriver();		
	}


	@Test
	public void failMethod() {

		driver.get("https://www.youtube.com/");	

		if(driver.getTitle().equals("YouTubes")) {	
			System.out.println(driver.getTitle());
			Assert.assertTrue(true);
		}else {		
			System.out.println(driver.getTitle());
			Assert.assertTrue(false);
		}

	}

	@Test
	public void passMethod() {

		driver.get("https://www.google.com/");

		if(driver.getTitle().equals("Google")) {	
			System.out.println(driver.getTitle());
			Assert.assertTrue(true);
		}else {		
			System.out.println(driver.getTitle());
			Assert.assertTrue(false);
		}

	}


	@Test
	public void skipTestConditionally() {
		boolean skipCondition = true; // Change this to false to see the test execute
		System.out.println("This test checks a condition before deciding to run.");

		if (skipCondition) {
			throw new SkipException("Skipping this test due to a condition.");
		}

		System.out.println("This test is running because the condition was not met.");
	}


	@AfterSuite
	public void end() {
		driver.close();
	}


	public static String getScreenShot(WebDriver driver,String name) {

		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"\\Screenshots\\"+name+".png");
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return destination.getAbsolutePath();

	}
}
