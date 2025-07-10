package DDTPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertTotalLinksIntoExcel {

	public static void main(String[] args) throws Throwable {
		//Step:- path Connection
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData7.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		 List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		 int count = allLinks.size(); // get the total number of links
		 System.out.println(count);
		 // write all the links in the excel sheet
		 for(int i=0; i<count;i++)
		 {
			Row row = sheet.createRow(i); 
			Cell cell = row.createCell(0);
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
		 }
		 
		 FileOutputStream fos= new FileOutputStream("./src/test/resources/ExcelData7.xlsx");
		 book.write(fos);
		 book.close();
		 
		 // print all the links in the console
		 int rowNum = sheet.getLastRowNum();
		 for(int i=0; i<rowNum;i++)
		 {
			 Row row1 = sheet.getRow(i);
			 Cell cell1 = row1.getCell(0);
			 String links = cell1.getStringCellValue();
			 System.out.println(links);
		 }	

	}

}
