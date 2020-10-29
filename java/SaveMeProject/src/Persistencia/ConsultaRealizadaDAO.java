package Persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Dados.ConsultaRealizada;
import Conexao.Connection;

public class ConsultaRealizadaDAO extends Persistencia<ConsultaRealizada>{

	public ConsultaRealizadaDAO(){
		super(ConsultaRealizada.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsultaRealizada> ConsultarPorId(int IdUsuario) {
	        EntityManager em = new Connection().getConnection();
	        List<ConsultaRealizada> consultasrealizadas = new ArrayList<>();
	        
	        try {
	        	TypedQuery<ConsultaRealizada> q = em.createNamedQuery("consultarConsultaRPorIdU", ConsultaRealizada.class);
	        	q.setParameter("idUsuario", IdUsuario);
	        	consultasrealizadas = q.getResultList();     
	        } catch (Exception e) {
	            System.err.println(e);
	        } finally {
	            em.close();
	        }
	        return consultasrealizadas;
	    }

	
}
