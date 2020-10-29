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

@WebServlet("/AcaoInserirAnamneseUsuario")
public class AcaoInserirAnamneseUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		int IdUsuario = (int) session.getAttribute("IdUsuario");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getById(IdUsuario);
			
		usuario.setIdUsuario(IdUsuario);
		usuario.setTipoSangueUsuario(request.getParameter("tipoSangueUsuario").trim());
		usuario.setDependenciaUsuario(request.getParameter("dependenciaUsuario").trim());
		usuario.setDiabeticoUsuario(request.getParameter("diabeticoUsuario").trim());
		usuario.setHipertensaoUsuario(request.getParameter("hipertensaoUsuario").trim());
		usuario.setDoencaVenereaUsuario(request.getParameter("doencaVenereaUsuario").trim());
		usuario.setAlturaUsuario(request.getParameter("alturaUsuario").trim());
		usuario.setPesoUsuario(request.getParameter("pesoUsuario").trim());
		usuario.setColesterolUsuario(request.getParameter("colesterolUsuario").trim());
		
		if(usuario.update()){
			response.sendRedirect("RedirecionarPerfil");
			
		}else{
			request.setAttribute("situacao", "2");
			request.setAttribute("me", "Erro na atualização de dados! Por favor, tente novamente mais tarde.");
			RequestDispatcher view = request.getRequestDispatcher("TelaLogin2.jsp");
			view.forward(request, response);
		}
		
		
	}

}
