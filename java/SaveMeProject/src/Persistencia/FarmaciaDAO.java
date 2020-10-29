package Persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Dados.Farmacia;
import Conexao.Connection;

public class FarmaciaDAO extends Persistencia<Farmacia>{

	public FarmaciaDAO(){
		super(Farmacia.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Farmacia> ConsultarPorId(int IdUsuario) {
	        EntityManager em = new Connection().getConnection();
	        List<Farmacia> farmacias = new ArrayList<>();
	        
	        try {
	        	TypedQuery<Farmacia> q = em.createNamedQuery("consultarFarmaciaPorIdU", Farmacia.class);
	        	q.setParameter("idUsuario", IdUsuario);
	        	farmacias = q.getResultList();     
	        } catch (Exception e) {
	            System.err.println(e);
	        } finally {
	            em.close();
	        }
	        return farmacias;
	    }

	
}
