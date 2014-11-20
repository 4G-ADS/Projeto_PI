package com.fafica.projeto_pi.repositorioBDR;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioInstituicao;

public class RepositorioIntituicaoBDR implements IRepositorioInstituicao {

	// variaveis para conexao
	private Connection connection = null;
	private int database = 0;

	// Os construtores vão dizer qual banco usar
	public RepositorioIntituicaoBDR() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}

	public RepositorioIntituicaoBDR(int database) throws Exception {
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}

	// Metodos do crud
	@Override
	public void cadastrarInstituicao(Instituicao instituicao)
			throws SQLException {
		System.out.println("Chegando ao repositorio cadastrarIntituicao");
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";

		try {

			sql = "INSERT INTO Instituicao(id_reserva,nome,cnpj,tipo) VALUES (?, ?, ?, ?)";
			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,
						new String[] { "id_instituicao" });
			} else {
				stmt = this.connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
			}

			stmt.setInt(1, instituicao.getIdReserva());
			stmt.setString(2, instituicao.getNome());
			stmt.setString(3, instituicao.getCnpj());
			stmt.setString(4, instituicao.getTipo());

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

			while (resultSet.next()) {
				Instituicao instituicao = new Instituicao(
						resultSet.getInt("id_Instituicao"),
						resultSet.getString("nome"),
						resultSet.getString("tipo"),
						resultSet.getString("cnpj"));
				listaInstituicao.add(instituicao);
			}

		} finally {
			stmt.close();
			resultSet.close();
		}

		return listaInstituicao;

	}

	@Override
	public ArrayList<Instituicao> listarInstituicao(int idReserva)
			throws SQLException {
		System.out.println("Chegando ao repositorio listarInstituicao");
		ArrayList<Instituicao> listaInstituicao = new ArrayList<Instituicao>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";

		try {
			sql = "select Instituicao.id_instituicao, Instituicao.nome, Instituicao.tipo, Instituicao.cnpj ";
			sql += "from Reserva ";
			sql += "inner join Instituicao ";
			sql += "on Reserva.id_reserva = Instituicao.id_reserva ";
			sql += "where Reserva.id_reserva = " + idReserva;

			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Instituicao instituicao = new Instituicao(
						resultSet.getInt("id_Instituicao"),
						resultSet.getString("nome"),
						resultSet.getString("tipo"),
						resultSet.getString("cnpj"));
				listaInstituicao.add(instituicao);
			}

		} finally {
			stmt.close();
			resultSet.close();
		}

		return listaInstituicao;

	}

	@Override
	public Instituicao procurarInstituicao(int idInstituicao) throws SQLException {
		System.out.println("Chegando ao repositorio procurarInstituicao");
		Instituicao instituicaoProcura = null;
		
		ArrayList<Instituicao> listarProcura = listarInstituicao();
		
		for (Instituicao instituicao : listarProcura) {
			if(idInstituicao == instituicao.getIdInstituicao()){
				instituicaoProcura = instituicao;
			}
		}
		return instituicaoProcura;
	}


	@Override
	public void editarInstituicao(Instituicao instituicao) throws SQLException {
		System.out.println("Chegando ao repositorio editarInstituicao");
		PreparedStatement stmt = null;
		if(instituicao != null){
			try{
				String sql = "update Instituicao set nome = ? ,";
				sql += "tipo = ? ,";
				sql += "cnpj = ? ";
				sql += "where id_instituicao = ?";
				
				stmt = this.connection.prepareStatement(sql);
				
				stmt.setString(1, instituicao.getNome());
				stmt.setString(2, instituicao.getTipo());
				stmt.setString(3, instituicao.getCnpj());
				stmt.setInt(4, instituicao.getIdInstituicao());
				
				stmt.executeUpdate();			
				System.out.println("Edição completada");
			}finally{
				stmt.close();
			}
		}
	}

	
	@Override
	public void removerInstituicao(int idInstituicao) throws SQLException {
		System.out.println("Chegando ao repositorio removerIntituicao");

		PreparedStatement stmt = null;
		try {
			String sql = "delete from Instituicao where id_Instituicao = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idInstituicao);
			stmt.execute();
			System.out.println("foi removido");
		} finally {
			stmt.close();
		}

	}

	@Override
	public boolean existeInstituicao(int idInstituicao) {
		System.out.println("Chegando ao repositorio exibirIntituicao");
		return false;
	}

	@Override
	public boolean existe(int idInstituicao) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String slq;
		try {
			slq = "select count(*) as existe from instituicao where idInstituicao = ?";
			stmt = this.connection.prepareStatement(slq);
			stmt.setInt(1, idInstituicao);
			resultSet.next();
			if(resultSet.getInt("existe") == 0) return false;
			else return true;			
		} finally{
			// TODO: handle exception
		}
	}

}
