package Actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dados.ConsultaFutura;
import Dados.Usuario;
import Persistencia.UsuarioDAO;

@WebServlet("/AcaoInserirConsultaFutura")
public class AcaoInserirConsultaFutura extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		int IdUsuario = (int) session.getAttribute("IdUsuario");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ConsultaFutura consultafutura = new ConsultaFutura();
		Usuario usuario = usuarioDAO.getById(IdUsuario);
		
		usuario.setIdUsuario(IdUsuario);
		consultafutura.setDataConsultaFutura(request.getParameter("dataConsultaFutura").trim());
		consultafutura.setHospitalConsultaFutura(request.getParameter("hospitalConsultaFutura").trim());
		consultafutura.setEspecialidadeConsultaFutura(request.getParameter("especialidadeConsultaFutura").trim());
		consultafutura.setUsuario(usuario);
		
		consultafutura.insert();
		response.sendRedirect("RedirecionarPerfil");
		
	}


}
