package DDTPractice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelUsingDataFormatter {

	public static void main(String[] args) throws Throwable {
		//Step:- path Connection
		FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO\\Downloads\\ExcelData7 (1).xlsx");
		//FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData7.xlsx");
		
		//step2:- keeps the workbook/Excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step3:- Navigates into mentioned sheetname
		Sheet sheet = book.getSheet("Sheet1");
		
		//step 4:- Navigates into mentioned rowNum
		Row row = sheet.getRow(1);
		
		//step 5:- Navigates into mentioned cellNum
		Cell cell = row.getCell(2);
		
		DataFormatter format = new DataFormatter();
		String exceldata = format.formatCellValue(cell);
		System.out.println(exceldata);	

	}

	}

