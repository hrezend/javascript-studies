package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.ConsultaRealizada;

@WebServlet("/AcaoExcluirConsultaRealizada")
public class AcaoExcluirConsultaRealizada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConsultaRealizada consultarealizada = new ConsultaRealizada();
		
		int IdConsultaRealizada = Integer.parseInt(request.getParameter("IdConsultaRealizada"));
		consultarealizada.setIdConsultaRealizada(IdConsultaRealizada);
		
		if(consultarealizada.delete()){
		response.sendRedirect("RedirecionarPerfil");
		}
	}


}
