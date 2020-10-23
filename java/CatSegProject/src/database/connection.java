package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection{
	private static Connection con = null;
	private static final String server = "localhost";
	private static final String base = "catseg?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String user = "root";
	private static final String pass = "root927631";
	
	public static Connection getConnection() throws SQLException{
		try{
			new com.mysql.cj.jdbc.Driver();
			con = DriverManager.getConnection("jdbc:mysql://"+ server + "/" + base, user, pass);
			System.out.println("Connected!");
			return con;
		} catch(SQLException e){
            System.out.println("Not connected!");
			e.printStackTrace();
			return null;
		}	
	}
	
	public static void fechar() {
		try{
			if(con!=null){
			    con.close();
            }
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static ResultSet receberDados(String SQL){
		ResultSet dados = null;
		try{
			Statement st = con.createStatement();
			dados = st.executeQuery(SQL);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dados;
	}
	
	public static void enviarDados(String SQL) {
		try{
			PreparedStatement stmt = con.prepareStatement(SQL);
			stmt.setInt(1,  1);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}