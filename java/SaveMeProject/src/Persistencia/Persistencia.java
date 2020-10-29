package Persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import Conexao.Connection;

public abstract class Persistencia<T> {

    private Class<T> persistedClass;
    
    protected Persistencia(){}
    
    protected Persistencia(Class<T> persistedClass) {
        this();
        this.persistedClass = persistedClass;
    }
    
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        EntityManager em = new Connection().getConnection();
        
        List<T> list = new ArrayList<>();
        
        try {
            list = em.createQuery("from "+persistedClass.getSimpleName()+" l").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        
        return list;
        
    }
    
    public T getById(int id) {
        EntityManager em = new Connection().getConnection();
        
        T entity = null;
        
        try {
            entity = em.find(this.persistedClass, id); 
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();  
        }
        
        return entity;
        
    }
    
    public void add(T entity) {
        EntityManager em = new Connection().getConnection();
        
        try {
            em.getTransaction().begin();
            em.persist(entity);          
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public void update(T entity) {
        EntityManager em = new Connection().getConnection();
        
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
                
    }
    
    public void delete(int id) {
        EntityManager em = new Connection().getConnection();
        
        T entity = em.find(this.persistedClass, id);
        
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
    }
    
}
