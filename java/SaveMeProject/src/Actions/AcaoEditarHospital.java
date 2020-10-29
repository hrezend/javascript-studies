package Actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.Hospital;
import Persistencia.HospitalDAO;

@WebServlet("/AcaoEditarHospital")
public class AcaoEditarHospital extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int IdHospital = Integer.parseInt(request.getParameter("idHospital"));
		
		Hospital hospital = new HospitalDAO().getById(IdHospital);
		
		hospital.setIdHospital(IdHospital);
		hospital.setLocalizacaoHospital(request.getParameter("localizacaoHospital").trim());
		hospital.setNomeHospital(request.getParameter("nomeHospital").trim());
			
		if(hospital.update()){
			response.sendRedirect("RedirecionarPerfil");			
		}else{
			request.setAttribute("situacao", "2");
			request.setAttribute("me", "Um erro aconteceu nos nossos servidores! Por favor, tente novamente mais tarde.");
			RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
			view.forward(request, response);
		}
	}
}
