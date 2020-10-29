package Actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dados.Usuario;


@WebServlet("/AcaoExcluirUsuario")
public class AcaoExcluirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = new Usuario();
		HttpSession session=request.getSession();

		int IdUsuario = (int) session.getAttribute("IdUsuario");
		usuario.setIdUsuario(IdUsuario);
			
			if(usuario.delete()){
				session.removeAttribute("loginUsuario");
				session.removeAttribute("IdUsuario");
				session.invalidate();
				
				request.setAttribute("situacao", "1");
				request.setAttribute("mc", "Usuário deletado com sucesso!");
				RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
				view.forward(request, response);
				
			}else{
				request.setAttribute("situacao", "2");
				request.setAttribute("me", "Não foi possível excluir este usuário. Por favor, tente novamente.");
				RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
				view.forward(request, response);
			}
		
	}

}
