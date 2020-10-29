package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dados.ConsultaRealizada;
import Dados.Usuario;
import Persistencia.UsuarioDAO;

@WebServlet("/AcaoInserirConsultaRealizada")
public class AcaoInserirConsultaRealizada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		int IdUsuario = (int) session.getAttribute("IdUsuario");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getById(IdUsuario);
		ConsultaRealizada consultarealizada = new ConsultaRealizada();
		
		usuario.setIdUsuario(IdUsuario);
		consultarealizada.setDataConsultaRealizada(request.getParameter("dataConsultaRealizada").trim());
		consultarealizada.setHospitalConsultaRealizada(request.getParameter("hospitalConsultaRealizada").trim());
		consultarealizada.setEspecialidadeConsultaRealizada(request.getParameter("especialidadeConsultaRealizada").trim());
		consultarealizada.setDiagnosticoConsultaRealizada(request.getParameter("diagnosticoConsultaRealizada").trim());
		consultarealizada.setUsuario(usuario);
		
		consultarealizada.insert();
		response.sendRedirect("RedirecionarPerfil");
		
	}


}
