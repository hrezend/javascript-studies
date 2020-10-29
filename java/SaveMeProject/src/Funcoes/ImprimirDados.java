package Funcoes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
public class ImprimirDados {


    public static void Imprimir(){
    Document document = new Document(PageSize.A4, 72, 72, 72, 72);
    FileOutputStream os=null;
    try {
        PdfWriter.getInstance(document, new 
         FileOutputStream("pdff.pdf"));
         os=new FileOutputStream("teste3.pdf");
         document.open();
         
        // step 4: we add a paragraph to the document
        document.add(new Paragraph("teste"));
        File file = new File("D:\\User Diego");
         
    }
    catch(DocumentException de) {
        System.err.println(de.getMessage());
    }
    catch(IOException ioe) {
        System.err.println(ioe.getMessage());
    }
     
    // step 5: we close the document
    document.close();
    }
}
