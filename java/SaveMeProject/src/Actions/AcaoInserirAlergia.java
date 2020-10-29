package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dados.Alergia;
import Dados.Usuario;
import Persistencia.UsuarioDAO;

@WebServlet("/AcaoInserirAlergia")
public class AcaoInserirAlergia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		int IdUsuario = (int) session.getAttribute("IdUsuario");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getById(IdUsuario);
		
		Alergia alergia = new Alergia();
		
		usuario.setIdUsuario(IdUsuario);
		alergia.setDescricaoAlergia(request.getParameter("descricaoAlergia").trim());
		alergia.setUsuario(usuario);
		
		alergia.insert();
		response.sendRedirect("RedirecionarPerfil");
	}


}
