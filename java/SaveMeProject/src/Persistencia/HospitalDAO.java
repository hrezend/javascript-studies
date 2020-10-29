package Persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Dados.Hospital;
import Conexao.Connection;

public class HospitalDAO extends Persistencia<Hospital>{

	public HospitalDAO(){
		super(Hospital.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Hospital> ConsultarPorId(int IdUsuario) {
	        EntityManager em = new Connection().getConnection();
	        List<Hospital> hospitais = new ArrayList<>();
	        
	        try {
	        	TypedQuery<Hospital> q = em.createNamedQuery("consultarHospitalPorIdU", Hospital.class);
	        	q.setParameter("idUsuario", IdUsuario);
	        	hospitais = q.getResultList();     
	        } catch (Exception e) {
	            System.err.println(e);
	        } finally {
	            em.close();
	        }
	        return hospitais;
	    }

	
}
