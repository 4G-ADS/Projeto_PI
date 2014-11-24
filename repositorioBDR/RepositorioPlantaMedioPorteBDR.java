package com.fafica.projeto_pi.repositorioBDR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaMedioPorte;

public class RepositorioPlantaMedioPorteBDR implements IRepositorioPlantaMedioPorte{

	
	private Connection connection = null;
	private int database = 0;
	
	public RepositorioPlantaMedioPorteBDR() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}
	
	public RepositorioPlantaMedioPorteBDR(int database) throws Exception {
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}
	
	
	@Override
	public void cadastrarPlantaMedioPorte(PlantaMedioPorte plantaMedia) throws SQLException {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte cadastrarPlantaMedioPorte");
		
		PreparedStatement stmt = null;	
		String sql = null;
		ResultSet resultSet = null;
		
				
			try {
				sql = "INSERT INTO Planta_medio_porte(id_reserva,especie_planta_medio_porte"
						+ ",nome_planta_medio_porte,tamanho_planta_medio_porte)values(?,?,?,?)";

				
				if (database == Database.ORACLE) {
					stmt = this.connection.prepareStatement(sql,
							new String[] { "id_planta_Medio_porte" });
					


				} else {
					stmt = this.connection.prepareStatement(sql,
							Statement.RETURN_GENERATED_KEYS);
					

				}
				
				stmt.setInt(1, plantaMedia.getIdReserva());
				stmt.setString(2, plantaMedia.getEspecie());
				stmt.setString(3, plantaMedia.getNome());
				stmt.setDouble(4, plantaMedia.getTamanho());
				
				stmt.execute();
				
				resultSet = stmt.getGeneratedKeys();
			

				
			} finally {
				stmt.close();
	
			}

		
		
	}

	@Override
	public ArrayList<PlantaMedioPorte> listarPlantaMedioPorte() throws SQLException {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte listarPlantaMedioPorte");
		ArrayList<PlantaMedioPorte> listaPlanta = new ArrayList<PlantaMedioPorte>();
		
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from Planta_medio_porte ";
			
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
			
				PlantaMedioPorte  plantaMedia = new PlantaMedioPorte(resultSet.getInt("id_planta_medio_porte"),
						resultSet.getString("especie_planta_medio_porte"),
						resultSet.getString("nome_planta_medio_porte"),
						resultSet.getDouble("tamanho_planta_medio_porte"));
				listaPlanta.add(plantaMedia);
				
			}
			
		}finally{
		
			stmt.close();
			resultSet.close();
		}		
		return listaPlanta;
		
	}

	@Override
	public ArrayList<PlantaMedioPorte> listarPlantaMedioPorte(int idReserva) throws SQLException {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte listarPlantaMedioPorte");
		ArrayList<PlantaMedioPorte> listaPlanta = new ArrayList<PlantaMedioPorte>();
		
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select Planta_medio_porte.id_planta_medio_porte,"
					+ "Planta_medio_porte.nome_planta_medio_porte,"
					+ "Planta_medio_porte.especie_planta_medio_porte, ";
			sql += "Planta_medio_porte.tamanho_planta_medio_porte ";
			sql += "from Reserva ";
			sql += "inner join Planta_medio_porte ";
			sql += "on Reserva.id_reserva = Planta_medio_porte.id_reserva ";
			sql += "where Reserva.id_reserva = " + idReserva;
			
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
			
				PlantaMedioPorte  plantaMedia = new PlantaMedioPorte(resultSet.getInt("id_planta_medio_porte"),
						resultSet.getString("especie_planta_medio_porte"),
						resultSet.getString("nome_planta_medio_porte"),
						resultSet.getDouble("tamanho_planta_medio_porte"));
				listaPlanta.add(plantaMedia);
				
			}
			
		}finally{
		
			stmt.close();
			resultSet.close();
		}		
		return listaPlanta;
		
	}

	@Override
	public void removerPlantaMedioPorte(int idPlantaMedia) throws SQLException {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte removerPlantaMedioPorte");

		PreparedStatement stmt = null;
		try {
			String sql = "delete from Planta_medio_porte where id_planta_medio_porte = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idPlantaMedia);
			stmt.execute();
			System.out.println("foi removido");
		} finally {
			stmt.close();
		}

	
		
	
	}

}
