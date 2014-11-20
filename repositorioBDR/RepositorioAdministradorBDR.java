package com.fafica.projeto_pi.repositorioBDR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.excecoes.AdministradorNaoEncontradoException;
import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioAdminstrador;

public class RepositorioAdministradorBDR implements IRepositorioAdminstrador{

	private Connection connection = null;
	private int database = 0;
	
	public RepositorioAdministradorBDR() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}
	
	public RepositorioAdministradorBDR(int database) throws Exception {
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}
	
	@Override
	public void cadastrarAdministrador(Administrador administrador) throws SQLException {
		System.out.println("chegando ao repositorioUsuario cadastrarAdministrardor");
		System.out.println(administrador);
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet resultSet = null;
		
		try {
			
		sql = "INSERT INTO administrador(login,nome,senha,cpf)values(?,?,?,?)";
		
		if (database == Database.ORACLE) {
			stmt = this.connection.prepareStatement(sql,
					new String[] { "id_instituicao" });
		} else {
			stmt = this.connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
		}

		
		stmt.setString(1, administrador.getLogin());
		stmt.setString(2, administrador.getNome());
		stmt.setInt(3, administrador.getSenha());
		stmt.setInt(4, administrador.getCpf());


		System.out.println("INSERT FOI CONCLUIDO COM SUCESSO");
		stmt.execute();
		
		resultSet = stmt.getGeneratedKeys();
		
		} finally {
			stmt.close();
		}
	}

	@Override
	public void editarAdministrador(Administrador administrador) throws SQLException , AdministradorNaoEncontradoException{
		System.out.println("chegando ao repositorioUsuario editarAdministrardor");
			PreparedStatement stmt = null;
			String sql = "";
			
			try {
				sql = "update admisnistrador set login = ? ,";
				sql += "nome = ? ," ;
				sql += "senha = ? ";
				sql += "where id_adm";
				
				stmt = this.connection.prepareStatement(sql);
				
				stmt.setString(1, administrador.getLogin());
				stmt.setString(2, administrador.getNome());
				stmt.setInt(3, administrador.getSenha());
				
				stmt.executeUpdate();
				
			} finally {
				
			}
	}

	@Override
	public void removerAdministrador(int idAdministrardor) throws SQLException, AdministradorNaoEncontradoException {
		System.out.println("chegando ao repositorio removerAdministrardor");
		PreparedStatement stmt = null;
		String sql = "";
		try {
		
			sql = "delete form administrador where id_adm = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idAdministrardor);
			
			stmt.execute();
			System.out.println("foi removido");
		} finally {

		}
		
	}

	@Override
	public Administrador procurarAdministrador(int idAdministrardor) throws SQLException , AdministradorNaoEncontradoException{
		System.out.println("Chegando ao repositorio procurarAdministrardor");

		Administrador administrador = null;
		ArrayList<Administrador> listaProvisoria = listarAdministrador();
		
		for (Administrador adm : listaProvisoria) {
			if(adm.getId() == idAdministrardor){
				administrador = adm;
				break;
			}
		}
		
		return administrador;
	}

	@Override
	public ArrayList<Administrador> listarAdministrador() throws SQLException {
		System.out.println("Chegando ao repositorio listarAdministrardor");
		ArrayList<Administrador> listaUsuarios = new ArrayList<Administrador>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from administrador";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				Administrador administrador =  new Administrador(resultSet.getInt("id_adm"),
						resultSet.getString("nome"),resultSet.getString("login"),
						resultSet.getInt("cpf"),resultSet.getInt("senha"));
				
				listaUsuarios.add(administrador);
				
			}
			
			
		} finally{
			stmt.close();
			resultSet.close();
		}
		
		return listaUsuarios;
		
	}

	@Override
	public boolean existe(int idAdministrador) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		try {
		sql = "select count(*) as existe from administrador where idAdministrador = ?";
		stmt = this.connection.prepareStatement(sql);	
		stmt.setInt(1, idAdministrador);
		resultSet.next();
		if(resultSet.getInt("existe") == 0) return false;
		else return true;
		} finally {
			stmt.close();
		}
	}

	
	
}
