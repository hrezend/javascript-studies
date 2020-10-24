package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.indicadores;
import database.connection;

public class indicadoresDAO{
	
	public static boolean create(indicadores ind){
        PreparedStatement stm;	
		Connection con;
		String sql = "insert into indicadores(idade, quantidadeDeAdvertencias, quantidadeDeAcidentes, cargaHorariaSemanalDeTrabalho, cargaHorariaTotalDeTreinamento, cargo, setor, funcionarioID) values (?,?,?,?,?,?,?,?)";
		try{
            con = connection.getConnection();
            stm = con.prepareStatement(sql);
			stm.setInt(1, ind.getIdade());
			stm.setInt(2, ind.getQuantidadeDeAdvertencias());
			stm.setInt(3, ind.getQuantidadeDeAcidentes());
			stm.setInt(4, ind.getCargaHorariaSemanalDeTrabalho());
			stm.setInt(5, ind.getCargaHorariaTotalDeTreinamento());
			stm.setString(6, ind.getCargo());
			stm.setString(7, ind.getSetor());
			stm.setString(8, ind.getEmployeeID());
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
	
	public static boolean update(indicadores ind){
        Connection con;
        PreparedStatement stm;
		String sql = "update indicadores set cargo = ?, setor = ?, idade = ?, quantidadeDeAdvertencias = ?, quantidadeDeAcidentes = ?, cargaHorariaSemanalDeTrabalho = ?, cargaHorariaTotalDeTreinamento = ?  where funcionarioID = ?";
	    try{
            con = connection.getConnection();
            stm = con.prepareStatement(sql);
			stm.setString(1, ind.getCargo());
			stm.setString(2, ind.getSetor());
			stm.setInt(3, ind.getIdade());
			stm.setInt(4, ind.getQuantidadeDeAdvertencias());
			stm.setInt(5, ind.getQuantidadeDeAcidentes());
			stm.setInt(6, ind.getCargaHorariaSemanalDeTrabalho());
			stm.setInt(7, ind.getCargaHorariaTotalDeTreinamento());
			stm.setString(8, ind.getEmployeeID());
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

	
	public static indicadores getIndicadores(String employeeID) throws SQLException {
		indicadores ind = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
		Connection con;
		sql = "select * from indicadores where funcionarioID = ?";
		con = connection.getConnection();
		stmt = con.prepareStatement(sql);
		stmt.setString(1, employeeID);
		rs = stmt.executeQuery();
		
		try {
			rs.next();
			ind = new indicadores();
			ind.setSetor(rs.getString("setor"));
			ind.setCargo(rs.getString("cargo"));
			ind.setEmployeeID(rs.getString("funcionarioID"));
			ind.setIdade(rs.getInt("idade"));
			ind.setCargaHorariaSemanalDeTrabalho(rs.getInt("cargaHorariaSemanalDeTrabalho"));
			ind.setCargaHorariaTotalDeTreinamento(rs.getInt("cargaHorariaTotalDeTreinamento"));
			ind.setQuantidadeDeAcidentes(rs.getInt("quantidadeDeAcidentes"));
			ind.setQuantidadeDeAdvertencias(rs.getInt("quantidadeDeAdvertencias"));
		} catch(SQLException e){
			e.printStackTrace();
			ind = null;
		}
		con.close();
		stmt.close();
		rs.close();
		return ind != null ? ind : null;	
	}

}
