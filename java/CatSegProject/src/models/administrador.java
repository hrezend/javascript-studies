package models;

import java.sql.SQLException;

import persistence.administradorDAO;

public class administrador{

    private String adminID;
    private String adminName;
    private String adminLogin;
    private String adminPassword;
    private String adminEmail;

    public void setAdminID(String receivedParams){
        this.adminID = receivedParams;
    }
    public void setAdminName(String receivedParams){
    	this.adminName = receivedParams;
    }
    public void setAdminLogin(String receivedParams){
    	this.adminLogin = receivedParams;
    }
    public void setAdminPassword(String receivedParams){
    	this.adminPassword = receivedParams;
    }
    public void setAdminEmail(String receivedParams){
    	this.adminEmail = receivedParams;
    }
    public String getAdminName(){
        return adminName;
    }
    public String getAdminID(){
        return adminID;
    }
    public String getAdminLogin(){
        return adminLogin;
    }
    public String getAdminPassword(){
        return adminPassword;
    }
    public String getAdminEmail(){
        return adminEmail;
    }


    //Métodos de DAO
    public boolean create(){
        return administradorDAO.create(this);
    }
    public boolean update(){
        return administradorDAO.update(this);
    }
    public boolean delete(String AID){
        return administradorDAO.delete(AID);
    }
    public administrador login(String login, String password) throws SQLException{
        return administradorDAO.login(login, password);
    }
}