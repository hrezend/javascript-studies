package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.funcionario;

@WebServlet("/ServletDeleteEmployee")
public class ServletDeleteEmployee extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            
            funcionario f = new funcionario();
            request.setCharacterEncoding("utf-8");
            String FID = request.getParameter("funcionarioID").trim();	
			
			if(f.delete(FID)){
				System.out.println("Um funcionário foi apagado.");
				response.setStatus(200);
				response.sendRedirect("ControllerRedirectDashboard");
			}else{
				System.out.println("Erro ao apagar um funcionário.");
				response.setStatus(400);
				response.sendRedirect("ControllerRedirectDashboard");
			}
		}

}