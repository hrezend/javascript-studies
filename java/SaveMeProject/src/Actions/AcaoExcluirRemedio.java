package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.Remedio;

@WebServlet("/AcaoExcluirRemedio")
public class AcaoExcluirRemedio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Remedio remedio = new Remedio();
		
		int IdRemedio = Integer.parseInt(request.getParameter("IdRemedio"));
		remedio.setIdRemedio(IdRemedio);
		
		if(remedio.delete()){
		response.sendRedirect("RedirecionarPerfil");
		}
	}

}
