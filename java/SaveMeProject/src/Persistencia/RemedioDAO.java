package Persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Dados.Remedio;
import Conexao.Connection;

public class RemedioDAO extends Persistencia<Remedio>{

	public RemedioDAO(){
		super(Remedio.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Remedio> ConsultarPorId(int IdUsuario) {
	        EntityManager em = new Connection().getConnection();
	        List<Remedio> remedios = new ArrayList<>();
	        
	        try {
	        	TypedQuery<Remedio> q = em.createNamedQuery("consultarRemedioPorIdU", Remedio.class);
	        	q.setParameter("idUsuario", IdUsuario);
	        	remedios = q.getResultList();     
	        } catch (Exception e) {
	            System.err.println(e);
	        } finally {
	            em.close();
	        }
	        return remedios;
	    }

	
}
