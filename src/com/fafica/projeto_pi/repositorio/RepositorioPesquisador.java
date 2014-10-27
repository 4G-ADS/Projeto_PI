package com.fafica.projeto_pi.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Usuario;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPesquisador;

public class RepositorioPesquisador implements IRepositorioPesquisador{

	private Connection connection = null;
	private int database = 0;
	
	public RepositorioPesquisador() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}
	
	public RepositorioPesquisador(int database) throws Exception{
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}
	
	@Override
	public void cadastrarPesquisadores(Pesquisador pesquisador) throws SQLException {
		System.out.println("Chegando ao repositorio cadastarPesquisadores");
		PreparedStatement stmt = null;
		String sql = "";
		ResultSet resultSet = null;
		
		try {
			
			sql = "INSERT INTO Pesquisador(nome,cpf,idade)values(?,?,?)";
			
			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,
						new String[] { "id_pesquisador" });

			} else {
				stmt = this.connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
			}
		
			stmt.setString(1, pesquisador.getNome());
			stmt.setString(2, pesquisador.getCpf());
			stmt.setInt(3, pesquisador.getIdade());
			
			stmt.execute();			
			resultSet = stmt.getGeneratedKeys();
			System.out.println("INSERT FOI CONCLUIDO COM SUCESSO");
		} finally {
			stmt.close();
		}
		
		
	}

	@Override
	public ArrayList<Pesquisador> listarPesquisadores() throws SQLException {
		System.out.println("Chegando ao repositorio listarPesquisadores");
		ArrayList<Pesquisador> listaPesquisadores = new ArrayList<Pesquisador>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from Pesquisador";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				Pesquisador pesquisador =  new Pesquisador(resultSet.getInt("id_pesquisador"),
						resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getInt("idade"),
						resultSet.getString("tipo"));
				
				listaPesquisadores.add(pesquisador);
				
			}
			
			
		} finally{
			stmt.close();
			resultSet.close();
		}
		
		return listaPesquisadores;
		
	}

	@Override
	public Pesquisador procurarPesquisadores(int id) {
		System.out.println("Chegando ao repositorio procurarPesquisadores");
		return null;
	}

	@Override
	public void editarPesquisadores(Pesquisador pesquisador) {
		System.out.println("Chegando ao repositorio editarPesiquisadores");
		
	}

	@Override
	public void removerPesquisadores(int id) {
		System.out.println("Chegando ao repositorio removerPesquisadores");
		
	}

	@Override
	public boolean existePesquisadores(int id) {
		System.out.println("Chegando ao repositorio existePesquisadores");
		return false;
	}

}
