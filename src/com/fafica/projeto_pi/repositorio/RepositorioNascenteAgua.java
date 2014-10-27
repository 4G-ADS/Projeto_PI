package com.fafica.projeto_pi.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.lang.model.element.NestingKind;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioNascenteAgua;


public class RepositorioNascenteAgua implements IRepositorioNascenteAgua{
	
	private Connection connection = null;
	private int database = 0;
	
	public RepositorioNascenteAgua() throws Exception {
	
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
		
	}
	
	public RepositorioNascenteAgua(int database) throws Exception{
		
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}
	
	
	@Override
	public void cadastrarAgua(NascenteAgua nascenteAgua) throws SQLException {
		System.out.println("Chegando ao repositorio cadastrarAgua");
		PreparedStatement stmt = null;
		String sql = "";
		ResultSet resultset = null;
		
		try {
			sql = "INSERT INTO Nascente_Agua(Latitude,Longitude,Nome_Fonte,Tipo)values(?,?,?,?)";
			
			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,new String[] { "id_Agua" });

			} else {
				stmt = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			}
			
			stmt.setDouble(1, nascenteAgua.getLatitude());
			stmt.setDouble(2, nascenteAgua.getLongitude());
			stmt.setString(3, nascenteAgua.getNomeFonte());
			stmt.setString(4, nascenteAgua.getTipo());
			
			stmt.execute();
			
			resultset = stmt.getGeneratedKeys();
			System.out.println("INSERT FOI CONCLUIDO COM SUCESSO");
		} finally {
			
			stmt.close();
		}
		
		
	}

	@Override
	public NascenteAgua procurarAgua(int idAgua) {
		System.out.println("Chegando ao repositorio ProcurarAgua");
		
		return null;
	}

	@Override
	public ArrayList<NascenteAgua> listarNascenteAgua() throws SQLException {
		System.out.println("Chegando ao repositorio listarAgua");
		ArrayList<NascenteAgua> listaNascenteAgua = new ArrayList<NascenteAgua>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from Nascente_Agua";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				NascenteAgua agua =  new NascenteAgua(resultSet.getInt("id_agua"), resultSet.getDouble("Latitude"),
						resultSet.getDouble("Longitude"), resultSet.getString("Nome_fonte"), resultSet.getString("Tipo"));
				
				listaNascenteAgua.add(agua);
				
			}
			
			
		} finally{
			stmt.close();
			resultSet.close();
		}
		
		return listaNascenteAgua;
		
	}

	@Override
	public void removerAgua(int idAgua) {
		System.out.println("Chegando ao repositorio removerAgua");
		
	}

	@Override
	public void editarAgua(NascenteAgua agua) {
		System.out.println("Chegando ao repositorio editarAgua");
		
	}

	@Override
	public boolean existeAgua(int idAgua) {
		System.out.println("Chegando ao repositorio existeAgua");
		return false;
	}

}
