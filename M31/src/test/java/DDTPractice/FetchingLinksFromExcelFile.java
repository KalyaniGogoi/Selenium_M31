package DDTPractice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingLinksFromExcelFile {

	public static void main(String[] args) throws Throwable {
		// Step:- path Connection
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData7.xlsx");

		// step2:- keeps the workbook/Excel file in read mode
		Workbook book = WorkbookFactory.create(fis);

		// step3:- Navigates into mentioned sheetname
		Sheet sheet = book.getSheet("Sheet1");

		int rowNum = sheet.getLastRowNum();

		for (int i = 0; i < rowNum; i++) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			String links = cell.getStringCellValue();
			System.out.println(links);
		}
	}

	}

