package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.Alergia;

@WebServlet("/AcaoExcluirAlergia")
public class AcaoExcluirAlergia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Alergia alergia = new Alergia();
		
		int IdAlergia = Integer.parseInt(request.getParameter("IdAlergia"));
		alergia.setIdAlergia(IdAlergia);
		
		if(alergia.delete()){
		response.sendRedirect("RedirecionarPerfil");
		}
	}

}
