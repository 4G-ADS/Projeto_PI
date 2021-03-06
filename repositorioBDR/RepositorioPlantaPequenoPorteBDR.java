package com.fafica.projeto_pi.repositorioBDR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaPequenoPorte;

public class RepositorioPlantaPequenoPorteBDR implements
		IRepositorioPlantaPequenoPorte {

	private Connection connection = null;
	private int database = 0;

	public RepositorioPlantaPequenoPorteBDR() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}

	public RepositorioPlantaPequenoPorteBDR(int database) throws Exception {
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}

	@Override
	public void cadastrarPlantaPequenoPorte(PlantaPequenoPorte plantaPequena)
			throws SQLException {
		System.out
				.println("Chegando ao RepositorioPlantaPequenoPorte cadastrarPlantaPequenoPorte");

		PreparedStatement stmt = null;
		String sql = null;
		ResultSet resultSet1 = null;

		try {
			sql = "INSERT INTO Planta_pequeno_porte(id_reserva,especie_planta_pequeno_porte,"
					+ "nome_planta_pequeno_porte,"
					+ "tamanho_planta_pequeno_porte)values(?,?,?,?)";

			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,
						new String[] { "id_planta" });

			} else {
				stmt = this.connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);

			}

			stmt.setInt(1, plantaPequena.getReserva().getIdReserva());
			stmt.setString(2, plantaPequena.getEspecie());
			stmt.setString(3, plantaPequena.getNome());
			stmt.setDouble(4, plantaPequena.getTamanho());

			stmt.execute();

			resultSet1 = stmt.getGeneratedKeys();

		} finally {
			stmt.close();

		}

	}

	@Override
	public ArrayList<PlantaPequenoPorte> listarPlantaPequenoPorte() throws SQLException {
		System.out.println("Chegando ao RepositorioPlantaPequenoPorte listarPlantaPequenoPortre");
		
		ArrayList<PlantaPequenoPorte> listaPlanta = new ArrayList<PlantaPequenoPorte>();
		PreparedStatement stmt= null;
		String sql = "";
		ResultSet resultSet = null;
		
		try{
			
			sql = "select * from Planta_pequeno_porte";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();

			while(resultSet.next()){
			
				PlantaPequenoPorte planta = new PlantaPequenoPorte(	resultSet.getInt("id_planta_pequeno_porte"),
						resultSet.getString("nome_planta_pequeno_porte"),
						 resultSet.getString("especie_planta_pequeno_porte"),
						 resultSet.getDouble("tamanho_planta_pequeno_porte"));
				
				listaPlanta.add(planta);
			}
			
			
			
			
		}finally{
			
		}
		
		return listaPlanta;

	}

	@Override
	public ArrayList<PlantaPequenoPorte> listarPlantaPequenoPorte(int idReserva) throws SQLException {
		System.out.println("Chegando ao RepositorioPlantaPequenoPorte listarPlantaPequenoPortre");
		
		ArrayList<PlantaPequenoPorte> listaPlanta = new ArrayList<PlantaPequenoPorte>();
		PreparedStatement stmt= null;
		String sql = "";
		ResultSet resultSet = null;
		
		try{
			
			sql = "select * from Reserva ";
			sql += "inner join Planta_pequeno_porte ";
			sql += "on Reserva.id_reserva = Planta_pequeno_porte.id_reserva ";
			sql += "where Reserva.id_reserva = " + idReserva;
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();

			while(resultSet.next()){
				Reserva reserva = new Reserva(resultSet.getInt("id_adm"),resultSet.getInt("id_reserva"),resultSet.getString("clima"),
						resultSet.getString("nome_reserva"),resultSet.getDouble("tamanho_reserva"),resultSet.getDouble("latitude_reserva"),
						resultSet.getDouble("longitude_reserva"));
				
				PlantaPequenoPorte planta = new PlantaPequenoPorte(	resultSet.getInt("id_planta_pequeno_porte"),
						resultSet.getString("nome_planta_pequeno_porte"),
						 resultSet.getString("especie_planta_pequeno_porte"),
						 resultSet.getDouble("tamanho_planta_pequeno_porte"));
				planta.setReserva(reserva);
				
				listaPlanta.add(planta);
			}
			
			
			
			
		}finally{
			
		}
		
		return listaPlanta;

	}
	
	
	@Override
	public void removerPlantaPequenoPorte(int idPlantaPequena)
			throws SQLException {
		System.out
				.println("Chegando ao RepositorioPlantaPequenoPorte removerPlantaPequenoPorte");

		PreparedStatement stmt = null;
		try {
			String sql = "delete from Planta_pequeno_porte where id_Planta_Pequeno_porte = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idPlantaPequena);
			stmt.execute();
			System.out.println("foi removido");
		} finally {
			stmt.close();
		}

	
	
		
	}

}
