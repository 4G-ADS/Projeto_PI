package com.fafica.projeto_pi.repositorioBDR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
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
			sql = "INSERT INTO Reserva(clima,Latitude_reserva,Longitude_reserva,nome_reserva,tamanho_reserva)values(?,?,?,?,?)";
			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,
						new String[] { "id_reserva" });

			} else {
				stmt = this.connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
			}

			stmt.setString(1, reserva.getClima());
			stmt.setDouble(2, reserva.getLatitude());
			stmt.setDouble(3, reserva.getLongitude());
			stmt.setString(4, reserva.getNome());
			stmt.setDouble(5, reserva.getTamanho());

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
	public Reserva procurarReserva(int idReserva) throws SQLException {
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
	public ArrayList<Reserva> listarReserva() throws SQLException {
		System.out.println("Passando pela reserva listarReserva");
		
		ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		try {

			sql = "select Reserva.id_reserva from Reserva";
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			int idReservaProvisorio = 0;
			while (resultSet.next()) {
				
				idReservaProvisorio = resultSet.getInt("id_reserva");
				
				if(idReservaProvisorio !=0){
				Reserva reserva = recuperarReserva(idReservaProvisorio);
				listaReservas.add(reserva);
				}
			}

		} finally {
			stmt.close();
			resultSet.close();
		}

		return listaReservas;
	}

	@Override
	public Reserva recuperarReserva(int id_Reserva) throws SQLException {
		System.out.println("Chegando ao repositorio recuperarReserva");
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		ArrayList<Pesquisador> listarPesquisador = new ArrayList<Pesquisador>();
		ArrayList<Solo> listaSolos = new ArrayList<Solo>();
		ArrayList<NascenteAgua> listaNascentes = new ArrayList<NascenteAgua>();
		ArrayList<PlantaPequenoPorte> listaPlantasPequenas = new ArrayList<PlantaPequenoPorte>();
		ArrayList<PlantaMedioPorte> listaPlantasMedias = new ArrayList<PlantaMedioPorte>();
		ArrayList<PlantaGrandePorte> listaPlantasGrandes = new ArrayList<PlantaGrandePorte>();

		try {
			sql = "select * from Reserva ";
			sql += "inner join Pesquisador on Reserva.id_reserva = Pesquisador.id_reserva ";
			sql += "inner join Solo on Reserva.id_reserva = Solo.id_reserva ";
			sql += "inner join nascente_agua on Reserva.id_reserva = nascente_agua.id_reserva ";
			sql += "inner join Planta_pequeno_porte on Planta_pequeno_porte.id_reserva ";
			sql += "inner join Planta_medio_porte on Reserva.id_reserva = Planta_medio_porte.id_reserva ";
			sql += "inner join Planta_grande_porte on Reserva.id_reserva = Planta_grande_porte.id_reserva " ;
			sql += "where Reserva.id_reserva = ?";
			
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id_Reserva);
			resultSet = stmt.executeQuery();

			int id_reservaBanco = 0;
			String climaBanco = "";
			String nomeReservaBanco = "";
			double tamanhoReservaBanco = 0;
			double latitudeReservaBanco = 0;
			double longitudeReservaBanco = 0;
			while (resultSet.next()) {

				Pesquisador pesquisador = new Pesquisador(
						resultSet.getInt("id_pesquisador"),
						resultSet.getString("nome_pesquisador"),
						resultSet.getString("cpf"), resultSet.getInt("idade"),
						resultSet.getString("profissao"));

				Solo solo = new Solo(resultSet.getInt("id_solo"),
						resultSet.getString("tipo_solo"),
						resultSet.getDouble("tamanho_solo"),
						resultSet.getString("recursos_solo"));

				NascenteAgua nascente = new NascenteAgua(
						resultSet.getInt("id_nascente_agua"),
						resultSet.getDouble("Latitude_nascente_agua"),
						resultSet.getDouble("Longitude_nascente_agua"),
						resultSet.getString("Nome_nascente_agua"),
						resultSet.getString("Tipo_nascente_agua"));

				PlantaPequenoPorte plantaPequena = new PlantaPequenoPorte(
						resultSet.getInt("id_planta_pequeno_porte"),
						resultSet.getString("especie_planta_pequeno_porte"),
						resultSet.getString("nome_planta_pequeno_porte"),
						resultSet.getDouble("tamanho_planta_pequeno_porte"));

				PlantaMedioPorte plantaMedia = new PlantaMedioPorte(
						resultSet.getInt("id_planta_Medio_porte"),
						resultSet.getString("especie_planta_medio_porte"),
						resultSet.getString("nome_planta_medio_porte"),
						resultSet.getDouble("tamanho_planta_medio_porte"));

				PlantaGrandePorte plantaGrande = new PlantaGrandePorte(
						resultSet.getInt("id_planta_Medio_porte"),
						resultSet.getString("especie_planta_grande_porte"),
						resultSet.getString("nome_planta_grande_porte"),
						resultSet.getDouble("tamanho_planta_grande_porte"));

				listarPesquisador.add(pesquisador);				
				listaSolos.add(solo);
				listaNascentes.add(nascente);
				listaPlantasPequenas.add(plantaPequena);
				listaPlantasMedias.add(plantaMedia);
				listaPlantasGrandes.add(plantaGrande);
				
				id_reservaBanco =resultSet.getInt("id_reserva");
				climaBanco = resultSet.getString("clima");
				nomeReservaBanco = resultSet.getString("nome_reserva");
				tamanhoReservaBanco = resultSet.getDouble("tamanho_reserva");
				latitudeReservaBanco = resultSet.getDouble("latitude_reserva");
				longitudeReservaBanco = resultSet.getDouble("longitude_reserva");
			}
			
			Reserva reservaBanco = new Reserva(id_reservaBanco,climaBanco,
					nomeReservaBanco,tamanhoReservaBanco,
					latitudeReservaBanco,longitudeReservaBanco,
					listaPlantasPequenas, listaPlantasMedias,
					listaPlantasGrandes, listaSolos, listaNascentes,
					listarPesquisador);

			
			return reservaBanco;
		} finally {
			stmt.close();
			resultSet.close();
		}

		

	}

	@Override
	public void editarReserva(Reserva reserva) throws SQLException {
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
	public void removerReserva(int idReserva) throws SQLException {
		System.out.println("Chegando ao repositorio removerReserva");

		PreparedStatement stmt = null;
		try {
			String sql = "delete from Reserva where idReserva = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idReserva);
			stmt.execute();
			System.out.println("foi removido");
		} finally {
			stmt.close();
		}

	}

	@Override
	public boolean existeReserva(int idReserva) throws SQLException {
		System.out.println("Chegando ao repositorio existeReserva");
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		try {
		sql = "select count(*) as existe from Reserva where idReserva = ?";
		stmt = this.connection.prepareStatement(sql);	
		stmt.setInt(1, idReserva);
		resultSet.next();
		if(resultSet.getInt("existe") == 0) return false;
		else return true;
		} finally {
			stmt.close();
		}
	}

}
