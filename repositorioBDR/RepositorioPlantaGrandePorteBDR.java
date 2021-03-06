package com.fafica.projeto_pi.repositorioBDR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.text.MaskFormatter;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaGrandePorte;

public class RepositorioPlantaGrandePorteBDR implements IRepositorioPlantaGrandePorte{

	private Connection connection = null;
	private int database = 0;
	
	public RepositorioPlantaGrandePorteBDR() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}
	
	public RepositorioPlantaGrandePorteBDR(int database) throws Exception {
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}
	
	
	@Override
	public void cadastrarPlantaGrandePorte(PlantaGrandePorte plantagrande) throws SQLException {
	System.out.println("Chegando ao RepositorioPlantaGrandePorte cadastrarPlantaGrandePorte");
	
	PreparedStatement stmt = null;	
	String sql = null;
	ResultSet resultSet1 = null;


		try {
			sql = "INSERT INTO Planta_grande_porte(id_reserva,especie_planta_grande_porte"
					+ ",nome_planta_grande_porte,tamanho_planta_grande_porte)values(?,?,?,?)";
			
			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,
						new String[] { "id_planta_pequeno_porte" });

			} else {
				stmt = this.connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
			}			
			
			stmt.setInt(1, plantagrande.getReserva().getIdReserva());
			stmt.setString(2, plantagrande.getEspecie());
			stmt.setString(3, plantagrande.getNome());
			stmt.setDouble(4, plantagrande.getTamanho());
			
			stmt.execute();
						
			resultSet1 = stmt.getGeneratedKeys();			
			
		} finally {
			stmt.close();
		}

	}

	@Override
	public ArrayList<PlantaGrandePorte> listarPlantaGrandePorte() throws SQLException {
		System.out.println("Chegando ao RepositorioPlantaGrandePorte listarPLantaGrandePorte");

		ArrayList<PlantaGrandePorte> listaPlanta = new ArrayList<PlantaGrandePorte>();
		
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from Planta_grande_porte ";
			
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
			
				PlantaGrandePorte  plantaGrande = new PlantaGrandePorte(resultSet.getInt("id_planta_grande_porte"),
						resultSet.getString("especie_planta_grande_porte"), 
						resultSet.getString("nome_planta_grande_porte"),
						resultSet.getDouble("tamanho_planta_grande_porte"));

				listaPlanta.add(plantaGrande);
				
			}
			
		}finally{
		
			stmt.close();
			resultSet.close();
		}		
		return listaPlanta;
		
	
		
	}
	
	@Override
	public ArrayList<PlantaGrandePorte> listarPlantaGrandePorte(int idReserva) throws SQLException {
		

		System.out.println("Chegando ao RepositorioPlantaGrandePorte listarPLantaGrandePorte");

		ArrayList<PlantaGrandePorte> listaPlanta = new ArrayList<PlantaGrandePorte>();
		
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from Reserva ";
			sql += "inner join Planta_grande_porte ";
			sql += "on Reserva.id_reserva = Planta_grande_porte.id_reserva ";
			sql += "where Reserva.id_reserva = " + idReserva;
			
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				Reserva reserva = new Reserva(resultSet.getInt("id_adm"),resultSet.getInt("id_reserva"),resultSet.getString("clima"),
						resultSet.getString("nome_reserva"),resultSet.getDouble("tamanho_reserva"),resultSet.getDouble("latitude_reserva"),
						resultSet.getDouble("longitude_reserva"));
				
				PlantaGrandePorte  plantaGrande = new PlantaGrandePorte(resultSet.getInt("id_planta_grande_porte"),
						resultSet.getString("especie_planta_grande_porte"), 
						resultSet.getString("nome_planta_grande_porte"),
						resultSet.getDouble("tamanho_planta_grande_porte"));
				plantaGrande.setReserva(reserva);
				listaPlanta.add(plantaGrande);
				
				listaPlanta.add(plantaGrande);
				
			}
			
		}finally{
		
			stmt.close();
			resultSet.close();
		}		
		return listaPlanta;
		
	
		
	
		
		
	}
	@Override
	public void removerPlantaGrandePorte(int idPlantaGrande) throws SQLException {
		System.out.println("Chegando ao RepositorioPlantaGrandePorte removerPlantaGrandePorte");	

		PreparedStatement stmt = null;
		try {
			String sql = "delete from Planta_grande_porte where id_planta_grande_porte = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idPlantaGrande);
			stmt.execute();
			System.out.println("foi removido");
		} finally {
			stmt.close();
		}

	
		
	}

	
		
	}


