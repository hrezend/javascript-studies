package Controle;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.Contatos;
import Funcoes.EnviarEmail;
import Persistencia.ContatosDAO;

@WebServlet("/ControleEnviarEmail")
public class ControleEnviarEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContatosDAO contatosDAO = new ContatosDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int chave = (Integer)request.getSession().getAttribute("IdUsuario");
	
		if (Objects.nonNull(chave)) {			
			
			List<Contatos> listaContatos = contatosDAO.ConsultarPorId(chave);
			
			String subject = "Pedido de Socorro - SaveMe";
			String remetente = (String) request.getSession().getAttribute("NomeUsuario");;
        	String mensagem = "Um usuário do nosso sistema, "+ remetente +", emitiu um pedido de socorro. Por favor, entre em contato com o mesmo urgentemente. A vida dele pode estar em suas mãos!";

			
            for (Contatos c : listaContatos) {
        	   EnviarEmail.send(c.getEmailContato(), subject, mensagem);
        	   System.out.println( "Email enviado para: "+c.getEmailContato());
            }  
			
		} else{
			request.setAttribute("situacao", "2");
			request.setAttribute("me", "Para emitir um pedido de socorro você precisa estar logado. Por favor, tente novamente!");
			RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
			view.forward(request, response);
		}

		response.sendRedirect("RedirecionarPerfil");
	}

}
