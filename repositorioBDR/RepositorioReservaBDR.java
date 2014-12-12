package com.fafica.projeto_pi.repositorioBDR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.excecoes.ReservaNaoEncontradaException;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioReserva;

public class RepositorioReservaBDR implements IRepositorioReserva {

	private Connection connection = null;
	private int database = 0;

	public RepositorioReservaBDR() throws Exception {
		this.connection = Conexao.getConnection(Database.MYSQL);
		this.database = Database.MYSQL;
	}

	public RepositorioReservaBDR(int database) throws Exception {
		this.connection = Conexao.getConnection(database);
		this.database = database;
	}

	@Override
	public void cadastrarReserva(Reserva reserva) throws SQLException {
		System.out.println("Chegando ao repositorio cadastrarReserva");
		PreparedStatement stmt = null;
		String sql = "";
		ResultSet resultSet = null;

		try {
			sql = "INSERT INTO Reserva(id_adm,clima,Latitude_reserva,Longitude_reserva,nome_reserva,tamanho_reserva)values(?,?,?,?,?,?)";
			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,
						new String[] { "id_reserva" });

			} else {
				stmt = this.connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
			}
			
			stmt.setInt(1, reserva.getIdAdm());
			stmt.setString(2, reserva.getClima());
			stmt.setDouble(3, reserva.getLatitude());
			stmt.setDouble(4, reserva.getLongitude());
			stmt.setString(5, reserva.getNome());
			stmt.setDouble(6, reserva.getTamanho());

			stmt.execute();
			resultSet = stmt.getGeneratedKeys();

			int idReserva = 0;
			while (resultSet.next()) {
				idReserva = resultSet.getInt(1);
			}

			reserva.setIdReserva(idReserva);

			System.out.println("INSERT FOI CONCLUIDO COM SUCESSO");
		} finally {
			stmt.close();
		}

	}

	@Override
	public Reserva procurarReserva(int idReserva) throws SQLException,ReservaNaoEncontradaException {
		System.out.println("Chegando ao repositorio procurarReserva");
		Reserva reserva = null;

		ArrayList<Reserva> listarProcura = listarReserva();

		for (Reserva reservaProcura : listarProcura) {
			if (idReserva == reservaProcura.getIdReserva()) {
				reserva = reservaProcura;
			}
		}
		return reserva;
	}

	@Override
	public ArrayList<Reserva> listarReserva() throws SQLException,ReservaNaoEncontradaException{
		System.out.println("Passando pela reserva listarReserva");
		
		ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		try {

			sql = "select * from Reserva";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				 
				
				
				Reserva reserva = new Reserva(resultSet.getInt("id_adm"), resultSet.getInt("id_reserva"),resultSet.getString("clima"),resultSet.getString("nome_reserva"),
						resultSet.getDouble("tamanho_reserva"),resultSet.getDouble("latitude_reserva"),
						resultSet.getDouble("longitude_reserva"));
				listaReservas.add(reserva);
				
			}

		} finally {
			stmt.close();
			resultSet.close();
		}

		return listaReservas;
	}
	

	@Override
	public void editarReserva(Reserva reserva) throws SQLException,ReservaNaoEncontradaException {
		System.out.println("Chegando ao repositorio atualizarReserva");
		PreparedStatement stmt = null;
		if (reserva != null) {
			try {
				String sql = "update Reserva set clima = ? ,";
				sql += "Latitude_reserva = ? ,";
				sql += "Longitude_reserva = ? ,";
				sql += "nome_reserva = ? ,";
				sql += "Tamanho_reserva = ? ";
				sql += "where id_reserva = ?";

				stmt = this.connection.prepareStatement(sql);

				stmt.setString(1, reserva.getClima());
				stmt.setDouble(2, reserva.getLatitude());
				stmt.setDouble(3, reserva.getLongitude());
				stmt.setString(4, reserva.getNome());
				stmt.setDouble(5, reserva.getTamanho());
				stmt.setInt(6, reserva.getIdReserva());

				stmt.executeUpdate();
				System.out.println("Edição completada");
			} finally {
				stmt.close();
			}
		}

	}

	@Override
	public void removerReserva(int idReserva) throws SQLException,ReservaNaoEncontradaException {
		System.out.println("Chegando ao repositorio removerReserva");

		PreparedStatement stmt = null;
		try {
			String sql = "delete from Reserva where id_reserva = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idReserva);
			stmt.execute();
			System.out.println("foi removido");
		} finally {
			stmt.close();
		}

	}


}
