package testng;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerITest.class)
public class TestNGAnnotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@BeforeTest
	public void beforeClass() {
		System.out.println("Before TEst");
	}
	
	@BeforeClass
	public void beforeTest() {
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@Test(priority = 0)
	public void inTest() {
		System.out.println("Test Priority 0");
	}

	@Test(priority = -1)
	public void inTestNeg() {
		System.out.println("Test Priority Neg");
	}
	
	@Test(priority = 1)
	public void inTest1() {
		System.out.println("Test 1  Priority 1");
	}

	@Test(priority = 2,invocationCount = 2)
	public void inTest2() {
		System.out.println("Test 2 Priority 2");
	}
	
	@Test()
	public void failTest() {
		System.out.println("Fail test");
		Assert.assertEquals(2, 3);
	}
	
	@Test(dependsOnMethods = "failTest")
	public void skipTest() {
		System.out.println("skip test");		
	}	
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}	
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
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

/*
 * priority works from negative to positive
 * 
 * @Listener(listenerclassname.class)  --> it will implement listener in the current java file
 * or
 * Can add Listener in the suite xml file
 * 
 * 
 */
