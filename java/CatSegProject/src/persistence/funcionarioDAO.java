package persistence;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.funcionario;
import database.connection;

public class funcionarioDAO{	
	
    public static boolean create(funcionario f){
        PreparedStatement stm;	
		Connection con;
		String sql = "insert into funcionarios(funcionarioID, funcionarioName, funcionarioEmail, funcionarioTelefone, funcionarioCPF) values (?,?,?,?,?)";
		try{
            con = connection.getConnection();
            stm = con.prepareStatement(sql);
			stm.setString(1, f.getFuncionarioID());
			stm.setString(2, f.getFuncionarioName());
			stm.setString(3, f.getFuncionarioEmail());
			stm.setString(4, f.getFuncionarioTelefone());
			stm.setString(5, f.getFuncionarioCPF());
			stm.execute();
			stm.close();
			con.close();
            return true;											
		}
		catch(SQLException e){
            e.printStackTrace();
			return false;
        }
	}

    public static boolean update(funcionario f){
        Connection con;
        PreparedStatement stm;
		String sql = "UPDATE funcionarios set funcionarioName = ?, funcionarioTelefone = ?, funcionarioCPF = ?, funcionarioEmail = ? where funcionarioID = ?";
	    try{
            con = connection.getConnection();
            stm = con.prepareStatement(sql);
			stm.setString(1, f.getFuncionarioName());
			stm.setString(2, f.getFuncionarioTelefone());
	        stm.setString(3, f.getFuncionarioCPF());
			stm.setString(4, f.getFuncionarioEmail());
		    stm.executeUpdate();
			stm.close();
			con.close();
            return true;							
		}
	    catch(SQLException e){
	        e.printStackTrace();
			return false;
	    }
    }

    public static boolean delete(String FID){
        Connection con;
        PreparedStatement stm;
        String sql = "DELETE from funcionarios where funcionarioID = ?";
	    try{
		    con = connection.getConnection();
		    stm = con.prepareStatement(sql);
			stm.setString(1, FID);
			stm.executeUpdate();
			stm.close();
			con.close();
            return true;	
		}
	    catch(SQLException e){
	        e.printStackTrace();
			return false;
	    }	
	}
    
    public static List <funcionario> getMessages() throws SQLException {
		funcionario f = null;
		List <funcionario> funcionarios = new ArrayList<>();
		ResultSet rs;
		PreparedStatement stmt;
		
		String sql = "select * from funcionarios";
		Connection con = connection.getConnection();
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		try {
			while(rs.next()){
				f = new funcionario();
				f.setFuncionarioID(rs.getString("funcionarioID"));
				f.setFuncionarioName(rs.getString("funcionarioName"));
				f.setFuncionarioEmail(rs.getString("funcionarioEmail"));
				f.setFuncionarioTelefone(rs.getString("funcionarioTelefone"));
				f.setFuncionarioCPF(rs.getString("funcionarioCPF"));
				funcionarios.add(f);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		con.close();
		stmt.close();
		rs.close();
		
		return funcionarios;
	}

}

	
		

