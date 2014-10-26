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
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioReserva;

public class RepositorioReserva implements IRepositorioReserva{

	private Connection connection = null;
	private int database = 0;
	
	
	public RepositorioReserva() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}

	public RepositorioReserva(int database) throws Exception {
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
				stmt = this.connection.prepareStatement(sql,new String[] { "CLIENTE_ID" });

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
			System.out.println("INSERT FOI CONCLUIDO COM SUCESSO");
		} finally {
			stmt.close();
		}
		
	}

	@Override
	public Reserva procurarReserva(int id) {
		System.out.println("Chegando ao repositorio procurarReserva");
		return null;
	}

	@Override
	public ArrayList<Reserva> listarReserva() throws SQLException {
		System.out.println("Chegando ao repositorio listarReserva");
		ArrayList<Reserva> listareservas = new ArrayList<Reserva>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from NascenteAgua";
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
	public void editarReserva(Reserva reserva) {
		System.out.println("Chegando ao repositorio atualizarReserva");
		
	}

	@Override
	public void removerReserva(int id) {
		System.out.println("Chegando ao repositorio removerReserva");
		
	}

	@Override
	public boolean existeReserva(int id) {
		System.out.println("Chegando ao repositorio existeReserva");
		return false;
	}

}
