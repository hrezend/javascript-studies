package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.ConsultaFutura;

@WebServlet("/AcaoExcluirConsultaFutura")
public class AcaoExcluirConsultaFutura extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConsultaFutura consultafutura = new ConsultaFutura();
		
		int IdConsultaFutura = Integer.parseInt(request.getParameter("IdConsultaFutura"));
		consultafutura.setIdConsultaFutura(IdConsultaFutura);		
		
		if(consultafutura.delete()){
			response.sendRedirect("RedirecionarPerfil");
		}
	}

}
