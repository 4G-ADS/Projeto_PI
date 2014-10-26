package com.fafica.projeto_pi.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.modelos.Usuario;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioUsuario;

public class RepositorioUsuario implements IRepositorioUsuario{

	private Connection connection = null;
	private int database = 0;
	
	public RepositorioUsuario() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}
	
	public RepositorioUsuario(int database) throws Exception {
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}
	
	@Override
	public void cadastrarUsuario(Usuario usuario) throws SQLException {
		System.out.println("chegando ao repositorioUsuario cadastrarUsuario");
		PreparedStatement stmt = null;
		String sql = null;
		ResultSet resultSet = null;
		
		try {
			
		sql = "INSERT INTO Usuario(nome,senha,data)values(?,?,?)";
		
		if (database == Database.ORACLE) {
			stmt = this.connection.prepareStatement(sql,
					new String[] { "id_Usuario" });

		} else {
			stmt = this.connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
		}
			
		stmt.setString(1, usuario.getNome());
		stmt.setInt(2, usuario.getSenha());
//ak 	stmt.setDate(1, usuario.getData());
		System.out.println("INSERT FOI CONCLUIDO COM SUCESSO");
		stmt.execute();
		
		resultSet = stmt.getGeneratedKeys();
		
		} finally {
			stmt.close();
		}
	}

	@Override
	public void editarUsuario(Usuario usuario) {
		System.out.println("chegando ao repositorioUsuario editarUsuario");
			
	}

	@Override
	public void removerUsuario(int idUsuario) {
		System.out.println("chegando ao repositorio removerUsuario");
		
	}

	@Override
	public void procurarUsuario(int idUsuario) {
		System.out.println("Chegando ao repositorio procurarUsuario");
		
	}

	@Override
	public ArrayList<Usuario> listarUsuario() throws SQLException {
		System.out.println("Chegando ao repositorio listarUsuarios");
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select * from Usuario";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				Usuario usuario =  new Usuario(resultSet.getInt("id_reserva"), resultSet.getInt("id_usuario"),
						resultSet.getString("nome"),resultSet.getInt("senha"),resultSet.getDate("data"));
				
				listaUsuarios.add(usuario);
				
			}
			
			
		} finally{
			stmt.close();
			resultSet.close();
		}
		
		return listaUsuarios;
		
	}

	
	
}
