package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.indicadores;
import database.connection;

public class indicadoresDAO{
	
	public static boolean create(indicadores ind){
        PreparedStatement stm;	
		Connection con;
		String sql = "insert into indicadores(idade, quantidadeDeAdvertencias, quantidadeDeAcidentes, cargaHorariaSemanalDeTrabalho, cargaHorariaTotalDeTreinamento, cargo, setor, employeeID) values (?,?,?,?,?,?,?,?,?,?)";
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

}
