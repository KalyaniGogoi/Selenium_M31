package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row;


public class Excel_Utility {
	
	public String readDataFromExcelFile(String sheetName,int rowNo, int cellNo) throws Throwable 
	
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String excelData= wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		//System.out.println(excelData);
		return excelData;
	}
	
	public String readDataFromExcelFileUsingDataFormatter(String sheetName,int rowNo, int cellNo) throws Throwable 
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/Vtiger.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		//Row row = sheet.getRow(rowNo);
		//Cell cell1 = row.getCell(cellNo);
		Row row1 = sheet.getRow(rowNo);
		Cell cell1 = row1.getCell(cellNo);
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell1);
		System.out.println(ExcelData);
		return ExcelData;
		
		
			
	}
	
	

}
