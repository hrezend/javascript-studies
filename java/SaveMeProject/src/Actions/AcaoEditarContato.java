package Actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.Contatos;
import Persistencia.ContatosDAO;

@WebServlet("/AcaoEditarContato")
public class AcaoEditarContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int IdContato = Integer.parseInt(request.getParameter("idContato"));
		
		Contatos ctt = new ContatosDAO().getById(IdContato);
		
		ctt.setIdContato(IdContato);
		ctt.setEmailContato(request.getParameter("emailContato").trim());
		ctt.setNomeContato(request.getParameter("nomeContato").trim());
		ctt.setTelefoneContato(request.getParameter("telefoneContato").trim());
		
		if(ctt.update()){
			response.sendRedirect("RedirecionarPerfil");			
		}else{
			request.setAttribute("situacao", "2");
			request.setAttribute("me", "Um erro aconteceu nos nossos servidores! Por favor, tente novamente mais tarde.");
			RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
			view.forward(request, response);
		}
		
		
		
		
		
		
	}
}
