package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dados.Farmacia;
import Dados.Usuario;
import Persistencia.UsuarioDAO;

@WebServlet("/AcaoInserirFarmacia")
public class AcaoInserirFarmacia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		int IdUsuario = (int) session.getAttribute("IdUsuario");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getById(IdUsuario);
		
		Farmacia farmacia = new Farmacia();
		
		usuario.setIdUsuario(IdUsuario);
		farmacia.setNomeFarmacia(request.getParameter("nomeFarmacia").trim());
		farmacia.setLocalizacaoFarmacia(request.getParameter("localizacaoFarmacia").trim());
		farmacia.setUsuario(usuario);
		
		farmacia.insert();
		response.sendRedirect("RedirecionarPerfil");
		
	}


}
