package MyPrograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DataProviderExcel {

	ExtentReports report;
	ExtentSparkReporter spark;
	ExtentTest test;


	@BeforeSuite
	public void setUp() {
		spark = new ExtentSparkReporter("./ExtentReport.html");
		report = new ExtentReports();
		spark.config().setReportName("My Extent Report");
		spark.config().setDocumentTitle("My Report");
		report.attachReporter(spark);
		report.setSystemInfo("TEster", "KSK");
	}


	@Test(dataProvider = "From Excel")
	public void firstMethod(String name,String city) {
		test = report.createTest("Verify the page title").assignAuthor("Senthil").assignCategory("Smoke testing").assignDevice("Chrome");
		System.out.println(name+"   -   "+city);
		test.pass(name);
		test.pass(city);

	}

	@Test
	public void getFromProp() {
		
		Properties prop = new Properties();
		FileInputStream input = null;
	System.out.println(System.getProperty("user.dir"));
		try {
			input = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Datas.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("Father"));
		System.out.println(prop.getProperty("Mother"));
	}

	@DataProvider(name="From Excel")
	public Object[][]  getFromExcel() {
		return fromExcel();
	}


	@Test
	public Object[][] fromExcel(){

		Object[][] data = null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new File("src\\test\\resources\\Datas.xlsx"));
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			System.out.println("Rows : "+rows);
			int cells = sheet.getRow(0).getLastCellNum();	
			System.out.println("Cells : "+cells);
			data = new Object[rows][cells];
			for (int i = 1; i <=rows; i++) {		
				XSSFRow	row = sheet.getRow(i);
				for (int j = 0; j < cells; j++) {					
					XSSFCell cell = row.getCell(j);		
				//	data[i-1][j]=cell.getStringCellValue();
					data[i-1][j]=getCellValue(cell);
				} 
			}

			workbook.close();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;

	}
	
	public Object getCellValue(XSSFCell cell) {
		 Object o = null;
		 switch (cell.getCellType()) {
		case BLANK:
			break;
		case BOOLEAN:
			o=cell.getBooleanCellValue();
			break;
		case ERROR:
			break;
		case FORMULA:
			break;
		case NUMERIC:
			o=cell.getNumericCellValue();
			break;
		case STRING:
			o=cell.getStringCellValue();
			break;
		case _NONE:
			break;
		default:
			break; 	 
         
         } 	
		
		return o;
		
		
		
	}

	@AfterSuite
	public void end() {

		report.flush();

	}


}
