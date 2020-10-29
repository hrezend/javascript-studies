package Actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.Alergia;
import Persistencia.AlergiaDAO;

@WebServlet("/AcaoEditarAlergia")
public class AcaoEditarAlergia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int IdAlergia = Integer.parseInt(request.getParameter("idAlergia"));
		
		Alergia alergia = new AlergiaDAO().getById(IdAlergia);
		
		alergia.setIdAlergia(IdAlergia);
		alergia.setDescricaoAlergia(request.getParameter("descricaoAlergia").trim());
		
		if(alergia.update()){
			response.sendRedirect("RedirecionarPerfil");			
		}else{
			request.setAttribute("situacao", "2");
			request.setAttribute("me", "Um erro aconteceu nos nossos servidores! Por favor, tente novamente mais tarde.");
			RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
			view.forward(request, response);
		}
		
	}
}
