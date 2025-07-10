package DDTPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataIntoExcelFile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData7.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("QSP");
		
		//String cellvalue = cell.getStringCellValue();
		//System.out.println(cellvalue);
		
		DataFormatter format = new DataFormatter();
		String exceldata = format.formatCellValue(cell);
		System.out.println(exceldata);
		
		FileOutputStream fos= new FileOutputStream("./src/test/resources/ExcelData7.xlsx");
		book.write(fos);
		book.close();
		

	}

}
