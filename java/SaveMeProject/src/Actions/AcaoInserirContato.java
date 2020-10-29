package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dados.Contatos;
import Dados.Usuario;
import Persistencia.UsuarioDAO;

@WebServlet("/AcaoInserirContato")
public class AcaoInserirContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		int IdUsuario = (int) session.getAttribute("IdUsuario");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getById(IdUsuario);
		Contatos contato = new Contatos();
		
		usuario.setIdUsuario(IdUsuario);
		contato.setNomeContato(request.getParameter("nomeContato").trim());
		contato.setTelefoneContato(request.getParameter("telefoneContato").trim());
		contato.setEmailContato(request.getParameter("emailContato").trim());
		contato.setUsuario(usuario);
		
		contato.insert();
		response.sendRedirect("RedirecionarPerfil");
		
	}


}
