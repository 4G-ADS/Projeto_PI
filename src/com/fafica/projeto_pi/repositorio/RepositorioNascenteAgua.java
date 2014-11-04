package com.fafica.projeto_pi.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.lang.model.element.NestingKind;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioNascenteAgua;


public class RepositorioNascenteAgua implements IRepositorioNascenteAgua{
	
	private Connection connection = null;
	private int database = 0;
	
	public RepositorioNascenteAgua() throws Exception {
	
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
		
	}
	
	public RepositorioNascenteAgua(int database) throws Exception{
		
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
			sql = "INSERT INTO nascente_agua(id_reserva,Latitude,Longitude,Nome_Fonte,Tipo)values(?, ?,?,?,?)";
			
			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,new String[] { "id_Agua" });

			} else {
				stmt = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			}
			
			stmt.setInt(1, nascenteAgua.getIdReserva());
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
				NascenteAgua agua =  new NascenteAgua(resultSet.getInt("id_agua"), resultSet.getDouble("Latitude"),
						resultSet.getDouble("Longitude"), resultSet.getString("Nome_fonte"), resultSet.getString("Tipo"));
				
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
			sql = "select nascente_agua.Nome_Fonte,nascente_agua.id_agua,nascente_agua.Latitude,nascente_agua.Longitude,";
			sql += "nascente_agua.Tipo ";
			sql += "from Reserva ";
			sql += "inner join nascente_agua ";
			sql += "on Reserva.id_reserva = nascente_agua.id_reserva ";
			sql += "where Reserva.id_reserva = " + idReserva;
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				NascenteAgua agua =  new NascenteAgua(resultSet.getInt("id_agua"), resultSet.getDouble("Latitude"),
						resultSet.getDouble("Longitude"), resultSet.getString("Nome_fonte"), resultSet.getString("Tipo"));
				
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
				String sql = "update nascente_agua set Latitude = ? ,";
				sql += "Longitude = ? ,";
				sql += "Nome_Fonte = ? ,";
				sql += "Tipo = ? ";
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

	@Override
	public boolean existeAgua(int idAgua) {
		System.out.println("Chegando ao repositorio existeAgua");
		return false;
	}



}
