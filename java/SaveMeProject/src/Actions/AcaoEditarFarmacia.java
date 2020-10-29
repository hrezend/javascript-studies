package Actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.Farmacia;
import Persistencia.FarmaciaDAO;

@WebServlet("/AcaoEditarFarmacia")
public class AcaoEditarFarmacia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int IdFarmacia = Integer.parseInt(request.getParameter("idFarmacia"));
		
		Farmacia farmacia = new FarmaciaDAO().getById(IdFarmacia);
		
		farmacia.setIdFarmacia(IdFarmacia);
		farmacia.setLocalizacaoFarmacia(request.getParameter("localizacaoFarmacia").trim());
		farmacia.setNomeFarmacia(request.getParameter("nomeFarmacia").trim());
		
		if(farmacia.update()){
			response.sendRedirect("RedirecionarPerfil");			
		}else{
			request.setAttribute("situacao", "2");
			request.setAttribute("me", "Um erro aconteceu nos nossos servidores! Por favor, tente novamente mais tarde.");
			RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
			view.forward(request, response);
		}
		
		
	}
}
