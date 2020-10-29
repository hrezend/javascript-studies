package Actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.ConsultaFutura;
import Persistencia.ConsultaFuturaDAO;

@WebServlet("/AcaoEditarConsultaFutura")
public class AcaoEditarConsultaFutura extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int IdConsultaFutura = Integer.parseInt(request.getParameter("idConsultaFutura"));
		
		ConsultaFutura csf = new ConsultaFuturaDAO().getById(IdConsultaFutura);
		
		csf.setIdConsultaFutura(IdConsultaFutura);
		csf.setDataConsultaFutura(request.getParameter("dataConsultaFutura").trim());
		csf.setEspecialidadeConsultaFutura(request.getParameter("especialidadeConsultaFutura").trim());
		csf.setHospitalConsultaFutura(request.getParameter("hospitalConsultaFutura").trim());
		
		
		if(csf.update()){
			response.sendRedirect("RedirecionarPerfil");			
		}else{
			request.setAttribute("situacao", "2");
			request.setAttribute("me", "Um erro aconteceu nos nossos servidores! Por favor, tente novamente mais tarde.");
			RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
			view.forward(request, response);
		}
		
	}
}
