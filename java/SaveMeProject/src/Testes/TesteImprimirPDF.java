package Testes;

import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter; 

public class TesteImprimirPDF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		                  
		        Document document = new Document(PageSize.A4, 72, 72, 72, 72);
		         
		        try {
		            PdfWriter.getInstance(document, new 
		             FileOutputStream("PDFTeste.pdf"));
		             
		            document.open();
		             
		            document.add(new Paragraph("Senhor God, bless para que esse teste funcione!"));
		             
		        }
		        catch(DocumentException de) {
		            System.err.println(de.getMessage());
		        }
		        catch(IOException ioe) {
		            System.err.println(ioe.getMessage());
		        }
		         
		        document.close();
		
	}

}
