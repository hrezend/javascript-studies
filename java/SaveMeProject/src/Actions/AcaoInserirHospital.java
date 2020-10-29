package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dados.Hospital;
import Dados.Usuario;
import Persistencia.UsuarioDAO;

@WebServlet("/AcaoInserirHospital")
public class AcaoInserirHospital extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		int IdUsuario = (int) session.getAttribute("IdUsuario");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getById(IdUsuario);
		Hospital hospital = new Hospital();
		
		usuario.setIdUsuario(IdUsuario);
		hospital.setNomeHospital(request.getParameter("nomeHospital").trim());
		hospital.setLocalizacaoHospital(request.getParameter("localizacaoHospital").trim());
		hospital.setUsuario(usuario);
		
		hospital.insert();
		response.sendRedirect("RedirecionarPerfil");
		
	}


}
