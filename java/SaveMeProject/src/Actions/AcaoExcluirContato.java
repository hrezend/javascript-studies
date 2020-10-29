package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.Contatos;

@WebServlet("/AcaoExcluirContato")
public class AcaoExcluirContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contatos contato = new Contatos();
		
		int IdContato = Integer.parseInt(request.getParameter("IdContato"));
		contato.setIdContato(IdContato);
		
		if(contato.delete()){
		response.sendRedirect("RedirecionarPerfil");
		}
	}

}
