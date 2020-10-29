package Actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.ConsultaRealizada;
import Persistencia.ConsultaRealizadaDAO;

@WebServlet("/AcaoEditarConsultaRealizada")
public class AcaoEditarConsultaRealizada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int IdConsultaRealizada = Integer.parseInt(request.getParameter("idConsultaRealizada"));
		
		ConsultaRealizada csr = new ConsultaRealizadaDAO().getById(IdConsultaRealizada);
		
		csr.setIdConsultaRealizada(IdConsultaRealizada);
		csr.setDataConsultaRealizada(request.getParameter("dataConsultaRealizada").trim());
		csr.setDiagnosticoConsultaRealizada(request.getParameter("diagnosticoConsultaRealizada").trim());
		csr.setEspecialidadeConsultaRealizada(request.getParameter("especialidadeConsultaRealizada").trim());
		csr.setHospitalConsultaRealizada(request.getParameter("hospitalConsultaRealizada").trim());
		
		
		if(csr.update()){
			response.sendRedirect("RedirecionarPerfil");			
		}else{
			request.setAttribute("situacao", "2");
			request.setAttribute("me", "Um erro aconteceu nos nossos servidores! Por favor, tente novamente mais tarde.");
			RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
			view.forward(request, response);
		}
	}
}
