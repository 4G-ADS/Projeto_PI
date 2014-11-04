package com.fafica.projeto_pi.repositorio;

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
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaGrandePorte;

public class RepositorioPlantaGrandePorte implements IRepositorioPlantaGrandePorte{

	private Connection connection = null;
	private int database = 0;
	
	public RepositorioPlantaGrandePorte() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}
	
	public RepositorioPlantaGrandePorte(int database) throws Exception {
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
			sql = "INSERT INTO Planta_grande_porte(id_reserva,especie,nome,tamanho)values(?,?,?,?)";
			
			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,
						new String[] { "id_planta_pequeno_porte" });

			} else {
				stmt = this.connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
			}			
			
			stmt.setInt(1, plantagrande.getIdReserva());
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
	public PlantaGrandePorte procurarPlantaGrandePorte(int idPlantaGrande) throws SQLException {
		System.out.println("Chegando ao RepositorioPlantaGrandePorte procurarPLantaGrandePorte");

		PlantaGrandePorte plantaGrandeProcura = null;
		
		ArrayList<PlantaGrandePorte> listarProcura = listarPlantaGrandePorte();
		
		for (PlantaGrandePorte plantaGrande : listarProcura) {
			if(idPlantaGrande == plantaGrande.getIdPantaGrandePorte()){
				plantaGrandeProcura = plantaGrande;
			}
		}
		return plantaGrandeProcura;
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
			
				PlantaGrandePorte  plantaGrande = new PlantaGrandePorte(resultSet.getString("especie"), resultSet.getString("nome"),
						resultSet.getDouble("tamanho"),resultSet.getInt("id_planta_grande_porte"));
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
			sql = "select Planta_grande_porte.id_planta_grande_porte,Planta_grande_porte.nome,Planta_grande_porte.especie,";
			sql += "Planta_grande_porte.tamanho ";
			sql += "from Reserva ";
			sql += "inner join Planta_grande_porte ";
			sql += "on Reserva.id_reserva = Planta_grande_porte.id_reserva ";
			sql += "where Reserva.id_reserva = " + idReserva;
			
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
			
				PlantaGrandePorte  plantaGrande = new PlantaGrandePorte(resultSet.getString("especie"), resultSet.getString("nome"),
						resultSet.getDouble("tamanho"),resultSet.getInt("id_planta_grande_porte"));
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

	@Override
	public boolean existePlantaGrandePorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaGrandePorte existePlantaGrandePorte");
		return false;
	}

}
