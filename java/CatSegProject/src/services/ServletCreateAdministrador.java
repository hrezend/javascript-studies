package services;

import java.util.UUID;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.administrador;

@WebServlet("/ServletCreateAdministrador")
public class ServletCreateAdministrador extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			UUID uuid = UUID.randomUUID();
            String generatedUUID = uuid.toString();
            
            administrador administrador = new administrador();
            request.setCharacterEncoding("utf-8");
			administrador.setAdminID(generatedUUID);
			administrador.setAdminName(request.getParameter("name").trim());
			administrador.setAdminEmail(request.getParameter("email").trim());
			administrador.setAdminLogin(request.getParameter("login").trim());
			administrador.setAdminPassword(request.getParameter("password").trim());		
			
			if(administrador.create()){
				System.out.println("Um novo administrador foi cadastrado.");
				response.setStatus(201);
				response.sendRedirect("ControllerRedirectSignIn");
			}else{
				System.out.println("Erro ao cadastradar um novo administrador.");
				response.setStatus(400);
				response.sendRedirect("ControllerRedirectSignUp");
			}
		}

}