package com.fafica.projeto_pi.repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioInstituicao;


public class RepositorioIntituicao implements IRepositorioInstituicao{

	//variaveis para conexao
	private Connection connection = null;
	private int database = 0;
		
	//Os construtores vão dizer qual banco usar
	public RepositorioIntituicao() throws Exception {
	this.connection = Conexao.getConnection(Database.MYSQL);
	this.database = Database.MYSQL;
	}
	
	public RepositorioIntituicao(int database) throws Exception{
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}
	
	
	//Metodos do crud
	@Override
	public void cadastrarInstituicao(Instituicao instituicao) throws SQLException {
		System.out.println("Chegando ao repositorio cadastrarIntituicao");
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try {
			
			sql = "INSERT INTO Instituicao(nome,cnpj,tipo) VALUES (?, ?, ?)";
			if(database == Database.ORACLE){
				stmt = this.connection.prepareStatement(sql,new String[] { "id_instituicao" });
			}else{
				stmt = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			}
			
			stmt.setString(1,instituicao.getNome());
			stmt.setString(2,instituicao.getCnpj());
			stmt.setString(3,instituicao.getTipo());
			
			stmt.execute();
			
			resultSet = stmt.getGeneratedKeys();
			System.out.println("INSERT CONCLUIDO COM SUCESSO");
		} finally {
			stmt.close();
		}		
		
	}

	@Override
	public ArrayList<Instituicao> listarInstituicao() throws SQLException {
		System.out.println("Chegando ao repositorio listarInstituicao");
		ArrayList<Instituicao> listaInstituicao = new ArrayList<Instituicao>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try {
			sql = "select * from Instituicao";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				Instituicao instituicao = new Instituicao(resultSet.getInt("id_Instituicao"), resultSet.getString("nome"),
						resultSet.getString("tipo"), resultSet.getString("cnpj"));
				listaInstituicao.add(instituicao);
			}
			
		} finally {
			stmt.close();
			resultSet.close();
		}
		
		return listaInstituicao;	
		
	}

	@Override
	public Instituicao procurarInstituicao(int idInstiruicao) {
		System.out.println("Chegando ao repositorio procurarInstituicao");
		return null;
	}

	@Override
	public void editarInstituicao(Instituicao instituicao) {
		System.out.println("Chegando ao repositorio editarInstituicao");
		
	}

	@Override
	public void removerInstituicao(int idInstituicao) {
		System.out.println("Chegando ao repositorio removerIntituicao");
		
	}

	@Override
	public boolean existeInstituicao(int idInstituicao) {
		System.out.println("Chegando ao repositorio exibirIntituicao");
		return false;
	}

}
