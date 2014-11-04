package com.fafica.projeto_pi.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Conexao;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.modelos.Instituicao;
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
			sql = "INSERT INTO Solo(id_reserva,tamanho,tipo,recursos)values(?,?,?,?)";
			
			
			if (database == Database.ORACLE) {
				stmt = this.connection.prepareStatement(sql,new String[] { "id_solo" });

			} else {
				stmt = this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			}
			
			stmt.setInt(1, solo.getIdReserva());
			stmt.setDouble(2, solo.getTamanho());
			stmt.setString(3, solo.getTipo());
			stmt.setString(4, solo.getResursos());
			
			stmt.execute();
			
			resultSet = stmt.getGeneratedKeys();
			System.out.println("INSERT FOI CONCLUIDO COM SUCESSO");
		} finally{
			stmt.close();
		}
		
		
	}

	@Override
	public Solo procurarSolo(int idSolo) throws SQLException {
		System.out.println("Chegando ao repositorio procurarSolo");
		Solo soloProcura = null;
		
		ArrayList<Solo> listarProcura = listarSolo();
		
		for (Solo solo : listarProcura) {
			if(idSolo == solo.getIdSolo()){
				soloProcura = solo;
			}
		}
		return soloProcura;
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
				Solo solo =  new Solo(resultSet.getInt("id_solo"), resultSet.getString("tipo"),
						resultSet.getDouble("tamanho"),resultSet.getString("recursos"));
				
				listaSolo.add(solo);
				
			}
			
			
		} finally{
			stmt.close();
			resultSet.close();
		}
		
		return listaSolo;
		
	}

	@Override
	public ArrayList<Solo> listarSolo(int idReserva) throws SQLException {

		System.out.println("Chegando ao repositorio listarSolos");
		ArrayList<Solo> listaSolo = new ArrayList<Solo>();
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String sql = "";
		
		try{
			sql = "select Solo.id_solo,Solo.recursos,Solo.tamanho,Solo.tipo ";
			sql += "from Reserva ";
			sql += "inner join Solo ";
			sql += "on Reserva.id_reserva = Solo.id_reserva ";
			sql += "where Reserva.id_reserva = " + idReserva;
			stmt = this.connection.prepareStatement(sql);
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				Solo solo =  new Solo(resultSet.getInt("id_solo"), resultSet.getString("tipo"),
						resultSet.getDouble("tamanho"),resultSet.getString("recursos"));
				
				listaSolo.add(solo);
				
			}
			
			
		} finally{
			stmt.close();
			resultSet.close();
		}
		
		return listaSolo;
		
	
	}
	
	@Override
	public void editarSolo(Solo solo) throws SQLException {
		System.out.println("Chegando ao repositorio editarsolo");
		PreparedStatement stmt = null;
		if(solo != null){
			try{
				String sql = "update Solo set tamanho = ? ,";
				sql += "tipo = ? ,";
				sql += "recursos = ? ";
				sql += "where id_solo = ?";
				
				stmt = this.connection.prepareStatement(sql);
				
				stmt.setDouble(1, solo.getTamanho());
				stmt.setString(2, solo.getTipo());
				stmt.setString(3, solo.getResursos());
				stmt.setInt(4, solo.getIdSolo());
				
				stmt.executeUpdate();			
				System.out.println("Edição completada");
			}finally{
				stmt.close();
			}
		}
		
	}

	@Override
	public void removerSolo(int idSolo) throws SQLException {
		System.out.println("Chegando ao repositorio removerSolo");		

		PreparedStatement stmt = null;
		try {
			String sql = "delete from Solo where id_solo = ?";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idSolo);
			stmt.execute();
			System.out.println("foi removido");
		} finally {
			stmt.close();
		}
		
	}

	@Override
	public boolean existeSolo(int idSolo) {
		System.out.println("Chegando ao repositorio existeSolo");
		return false;
	}

}
