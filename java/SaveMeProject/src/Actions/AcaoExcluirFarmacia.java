package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.Farmacia;

@WebServlet("/AcaoExcluirFarmacia")
public class AcaoExcluirFarmacia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Farmacia farmacia = new Farmacia();
		
		int IdFarmacia = Integer.parseInt(request.getParameter("IdFarmacia"));
		farmacia.setIdFarmacia(IdFarmacia);
		
		if(farmacia.delete()){
		response.sendRedirect("RedirecionarPerfil");
		}
	}


}
