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
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioSolo;

public class RepositorioSolo implements IRepositorioSolo{

	private Connection connection = null;
	private int database = 0;
	
	public RepositorioSolo() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}

	public RepositorioSolo(int database) throws Exception {
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}
	
	@Override
	public void cadastrarSolo(Solo solo) throws SQLException {
		System.out.println("Chegando ao repositorio cadastrarSolo");
		PreparedStatement stmt = null;
		String sql= "";
		ResultSet resultSet = null;
		
		try {
			sql = "INSERT INTO Solo(tamanho,tipo,recursos)values(?,?,?)";
			
			
			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,new String[] { "id_solo" });

			} else {
				stmt = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			}
			
			stmt.setDouble(1, solo.getTamanho());
			stmt.setString(2, solo.getTipo());
			stmt.setString(3, solo.getResursos());
			
			stmt.execute();
			
			resultSet = stmt.getGeneratedKeys();
			System.out.println("INSERT FOI CONCLUIDO COM SUCESSO");
		} finally{
			stmt.close();
		}
		
		
	}

	@Override
	public Solo procurarSolo(int idSolo) {
		System.out.println("Chegando ao repositorio procurarSolo");
		return null;
	}

	@Override
	public ArrayList<Solo> listarSolo() throws SQLException {
		System.out.println("Chegando ao repositorio listarSolos");
		ArrayList<Solo> listaSolo = new ArrayList<Solo>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from Solo";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				Solo solo =  new Solo(resultSet.getInt("id_solo"), resultSet.getString("nome"),
						resultSet.getDouble("tamanho"),resultSet.getString("tipo"));
				
				listaSolo.add(solo);
				
			}
			
			
		} finally{
			stmt.close();
			resultSet.close();
		}
		
		return listaSolo;
		
	}

	@Override
	public void editarSolo(Solo Solo) {
		System.out.println("Chegando ao repositorio editarsolo");
		
	}

	@Override
	public void removerSolo(int idSolo) {
		System.out.println("Chegando ao repositorio removerSolo");
		
	}

	@Override
	public boolean existeSolo(int idSolo) {
		System.out.println("Chegando ao repositorio existeSolo");
		return false;
	}

}
