package Actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import Funcoes.ImprimirDados;

@WebServlet("/AcaoImprimir")
public class AcaoImprimir extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		ImprimirDados.Imprimir();
		Document document = new Document(PageSize.A4, 72, 72, 72, 72);
	    FileOutputStream os=null;
	    try {
	        PdfWriter.getInstance(document, new 
	         FileOutputStream("pdff.pdf"));
	         os=new FileOutputStream("teste3.pdf");
	         document.open();
	         
	        // step 4: we add a paragraph to the document
	        document.add(new Paragraph("Eu não sei, de onde vem, essa força que me leva a fazer merda, mas eu sei, não faz bem, "
					+ "mas confesso que no fundo duvidei, "
					+ "tive medo é segredo, depois que eu percebi que me lasquei, mas agora, "
					+ "é a hora eu vou gritar pra todo mundo de uma vez, "
					+ "eu tou muito ferrado, tou estragando tudo..."));
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
