package Controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dados.Alergia;
import Dados.ConsultaFutura;
import Dados.ConsultaRealizada;
import Dados.Contatos;
import Dados.Farmacia;
import Dados.Hospital;
import Dados.Remedio;
import Dados.Usuario;
import Persistencia.AlergiaDAO;
import Persistencia.ConsultaFuturaDAO;
import Persistencia.ConsultaRealizadaDAO;
import Persistencia.ContatosDAO;
import Persistencia.FarmaciaDAO;
import Persistencia.HospitalDAO;
import Persistencia.RemedioDAO;


@WebServlet("/RedirecionarPerfil")
public class RedirecionarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 HttpSession session=request.getSession();
	 if(session.getAttribute("loginUsuario") == null){
		response.sendRedirect("RedirecionarLogin");
	}else if(session.getAttribute("loginUsuario")!=null){
		String login=(String) session.getAttribute("loginUsuario");
		int IdUsuario=(int) session.getAttribute("IdUsuario");
		
		Usuario usuario = new Usuario();
		List <Usuario> usuarios = usuario.getByLog(login);
		request.setAttribute("ListaUsuario", usuarios);

		AlergiaDAO alergiaDAO = new AlergiaDAO();
		List<Alergia> alergias = alergiaDAO.ConsultarPorId(IdUsuario);
        request.setAttribute("ListaAlergia", alergias);
        
        RemedioDAO remedioDAO = new RemedioDAO();
        List<Remedio> remedios = remedioDAO.ConsultarPorId(IdUsuario);
        request.setAttribute("ListaRemedio", remedios);
        
        HospitalDAO hospitalDAO = new HospitalDAO();
        List<Hospital> hospitais = hospitalDAO.ConsultarPorId(IdUsuario);
        request.setAttribute("ListaHospital", hospitais);
        
        FarmaciaDAO farmaciaDAO = new FarmaciaDAO();
        List<Farmacia> farmacias = farmaciaDAO.ConsultarPorId(IdUsuario);
        request.setAttribute("ListaFarmacia", farmacias);
        
        ConsultaRealizadaDAO consultarealizadaDAO = new ConsultaRealizadaDAO();
        List<ConsultaRealizada> consultasrealizadas = consultarealizadaDAO.ConsultarPorId(IdUsuario);
        request.setAttribute("ListaConsultaRealizada", consultasrealizadas);
        
        ConsultaFuturaDAO consultafuturaDAO = new ConsultaFuturaDAO();
        List<ConsultaFutura> consultasfuturas = consultafuturaDAO.ConsultarPorId(IdUsuario);
        request.setAttribute("ListaConsultaFutura", consultasfuturas);
        
        ContatosDAO contatoDAO = new ContatosDAO();
        List<Contatos> contatos = contatoDAO.ConsultarPorId(IdUsuario);
        request.setAttribute("ListaContatos", contatos);

        
        
		
		RequestDispatcher view = request.getRequestDispatcher("TelaPerfil.jsp");
		view.forward(request, response);
		
	}
	 
	}

}