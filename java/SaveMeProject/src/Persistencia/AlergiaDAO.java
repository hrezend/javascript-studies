package Persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Dados.Alergia;
import Conexao.Connection;

public class AlergiaDAO extends Persistencia<Alergia>{

	public AlergiaDAO(){
		super(Alergia.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Alergia> ConsultarPorId(int IdUsuario) {
	        EntityManager em = new Connection().getConnection();
	        List<Alergia> alergias = new ArrayList<>();
	        
	        try {
	        	TypedQuery<Alergia> q = em.createNamedQuery("consultarAlergiaPorIdU", Alergia.class);
	        	q.setParameter("idUsuario", IdUsuario);
	            alergias = q.getResultList();     
	        } catch (Exception e) {
	            System.err.println(e);
	        } finally {
	            em.close();
	        }
	        return alergias;
	    }
	

	
}
