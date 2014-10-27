package com.fafica.projeto_pi.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.ReservaCaracteristicas;
import com.fafica.projeto_pi.modelos.ReservaRecursos;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioReservaCaracteristicas;

public class RepositorioReservaCaracteristicas implements IRepositorioReservaCaracteristicas{

	private Connection connection = null;
	private int database = 0;
	
	
	public RepositorioReservaCaracteristicas() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}

	public RepositorioReservaCaracteristicas(int database) throws Exception {
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}
	
	@Override
	public void cadastrarReservaCaracteristicas(ReservaCaracteristicas reservaCaracteristicas) throws SQLException {
		System.out.println("Chegando ao repositorio cadastrarReserva");
		PreparedStatement stmt = null;
		String sql = "";
		ResultSet resultSet = null;
		
		try {
			sql = "INSERT INTO Reserva(clima,Latitude,Longitude,nome,tamanho)values(?,?,?,?,?)";
			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,new String[] { "id_reserva" });

			} else {
				stmt = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			}
			
			stmt.setString(1,reservaCaracteristicas.getClima());
			stmt.setDouble(2, reservaCaracteristicas.getLatitude());
			stmt.setDouble(3, reservaCaracteristicas.getLongitude());
			stmt.setString(4, reservaCaracteristicas.getNome());
			stmt.setDouble(5, reservaCaracteristicas.getTamanho());
			
			stmt.execute();			
			resultSet = stmt.getGeneratedKeys();
			System.out.println("INSERT FOI CONCLUIDO COM SUCESSO");
		} finally {
			stmt.close();
		}
		
	}

	@Override
	public ReservaRecursos procurarReservaCaracteristicas(int id) {
		System.out.println("Chegando ao repositorio procurarReserva");
		return null;
	}

	@Override
	public ArrayList<ReservaCaracteristicas> listarReservaCaracteristicas() throws SQLException {
		System.out.println("Chegando ao repositorio listarReserva");
		ArrayList<ReservaCaracteristicas> listareservas = new ArrayList<ReservaCaracteristicas>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from Reserva";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				ReservaCaracteristicas reservaCaracteristicas =  new ReservaCaracteristicas(resultSet.getInt("id_reserva"),resultSet.getString("clima"),resultSet.getString("nome"),
						resultSet.getDouble("tamanho"),resultSet.getDouble("latitude"),resultSet.getDouble("longitude"));
				
				listareservas.add(reservaCaracteristicas);
				
			}
			
			
		} finally{
			stmt.close();
			resultSet.close();
		}
		
		return listareservas;
		
	}


	@Override
	public void editarReservaCaracteristicas(ReservaCaracteristicas reservaCaracteristicas) {
		System.out.println("Chegando ao repositorio atualizarReserva");
		
	}

	@Override
	public void removerReservaCaracteristicas(int id) {
		System.out.println("Chegando ao repositorio removerReserva");
		
	}

	@Override
	public boolean existeReservaCaracteristicas(int id) {
		System.out.println("Chegando ao repositorio existeReserva");
		return false;
	}

}
