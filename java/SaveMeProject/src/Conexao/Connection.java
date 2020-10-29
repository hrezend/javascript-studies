package Conexao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Connection{
    
    private EntityManager instance = Persistence.createEntityManagerFactory("saveme").createEntityManager();
    
    public EntityManager getConnection() {
        return instance;
    }
}
