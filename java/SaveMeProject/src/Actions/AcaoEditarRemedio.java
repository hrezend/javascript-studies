package Actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.Remedio;
import Persistencia.RemedioDAO;

@WebServlet("/AcaoEditarRemedio")
public class AcaoEditarRemedio extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int IdRemedio = Integer.parseInt(request.getParameter("idRemedio"));
		
		Remedio remedio = new RemedioDAO().getById(IdRemedio);
		
		remedio.setIdRemedio(IdRemedio);
		remedio.setDescricaoUso(request.getParameter("descricaoUso").trim());
		remedio.setNomeRemedio(request.getParameter("nomeRemedio").trim());
			
		if(remedio.update()){
			response.sendRedirect("RedirecionarPerfil");			
		}else{
			request.setAttribute("situacao", "2");
			request.setAttribute("me", "Um erro aconteceu nos nossos servidores! Por favor, tente novamente mais tarde.");
			RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
			view.forward(request, response);
		}
		
	}
}
