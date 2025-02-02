package MyPrograms;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersPgm implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentsReport.reportGeneration();
	ThreadLocal<ExtentTest> local = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
	
		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Senthil").assignCategory("Smoke testing").assignDevice("Chrome");
		local.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		ITestListener.super.onTestSuccess(result);
	//	System.out.println(result.getName().toString()+" onTestSuccess");	
		//test.pass(result.getMethod().getMethodName()+" Successful");
		local.get().log(Status.PASS, "Successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		ITestListener.super.onTestFailure(result);
	WebDriver driver = null;
	//	test.fail(result.getThrowable());
		local.get().fail(result.getThrowable());
		Object instance = result.getInstance();
		Class currentClass = result.getTestClass().getRealClass();		
			 try {
				driver=(WebDriver) currentClass.getDeclaredField("driver").get(instance);
			} catch (Exception e) {
				e.printStackTrace();
			} 	
		test.addScreenCaptureFromPath(TestNGProgram.getScreenShot(driver, result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		ITestListener.super.onTestSkipped(result);
		System.out.println(result.getName().toString()+" onTestSkipped");
		System.out.println(result.getMethod().getMethodName() +" onTestSkipped");
		local.get().log(Status.SKIP, "Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		System.out.println(result.getName().toString()+" onTestFailedBut");
		System.out.println(result.getMethod().getMethodName() +" onTestFailedBut");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		ITestListener.super.onTestFailedWithTimeout(result);
		System.out.println(result.getName().toString()+" onTestFailedwith");
		System.out.println(result.getMethod().getMethodName() +" onTestFailedwith");
	}

	@Override
	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
		System.out.println(context.getName().toString()+" onStart");
		//test = extent.createTest("info").assignAuthor("Senthil").assignCategory("Smoke testing").assignDevice("Chrome");

	}

	@Override
	public void onFinish(ITestContext context) {

		ITestListener.super.onFinish(context);
		System.out.println(context.getName().toString()+" onFinish");
		extent.flush();
	}




}
