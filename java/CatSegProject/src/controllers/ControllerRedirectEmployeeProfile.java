package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.indicadores;

@WebServlet("/ControllerRedirectEmployeeProfile")
public class ControllerRedirectEmployeeProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("funcionarioID");
		String Name = request.getParameter("funcionarioName");
    	indicadores i = new indicadores();
    	
    	try {
			i = i.getAll(ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	if(i != null){
        	request.setAttribute("funcionarioID", ID);
        	request.setAttribute("funcionarioName", Name);
        	request.setAttribute("id", i.getIndicadorID());
    		request.setAttribute("idade", i.getIdade());
    		request.setAttribute("setor", i.getSetor());
    		request.setAttribute("cargo", i.getCargo());
    		request.setAttribute("ctt", i.getCargaHorariaTotalDeTreinamento());
    		request.setAttribute("cst", i.getCargaHorariaSemanalDeTrabalho());
    		request.setAttribute("adv", i.getQuantidadeDeAdvertencias());
    		request.setAttribute("acd", i.getQuantidadeDeAcidentes());
        	RequestDispatcher view = request.getRequestDispatcher("Employee.jsp");
    		view.forward(request, response);
    	}
    	else{
			response.sendRedirect("Employee.jsp");
    	}
	}
}