package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.indicadores;

@WebServlet("/ServletUpdateIndicator")
public class ServletUpdateIndicator extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{         
            indicadores i = new indicadores();
            request.setCharacterEncoding("utf-8");
            i.setCargo(request.getParameter("cargo").trim());
            i.setSetor(request.getParameter("setor").trim());
            i.setEmployeeID(request.getParameter("employeeID").trim());
            i.setIdade(Integer.parseInt(request.getParameter("idade")));
            i.setCargaHorariaSemanalDeTrabalho(Integer.parseInt(request.getParameter("cargaHorariaSemanalDeTrabalho")));
            i.setCargaHorariaTotalDeTreinamento(Integer.parseInt(request.getParameter("cargaHorariaTotalDeTreinamento")));
            i.setQuantidadeDeAcidentes(Integer.parseInt(request.getParameter("quantidadeDeAcidentes")));
            i.setQuantidadeDeAdvertencias(Integer.parseInt(request.getParameter("quantidadeDeAdvertencias")));
			
			if(i.update()){
				System.out.println("Os indicadores do funcionário foram atualizados.");
				response.setStatus(201);
				response.sendRedirect("ControllerRedirectDashboard");
			}else{
				System.out.println("Erro ao editar os indicadores do funcionário.");
				response.setStatus(400);
				response.sendRedirect("ControllerRedirectDashboard");
			}
		}

}