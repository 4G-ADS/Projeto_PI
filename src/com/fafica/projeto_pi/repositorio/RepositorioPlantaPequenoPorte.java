package com.fafica.projeto_pi.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaPequenoPorte;

public class RepositorioPlantaPequenoPorte implements IRepositorioPlantaPequenoPorte{
	
	private Connection connection = null;
	private int database = 0;
	
	public RepositorioPlantaPequenoPorte() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}
	
	public RepositorioPlantaPequenoPorte(int database) throws Exception {
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}

	@Override
	public void cadastrarPlantaPequenoPorte(PlantaPequenoPorte plantaPequena) throws SQLException {
		System.out.println("Chegando ao RepositorioPlantaPequenoPorte cadastrarPlantaPequenoPorte");
		
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
							new String[] { "id_planta_pequena_porte" });

				} else {
					stmt1 = this.connection.prepareStatement(sql1,
							Statement.RETURN_GENERATED_KEYS);
					stmt2 = this.connection.prepareStatement(sql2,
							Statement.RETURN_GENERATED_KEYS);
				}
				
				stmt1.setString(1, plantaPequena.getEspecie());
				stmt1.setString(2, plantaPequena.getNome());
				stmt1.setDouble(3, plantaPequena.getTamanho());
				
				stmt1.execute();
				
				resultSet1 = stmt1.getGeneratedKeys();
				
				int id = 0;
				while(resultSet1.next()){
				System.out.println("1");
					
				}
				

				
//				if(id != 0){
//				stmt2.setInt(1, id);
//				}
//				
//				stmt2.execute();			
//				resultSet2 = stmt2.getGeneratedKeys();
				
			} finally {
				stmt1.close();
				stmt2.close();
			}

		
		
	
		
	}

	@Override
	public PlantaPequenoPorte procurarPlantaPequenoPorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaPequenoPorte procurarPlantaPequenoPorte");
		return null;
	}

	@Override
	public ArrayList<PlantaPequenoPorte> listarPlantaPequenoPorte() {
		System.out.println("Chegando ao RepositorioPlantaPequenoPorte listarPlantaPequenoPortre");
		return null;
		
	}

	@Override
	public void removerPlantaPequenoPorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaPequenoPorte removerPlantaPequenoPorte");
		
	}

	@Override
	public boolean existePlantaPequenoPorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaPequenoPorte existePlantaPequenoPorte");
		return false;
	}

}
