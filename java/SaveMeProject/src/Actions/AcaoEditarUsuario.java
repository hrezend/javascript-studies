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
import Persistencia.UsuarioDAO;

@WebServlet("/AcaoEditarUsuario")
public class AcaoEditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		int IdUsuario = (int) session.getAttribute("IdUsuario");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getById(IdUsuario);
		
		usuario.setNomeUsuario(request.getParameter("nomeUsuario").trim());
		usuario.setTelefoneUsuario(request.getParameter("telefoneUsuario").trim());
		usuario.setEstCivilUsuario(request.getParameter("estCivilUsuario").trim());
		usuario.setAlturaUsuario(request.getParameter("alturaUsuario").trim());
		usuario.setPesoUsuario(request.getParameter("pesoUsuario").trim());
		usuario.setColesterolUsuario(request.getParameter("colesterolUsuario").trim());
		usuario.setDoencaVenereaUsuario(request.getParameter("doencaVenereaUsuario").trim());
		usuario.setHipertensaoUsuario(request.getParameter("hipertensaoUsuario").trim());
		usuario.setDiabeticoUsuario(request.getParameter("diabeticoUsuario").trim());
		
		usuario.setEnderecoUsuario(request.getParameter("enderecoUsuario").trim());
		usuario.setCidadeUsuario(request.getParameter("cidadeUsuario").trim());
		usuario.setUfUsuario(request.getParameter("ufUsuario").trim());
		usuario.setCepUsuario(request.getParameter("cepUsuario").trim());
		
		usuario.setIdUsuario(IdUsuario);
				
		if(usuario.update()){
			response.sendRedirect("RedirecionarPerfil");
			
		}else{
			request.setAttribute("situacao", "2");
			request.setAttribute("me", "Erro na edição de usuário! Por favor, tente novamente.");
			RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
			view.forward(request, response);
		}
		
		
		
	}

}