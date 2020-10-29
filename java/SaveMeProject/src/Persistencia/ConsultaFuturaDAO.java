package Persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Dados.ConsultaFutura;
import Conexao.Connection;

public class ConsultaFuturaDAO extends Persistencia<ConsultaFutura>{

	public ConsultaFuturaDAO(){
		super(ConsultaFutura.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsultaFutura> ConsultarPorId(int IdUsuario) {
	        EntityManager em = new Connection().getConnection();
	        List<ConsultaFutura> consultasfuturas = new ArrayList<>();
	        
	        try {
	        	TypedQuery<ConsultaFutura> q = em.createNamedQuery("consultarConsultaFPorIdU", ConsultaFutura.class);
	        	q.setParameter("idUsuario", IdUsuario);
	        	consultasfuturas = q.getResultList();     
	        } catch (Exception e) {
	            System.err.println(e);
	        } finally {
	            em.close();
	        }
	        return consultasfuturas;
	    }
	
	
}
