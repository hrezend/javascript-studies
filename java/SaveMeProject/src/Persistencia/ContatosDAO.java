package Persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Dados.Contatos;
import Conexao.Connection;

public class ContatosDAO extends Persistencia<Contatos>{

	public ContatosDAO(){
		super(Contatos.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Contatos> ConsultarPorId(int IdUsuario) {
	        EntityManager em = new Connection().getConnection();
	        List<Contatos> contatos = new ArrayList<>();
	        
	        try {
	        	TypedQuery<Contatos> q = em.createNamedQuery("consultarContatoPorIdU", Contatos.class);
	        	q.setParameter("idUsuario", IdUsuario);
	            contatos = q.getResultList(); 
	        } catch (Exception e) {
	            System.err.println(e);
	        } finally {
	            em.close();
	        }
	        return contatos;
	    }
	
	
	
	
}
