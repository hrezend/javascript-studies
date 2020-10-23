package services;

import java.util.UUID;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.funcionario;

@WebServlet("/ServletAddEmployee")
public class ServletAddEmployee extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			UUID uuid = UUID.randomUUID();
            String generatedUUID = uuid.toString();
            
            funcionario f = new funcionario();
            request.setCharacterEncoding("utf-8");
			f.setFuncionarioID(generatedUUID);
			f.setFuncionarioName(request.getParameter("funcionarioName").trim());
			f.setFuncionarioEmail(request.getParameter("funcionarioEmail").trim());
			f.setFuncionarioTelefone(request.getParameter("funcionarioTelephone").trim());
			f.setFuncionarioCPF(request.getParameter("funcionarioCPF").trim());		
			
			if(f.create()){
				System.out.println("Um novo funcionário foi cadastrado.");
				RequestDispatcher view = request.getRequestDispatcher("ControllerRedirectDashboard");
				view.forward(request, response);
			}else{
				System.out.println("Erro ao cadastradar um novo funcionário.");
				RequestDispatcher view = request.getRequestDispatcher("ControllerRedirectDashboard");
				view.forward(request, response);
			}
		}

}