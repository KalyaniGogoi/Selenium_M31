package DDTPractice;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class FetchingDataFromPDF {

	public static void main(String[] args) throws Throwable {
		File file= new File("./src/test/resources/multipage-pdf.pdf");
		PDDocument doc= PDDocument.load(file);
		int pages = doc.getNumberOfPages();
		System.out.println(pages); //fetches the number of pages in the PDF doc
		
		PDFTextStripper pdfData = new PDFTextStripper();
		String readData = pdfData.getText(doc);
		System.out.println(readData); //fetch all the pages data
		
		pdfData.setStartPage(3); //fetch the data from page 3(not from the begening)
		String pageData = pdfData.getText(doc);
		System.out.println(pageData);
		
		/* It will display only page 4
		  
		pdfData.setStartPage(4);
		pdfData.setEndPage(4);
		String pageData = pdfData.getText(doc);
		System.out.println(pageData);
		
		*/
		

	}

}
