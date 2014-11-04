package com.fafica.projeto_pi.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioReserva;

public class RepositorioReservaCaracteristicas implements IRepositorioReserva{

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
	public void cadastrarReserva(Reserva reserva) throws SQLException {
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
			
			stmt.setString(1,reserva.getClima());
			stmt.setDouble(2, reserva.getLatitude());
			stmt.setDouble(3, reserva.getLongitude());
			stmt.setString(4, reserva.getNome());
			stmt.setDouble(5, reserva.getTamanho());
			
			stmt.execute();			
			resultSet = stmt.getGeneratedKeys();
			
			int idReserva = 0;
			while(resultSet.next()){
				idReserva  = resultSet.getInt(1);
			}
			
			reserva.setIdReserva(idReserva);
			
			System.out.println("INSERT FOI CONCLUIDO COM SUCESSO");
		} finally {
			stmt.close();
		}
		
	}

	@Override
	public Reserva procurarReserva(int idReserva) throws SQLException {
		System.out.println("Chegando ao repositorio procurarReserva");
		Reserva reserva = null;
		
		ArrayList<Reserva> listarProcura = listarReserva();
		
		for (Reserva reservaProcura : listarProcura) {
			if(idReserva == reservaProcura.getIdReserva()){
				reserva = reservaProcura;
			}
		}
		return reserva;
	}

	@Override
	public ArrayList<Reserva> listarReserva() throws SQLException {
		System.out.println("Chegando ao repositorio listarReserva");
		ArrayList<Reserva> listareservas = new ArrayList<Reserva>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from Reserva";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				Reserva reserva =  new Reserva(resultSet.getInt("id_reserva"),resultSet.getString("clima"),resultSet.getString("nome"),
						resultSet.getDouble("tamanho"),resultSet.getDouble("latitude"),resultSet.getDouble("longitude"));
				
				listareservas.add(reserva);
				
			}
			
			
		} finally{
			stmt.close();
			resultSet.close();
		}
		
		return listareservas;
		
	}


	@Override
	public void editarReserva(Reserva reserva) throws SQLException {
		System.out.println("Chegando ao repositorio atualizarReserva");
		PreparedStatement stmt = null;
		if(reserva != null){
			try{
				String sql = "update Reserva set clima = ? ,";
				sql += "Latitude = ? ,";
				sql += "Longitude = ? ,";
				sql += "nome = ? ,";
				sql += "Tamanho = ? ";
				sql += "where id_reserva = ?";
				
				stmt = this.connection.prepareStatement(sql);
				
				stmt.setString(1, reserva.getClima());
				stmt.setDouble(2, reserva.getLatitude());
				stmt.setDouble(3, reserva.getLongitude());
				stmt.setString(4, reserva.getNome());
				stmt.setDouble(5, reserva.getTamanho());
				stmt.setInt(6, reserva.getIdReserva());
				
				stmt.executeUpdate();			
				System.out.println("Edição completada");
			}finally{
				stmt.close();
			}
		}
		
	}

	@Override
	public void removerReserva(int idReserva) throws SQLException {
		System.out.println("Chegando ao repositorio removerReserva");

		PreparedStatement stmt = null;
		try {
			String sql = "delete from Reserva where idReserva = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idReserva);
			stmt.execute();
			System.out.println("foi removido");
		} finally {
			stmt.close();
		}

	
		
	}

	@Override
	public boolean existeReserva(int id) {
		System.out.println("Chegando ao repositorio existeReserva");
		return false;
	}

}
