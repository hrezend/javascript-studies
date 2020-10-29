package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ControllerLogoutAdministrador")
public class ControllerLogoutAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("Sessão de administrador foi encerrada!");
		session.removeAttribute("AdminID");
		session.removeAttribute("AdminEmail");
		session.removeAttribute("AdminName");;
		session.invalidate();
		response.sendRedirect("ControllerRedirectIndex");
	}

}