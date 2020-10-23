package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.funcionario;

@WebServlet("/ControllerRedirectDashboard")
public class ControllerRedirectDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 if(session.getAttribute("adminID") == null){
			response.sendRedirect("ControllerRedirectSignIn");
		 }
		 else if(session.getAttribute("adminID") != null){
			List <funcionario> f = null;
			try {
				f = funcionario.getFuncionarios();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("ListaFuncionarios", f);
			RequestDispatcher view = request.getRequestDispatcher("Dashboard.jsp");
			view.forward(request, response);
		}
	}
}