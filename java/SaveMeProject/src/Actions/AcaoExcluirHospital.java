package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.Hospital;

@WebServlet("/AcaoExcluirHospital")
public class AcaoExcluirHospital extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Hospital hospital = new Hospital();
		
		int IdHospital = Integer.parseInt(request.getParameter("IdHospital"));
		hospital.setIdHospital(IdHospital);
		
		if(hospital.delete()){
		response.sendRedirect("RedirecionarPerfil");
		}
	}


}
