package Actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dados.Usuario;

@WebServlet("/AcaoInserirUsuario")
public class AcaoInserirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			Usuario usuario = new Usuario();
			usuario.setNomeUsuario(request.getParameter("nomeUsuario").trim());
			usuario.setDataNascUsuario(request.getParameter("dataNascUsuario").trim());
			usuario.setCpfUsuario(request.getParameter("cpfUsuario").trim());
			usuario.setRgUsuario(request.getParameter("rgUsuario").trim());
			usuario.setEnderecoUsuario(request.getParameter("enderecoUsuario").trim());
			usuario.setTelefoneUsuario(request.getParameter("telefoneUsuario").trim());
			usuario.setLoginUsuario(request.getParameter("loginUsuario").trim());
			usuario.setSenhaUsuario(request.getParameter("senhaUsuario").trim());
			usuario.setEmailUsuario(request.getParameter("emailUsuario").trim());
			usuario.setEstCivilUsuario(request.getParameter("estCivilUsuario").trim());
			usuario.setUfUsuario(request.getParameter("ufUsuario").trim());
			usuario.setCidadeUsuario(request.getParameter("cidadeUsuario").trim());
			usuario.setCepUsuario(request.getParameter("cepUsuario").trim());
			
			int sexo = Integer.parseInt(request.getParameter("sexoUsuario"));
			String sexoUsuario="";
			
			if(sexo==1)
				sexoUsuario="Masculino";
			else if(sexo==2)
				sexoUsuario="Feminino";
			
			usuario.setSexoUsuario(sexoUsuario);
			
			
			if(usuario.insert()){
				request.setAttribute("situacao", "1");
				request.setAttribute("mc", "Usuário cadastrado com sucesso!");
				RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
				view.forward(request, response);
				
				
			}else{
				request.setAttribute("situacao", "2");
				request.setAttribute("me", "Não foi possível cadastrar o usuário! Por favor, tente novamente.");
				RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
				view.forward(request, response);
			}
		}

}
