package models;

import java.sql.SQLException;
import java.util.List;

import persistence.funcionarioDAO;

public class funcionario{
	private String funcionarioID;
	private String funcionarioCPF;
	private String funcionarioName;
	private String funcionarioEmail;
	private String funcionarioTelefone;
	
	public void setFuncionarioID(String funcionarioID) {
		this.funcionarioID = funcionarioID;
	}
	public void setFuncionarioCPF(String funcionarioCPF) {
		this.funcionarioCPF = funcionarioCPF;
	}
	public void setFuncionarioName(String funcionarioName) {
		this.funcionarioName = funcionarioName;
	}
	public void setFuncionarioEmail(String funcionarioEmail) {
		this.funcionarioEmail = funcionarioEmail;
	}
	public void setFuncionarioTelefone(String funcionarioTelefone) {
		this.funcionarioTelefone = funcionarioTelefone;
	}
	public String getFuncionarioID() {
		return funcionarioID;
	}
	public String getFuncionarioCPF() {
		return funcionarioCPF;
	}
	public String getFuncionarioName() {
		return funcionarioName;
	}
	public String getFuncionarioEmail() {
		return funcionarioEmail;
	}
	public String getFuncionarioTelefone() {
		return funcionarioTelefone;
	}
	
	
	//Métodos de DAO
	public boolean create(){
        return funcionarioDAO.create(this);
    }
    public boolean update(){
        return funcionarioDAO.update(this);
    }
    public boolean delete(String FID){
        return funcionarioDAO.delete(FID);
    }
    public static List <funcionario> getFuncionarios() throws SQLException{
    	return funcionarioDAO.getMessages();
    }
}
