package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.administrador;
import database.connection;

public class administradorDAO{	
	
    public static boolean create(administrador adm){
        PreparedStatement stm;	
		Connection con;
		String sql = "insert into administradores(adminID, adminName, adminLogin, adminPassword, adminEmail) values (?,?,?,?,?)";
		try{
            con = connection.getConnection();
            stm = con.prepareStatement(sql);
			stm.setString(1, adm.getAdminID());
			stm.setString(2, adm.getAdminName());
			stm.setString(3, adm.getAdminLogin());
			stm.setString(4, adm.getAdminPassword());
			stm.setString(5, adm.getAdminEmail());
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

    public static boolean update(administrador adm){
        Connection con;
        PreparedStatement stm;
		String sql = "UPDATE administradores set adminName = ?, adminLogin = ?, adminPassword = ?, adminEmail = ? where adminID = ?";
	    try{
            con = connection.getConnection();
            stm = con.prepareStatement(sql);
			stm.setString(1, adm.getAdminName());
			stm.setString(2, adm.getAdminLogin());
	        stm.setString(3, adm.getAdminPassword());
			stm.setString(4, adm.getAdminEmail());
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

    public static boolean delete(String AID){
        Connection con;
        PreparedStatement stm;
        String sql = "DELETE from administradores where adminID = ?";
	    try{
		    con = connection.getConnection();
		    stm = con.prepareStatement(sql);
			stm.setString(1, AID);
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

	public static administrador login(String login, String password) throws SQLException{
		administrador a = null;
		ResultSet rs;
		PreparedStatement stmt;
		Connection con;
		String sql = "select * from administradores where adminLogin = ? and adminPassword = ?";
		con = connection.getConnection();
		stmt = con.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, password);
		rs = stmt.executeQuery();
		try{
			rs.next();
			a = new administrador();
			a.setAdminID(rs.getString("adminID"));
			a.setAdminName(rs.getString("adminName"));
			a.setAdminEmail(rs.getString("adminEmail"));
		} catch(SQLException e) {
			e.printStackTrace();
			a = null;
		}
		con.close();
		stmt.close();
		rs.close();
		return a != null ? a : null;	
	}

}

	
		

