package com.fafica.projeto_pi.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaMedioPorte;

public class RepositorioPlantaMedioPorte implements IRepositorioPlantaMedioPorte{

	
	private Connection connection = null;
	private int database = 0;
	
	public RepositorioPlantaMedioPorte() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}
	
	public RepositorioPlantaMedioPorte(int database) throws Exception {
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}
	
	
	@Override
	public void cadastrarPlantaMedioPorte(PlantaMedioPorte plantaMedia) throws SQLException {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte cadastrarPlantaMedioPorte");
		
		PreparedStatement stmt1 = null;	
		String sql1 = null;
		ResultSet resultSet1 = null;
		
		PreparedStatement stmt2 = null;	
		String sql2 = null;
		ResultSet resultSet2 = null;
				
			try {
				sql1 = "INSERT INTO Plantas(especie,nome,tamanho )values(?,?,?)";
				sql2 = "INSERT INTO Planta_Medio_porte(id_planta)values(?)";
				
				if (database == Database.ORACLE) {
					stmt1 = this.connection.prepareStatement(sql1,
							new String[] { "id_planta" });
					
					stmt2 = this.connection.prepareStatement(sql2,
							new String[] { "id_planta_media_porte" });

				} else {
					stmt1 = this.connection.prepareStatement(sql1,
							Statement.RETURN_GENERATED_KEYS);
					stmt2 = this.connection.prepareStatement(sql2,
							Statement.RETURN_GENERATED_KEYS);
				}
				
				stmt1.setString(1, plantaMedia.getEspecie());
				stmt1.setString(2, plantaMedia.getNome());
				stmt1.setDouble(3, plantaMedia.getTamanho());
				
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
	public ArrayList<PlantaMedioPorte> listarPlantaMedioPorte() {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte listarPlantaMedioPorte");
		return null;
		
	}

	@Override
	public PlantaMedioPorte procurar(int id) {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte procurarPlantaMedioPorte");
		return null;
	}

	@Override
	public void removerPlantaMedioPorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte removerPlantaMedioPorte");
		
	}

	@Override
	public boolean existePlantaMedioPorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte existePlantaMedioPorte");
		return false;
	}

}
