package com.fafica.projeto_pi.repositorioBDR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPesquisador;

public class RepositorioPesquisadorBDR implements IRepositorioPesquisador {

	private Connection connection = null;
	private int database = 0;

	public RepositorioPesquisadorBDR() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}

	public RepositorioPesquisadorBDR(int database) throws Exception {
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}

	@Override
	public void cadastrarPesquisadores(Pesquisador pesquisador)
			throws SQLException {
		System.out.println("Chegando ao repositorio cadastarPesquisadores");
		PreparedStatement stmt = null;
		String sql = "";
		ResultSet resultSet = null;

		try {

			sql = "INSERT INTO Pesquisador(id_reserva,nome_pesquisador,cpf,idade,profissao)values(?,?,?,?,?)";

			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,
						new String[] { "id_pesquisador" });

			} else {
				stmt = this.connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
			}

			stmt.setInt(1, pesquisador.getIdReserva());
			stmt.setString(2, pesquisador.getNome());
			stmt.setString(3, pesquisador.getCpf());
			stmt.setInt(4, pesquisador.getIdade());
			stmt.setString(5, pesquisador.getProfissao());

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

		try {
			sql = "select * from Pesquisador";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Pesquisador pesquisador = new Pesquisador(
						resultSet.getInt("id_pesquisador"),
						resultSet.getString("nome_pesquisador"),
						resultSet.getString("cpf"), resultSet.getInt("idade"),
						resultSet.getString("profissao"));
				pesquisador.setIdReserva(resultSet.getInt("id_reserva"));
				listaPesquisadores.add(pesquisador);

			}

		} finally {
			stmt.close();
			resultSet.close();
		}

		return listaPesquisadores;

	}

	@Override
	public ArrayList<Pesquisador> listarPesquisadores(int idReserva)
			throws SQLException {
		System.out.println("Chegando ao repositorio listarPesquisadores");

		ArrayList<Pesquisador> listaPesquisadores = new ArrayList<Pesquisador>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";

		try {
			sql = "select Pesquisador.id_pesquisador,Pesquisador.nome_pesquisador,Pesquisador.cpf,Pesquisador.idade,Pesquisador.profissao ";
			sql += "from Reserva ";
			sql += "inner join Pesquisador ";
			sql += "on Reserva.id_reserva = Pesquisador.id_reserva ";
			sql += "where Reserva.id_reserva = " + idReserva;
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Pesquisador pesquisador = new Pesquisador(
						resultSet.getInt("id_pesquisador"),
						resultSet.getString("nome_pesquisador"),
						resultSet.getString("cpf"), resultSet.getInt("idade"),
						resultSet.getString("profissao"));

				listaPesquisadores.add(pesquisador);

			}

		} finally {
			stmt.close();
			resultSet.close();
		}

		return listaPesquisadores;

	}

	@Override
	public Pesquisador procurarPesquisadores(int idPesquisador)
			throws SQLException {
		System.out.println("Chegando ao repositorio procurarPesquisadores");
		Pesquisador pesquisador = null;

		ArrayList<Pesquisador> listarProcura = listarPesquisadores();

		for (Pesquisador pesquisadorProcura : listarProcura) {
			if (idPesquisador == pesquisadorProcura.getIdPesquisador()) {
				pesquisador = pesquisadorProcura;
			}
		}
		return pesquisador;
	}

	@Override
	public void editarPesquisadores(Pesquisador pesquisador)
			throws SQLException {
		System.out.println("Chegando ao repositorio editarPesiquisadores");

		PreparedStatement stmt = null;
		if (pesquisador != null) {
			try {
				String sql = "update Pesquisador set nome_pesquisador = ? ,";
				sql += "cpf = ? ,";
				sql += "idade = ? ,";
				sql += "profissao = ? ";
				sql += "where id_pesquisador = ?";

				stmt = this.connection.prepareStatement(sql);

				stmt.setString(1, pesquisador.getNome());
				stmt.setString(2, pesquisador.getCpf());
				stmt.setInt(3, pesquisador.getIdade());
				stmt.setString(4, pesquisador.getProfissao());
				stmt.setInt(5, pesquisador.getIdPesquisador());

				stmt.executeUpdate();
				System.out.println("Edição completada");
			} finally {
				stmt.close();
			}
		}

	}

	@Override
	public void removerPesquisadores(int idPesquisador) throws SQLException {
		System.out.println("Chegando ao repositorio removerPesquisadores");

		PreparedStatement stmt = null;
		try {
			String sql = "delete from Pesquisador where id_pesquisador = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idPesquisador);
			stmt.execute();
			System.out.println("foi removido");
		} finally {
			stmt.close();
		}

	}

	@Override
	public boolean existe(Pesquisador pesquisador) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		try {
		sql = "select count(*) as existe from Pesquisador where cpf = ?";
		stmt = this.connection.prepareStatement(sql);	
		stmt.setString(1, pesquisador.getCpf());
		resultSet = stmt.executeQuery();
		resultSet.next();
		
		if(resultSet.getInt("existe") == 0) return false;
		else return true;
		} finally {
			stmt.close();
		}
	}

}
