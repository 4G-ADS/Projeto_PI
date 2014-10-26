package com.fafica.projeto_pi.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
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
	
	PreparedStatement stmt1 = null;	
	String sql1 = null;
	ResultSet resultSet1 = null;
	
	PreparedStatement stmt2 = null;	
	String sql2 = null;
	ResultSet resultSet2 = null;
			
		try {
			sql1 = "INSERT INTO Plantas(especie,nome,tamanho )values(?,?,?)";
			sql2 = "INSERT INTO Planta_grande_porte(id_planta)values(?)";
			
			if (database == Database.ORACLE) {
				stmt1 = this.connection.prepareStatement(sql1,
						new String[] { "id_planta" });
				
				stmt2 = this.connection.prepareStatement(sql2,
						new String[] { "id_planta_grande_porte" });

			} else {
				stmt1 = this.connection.prepareStatement(sql1,
						Statement.RETURN_GENERATED_KEYS);
				stmt2 = this.connection.prepareStatement(sql2,
						Statement.RETURN_GENERATED_KEYS);
			}
			
			stmt1.setString(1, plantagrande.getEspecie());
			stmt1.setString(2, plantagrande.getNome());
			stmt1.setDouble(3, plantagrande.getTamanho());
			
			stmt1.execute();
			
			resultSet1 = stmt1.getGeneratedKeys();
			
			int id = 0;
			while(resultSet1.next()){
				int idTeste = resultSet1.getInt("id_planta");
				if(idTeste != 0){
					id = idTeste;
				}
			}
			

			
			if(id != 0){
			stmt2.setInt(1, id);
			}
			
			stmt2.execute();			
			resultSet2 = stmt2.getGeneratedKeys();
			
		} finally {
			stmt1.close();
			stmt2.close();
		}

	}

	@Override
	public PlantaGrandePorte procurarPlantaGrandePorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaGrandePorte procurarPLantaGrandePorte");
		return null;
	}

	@Override
	public ArrayList<PlantaGrandePorte> listarPlantaGrandePorte() {
		System.out.println("Chegando ao RepositorioPlantaGrandePorte listarPLantaGrandePorte");
		return null;
		
	}

	@Override
	public void removerPlantaGrandePorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaGrandePorte removerPlantaGrandePorte");
		
	}

	@Override
	public boolean existePlantaGrandePorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaGrandePorte existePlantaGrandePorte");
		return false;
	}

}
