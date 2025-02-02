package MyPrograms;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsReport {
	
	static ExtentReports report;
	static ExtentSparkReporter spark;
	
	
	@Test
	public static ExtentReports reportGeneration() {
		spark = new ExtentSparkReporter("./ExtentReport.html");
		report = new ExtentReports();
		spark.config().setReportName("My Extent Report");
		spark.config().setDocumentTitle("My Report");
		report.attachReporter(spark);
		report.setSystemInfo("Tester", "KSK");
		return report;
	}


}
