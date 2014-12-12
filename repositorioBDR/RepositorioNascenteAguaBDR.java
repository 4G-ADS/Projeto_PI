package com.fafica.projeto_pi.repositorioBDR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioNascenteAgua;


public class RepositorioNascenteAguaBDR implements IRepositorioNascenteAgua{
	
	private Connection connection = null;
	private int database = 0;
	
	public RepositorioNascenteAguaBDR() throws Exception {
	
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
		
	}
	
	public RepositorioNascenteAguaBDR(int database) throws Exception{
		
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}
	
	
	@Override
	public void cadastrarAgua(NascenteAgua nascenteAgua) throws SQLException {
		System.out.println("Chegando ao repositorio cadastrarAgua");
		PreparedStatement stmt = null;
		String sql = "";
		ResultSet resultset = null;
		
		try {
			sql = "INSERT INTO nascente_agua(id_reserva,Latitude_nascente_agua,Longitude_nascente_agua"
					+ ",Nome_nascente_agua,Tipo_nascente_agua)values(?, ?,?,?,?)";
			
			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,new String[] { "id_agua" });

			} else {
				stmt = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			}
			
			stmt.setInt(1, nascenteAgua.getReserva().getIdReserva());
			stmt.setDouble(2, nascenteAgua.getLatitude());
			stmt.setDouble(3, nascenteAgua.getLongitude());
			stmt.setString(4, nascenteAgua.getNomeFonte());
			stmt.setString(5, nascenteAgua.getTipo());
			
			stmt.execute();
			
			resultset = stmt.getGeneratedKeys();
			System.out.println("INSERT FOI CONCLUIDO COM SUCESSO");
		} finally {
			
			stmt.close();
		}
		
		
	}

	
	@Override
	public NascenteAgua procurarAgua(int idAgua) throws SQLException {
		System.out.println("Chegando ao repositorio ProcurarAgua");
		NascenteAgua aguaProcura = null;
		
		ArrayList<NascenteAgua> listarProcura = listarNascenteAgua();
		
		for (NascenteAgua agua : listarProcura) {
			if(idAgua == agua.getIdAgua()){
				aguaProcura = agua;
			}
		}
		return aguaProcura;
	}

	@Override
	public ArrayList<NascenteAgua> listarNascenteAgua() throws SQLException {
		System.out.println("Chegando ao repositorio listarAgua");
		ArrayList<NascenteAgua> listaNascenteAgua = new ArrayList<NascenteAgua>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from nascente_agua";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				NascenteAgua agua =  new NascenteAgua(resultSet.getInt("id_agua"), 
						resultSet.getDouble("Latitude_nascente_agua"),resultSet.getDouble("Longitude_nascente_agua"), 
						resultSet.getString("Nome_nascente_agua"), resultSet.getString("Tipo_nascente_agua"));

				listaNascenteAgua.add(agua);
				
			}
			
			
		} finally{
			stmt.close();
			resultSet.close();
		}
		
		return listaNascenteAgua;
		
	}

	
	
	@Override
	public ArrayList<NascenteAgua> listarNascenteAgua(int idReserva) throws SQLException {
		System.out.println("Chegando ao repositorio listarAgua");
		
		ArrayList<NascenteAgua> listaNascenteAgua = new ArrayList<NascenteAgua>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from Reserva ";
			sql += "inner join nascente_agua ";
			sql += "on Reserva.id_reserva = nascente_agua.id_reserva ";
			sql += "where Reserva.id_reserva = " + idReserva;
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				Reserva reserva = new Reserva(resultSet.getInt("id_adm"),resultSet.getInt("id_reserva"),resultSet.getString("clima"),
						resultSet.getString("nome_reserva"),resultSet.getDouble("tamanho_reserva"),resultSet.getDouble("latitude_reserva"),
						resultSet.getDouble("longitude_reserva"));
				
				NascenteAgua agua =  new NascenteAgua(resultSet.getInt("id_agua"),
						resultSet.getDouble("Latitude_nascente_agua"),
						resultSet.getDouble("Longitude_nascente_agua"), 
						resultSet.getString("Nome_nascente_agua"), 
						resultSet.getString("Tipo_nascente_agua"));
				agua.setReserva(reserva);
				listaNascenteAgua.add(agua);
				
			}
			
			
		} finally{
			stmt.close();
			resultSet.close();
		}
		
		return listaNascenteAgua;
		
	
	}
	
	
	@Override
	public void removerAgua(int idAgua) throws SQLException {
		System.out.println("Chegando ao repositorio removerAgua");
		PreparedStatement stmt = null;
		try {
			String sql = "delete from nascente_agua where id_agua = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idAgua);
			stmt.execute();
			System.out.println("foi removido");
		} finally {
			stmt.close();
		}

	
		
	}

	@Override
	public void editarAgua(NascenteAgua agua) throws SQLException {
		System.out.println("Chegando ao repositorio editarAgua");
		PreparedStatement stmt = null;
		if(agua != null){
			try{
				String sql = "update nascente_agua set Latitude_nascente_agua = ? ,";
				sql += "Longitude_nascente_agua = ? ,";
				sql += "Nome_nascente_agua = ? ,";
				sql += "Tipo_nascente_agua = ? ";
				sql += "where id_agua = ?";
				stmt = this.connection.prepareStatement(sql);
				
				stmt.setDouble(1, agua.getLatitude());
				stmt.setDouble(2, agua.getLongitude());
				stmt.setString(3, agua.getNomeFonte());
				stmt.setString(4, agua.getTipo());
				stmt.setInt(5, agua.getIdAgua());
				
				stmt.executeUpdate();			
				System.out.println("Edição completada");
			}finally{
				stmt.close();
			}
		}	
	}


}
