package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.administrador;

@WebServlet("/ControllerLoginAdministrador")
public class ControllerLoginAdministrador extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		administrador adminLogin = new administrador();

        try {
    		adminLogin = adminLogin.login(login, password);
			HttpSession session = request.getSession();
			session.setAttribute("adminID", adminLogin.getAdminID());
			session.setAttribute("adminName", adminLogin.getAdminName());
			session.setAttribute("adminEmail", adminLogin.getAdminEmail());
			System.out.println("Sessão com admnistrador: " + adminLogin.getAdminID() + " foi iniciada!");
			response.sendRedirect("ControllerRedirectDashboard");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("ControllerRedirectSignIn");
		}
	}

}