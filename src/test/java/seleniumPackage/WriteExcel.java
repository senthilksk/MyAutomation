package seleniumPackage;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {

	@Test
	public void writeExcel() throws IOException {
		
		
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet("Datas");
			XSSFRow rowHeader = sheet.createRow(0);
			rowHeader.createCell(0).setCellValue("Name");
			rowHeader.createCell(1).setCellValue("City");
			rowHeader.createCell(2).setCellValue("Pincode");
			XSSFRow row1 = sheet.createRow(1);
			row1.createCell(0).setCellValue("Srinivas");
			row1.createCell(1).setCellValue("Tirunelveli");
			row1.createCell(2).setCellValue("627007");			
			FileOutputStream fileoutputstream = new FileOutputStream("MyFamily.xlsx");
			workbook.write(fileoutputstream);
		}
	}
}
