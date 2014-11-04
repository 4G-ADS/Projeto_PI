package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorio.RepositorioNascenteAgua;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioNascenteAgua;

public class ControladorReservaNascente {

	IRepositorioNascenteAgua repositorioNascenteAgua;

	public ControladorReservaNascente() throws Exception {
		this.repositorioNascenteAgua = new RepositorioNascenteAgua();

	}

	public void cadastrarNascente(Reserva reserva) throws SQLException {
		// lista de nascentes		
		System.out.println("Passando pela controladora cadastrarNascentes");
		 for (NascenteAgua agua : reserva.getNascenteAgua()) {
		 this.repositorioNascenteAgua.cadastrarAgua(agua);
		 }
	}

	public ArrayList<NascenteAgua> listarNascentes() throws SQLException {
		System.out.println("Passando pela controladora listarNascentes");
		return this.repositorioNascenteAgua.listarNascenteAgua();
	}
	
	public ArrayList<NascenteAgua> listarNascentes(int idReserva) throws SQLException {
		System.out.println("Passando pela controladora listarNascentes");
		return this.repositorioNascenteAgua.listarNascenteAgua(idReserva);
	}

	public NascenteAgua procurarNascente(int idNascente) throws SQLException{
		System.out.println("Passando pela controladora procurarNascente");
		return this.repositorioNascenteAgua.procurarAgua(idNascente);
	}

	public void editarNascente(NascenteAgua nascente) throws SQLException{
		System.out.println("Passando pelo controladora editarNascente");
		this.repositorioNascenteAgua.editarAgua(nascente);
	}

	public void removerNascente(int idNascente) throws SQLException {
		System.out.println("Passando pela controladora removerNascente");
		this.repositorioNascenteAgua.removerAgua(idNascente);
	}


	
}
