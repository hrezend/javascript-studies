package Controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dados.Usuario;
import Persistencia.UsuarioDAO;


@WebServlet("/ControleLogin")
public class ControleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Usuario usuario = null; 
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuario = usuarioDAO.getByLogAndSen(login, senha);
		
		if (usuario != null){
			HttpSession session = request.getSession();
			
			session.setAttribute("IdUsuario", usuario.getIdUsuario());
			session.setAttribute("NomeUsuario", usuario.getNomeUsuario());
			session.setAttribute("loginUsuario", usuario.getLoginUsuario());
			session.setMaxInactiveInterval(2000);

			response.sendRedirect("RedirecionarPerfil");
		}
	
		else {
			request.setAttribute("situacao", "2");
			request.setAttribute("me", "Usuário ou senha incorreto. Por favor, tente novamente!");
			RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
			view.forward(request, response);
		}
		
		
	}

}
