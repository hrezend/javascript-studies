package Persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import Conexao.Connection;
import Dados.Usuario;
import Interfaces.InterfaceUsuarioDAO;

public class UsuarioDAO extends Persistencia<Usuario> implements InterfaceUsuarioDAO{
	
	public UsuarioDAO(){
		super(Usuario.class);
	}	
	
    @SuppressWarnings("unchecked")
    @Override
    public Usuario getByLogAndSen(String login, String senha) {
        EntityManager em = new Connection().getConnection();
        
        List<Usuario> usuario = new ArrayList<>();
        
        try {
            usuario = em.createNativeQuery("SELECT * FROM Usuarios WHERE LoginUsuario='"+login+"' and SenhaUsuario='"+senha+"'", Usuario.class).getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        
        
        return usuario.size() != 0 ? usuario.get(0) : null;
        
    }
    @SuppressWarnings("unchecked")
	public List<Usuario> getByLog(String login) {
        EntityManager em = new Connection().getConnection();
        List<Usuario> usuario=null;
        usuario = new ArrayList<>();
        
        try {
            usuario = em.createNativeQuery("SELECT * FROM Usuarios WHERE LoginUsuario='"+login+"'", Usuario.class).getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        
        
        return usuario;
        
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List <Usuario> getByLogSen(String login, String senha) {
        EntityManager em = new Connection().getConnection();
        List<Usuario> u = new ArrayList<>();
        
        try {
            u = em.createNativeQuery("SELECT * FROM Usuarios WHERE LoginUsuario='"+login+"' and SenhaUsuario='"+senha+"'", Usuario.class).getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        
        
        return u;
        
    }
    
	
	
}
