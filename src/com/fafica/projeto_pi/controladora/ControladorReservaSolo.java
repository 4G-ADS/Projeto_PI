package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.ReservaRecursos;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.repositorio.RepositorioSolo;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioSolo;

public class ControladorReservaSolo {

	IRepositorioSolo repositorioSolo;

	public ControladorReservaSolo() throws Exception {
		this.repositorioSolo = new RepositorioSolo();

	}

	public void cadastrarSolo(ReservaRecursos reservaRecursos) throws SQLException {
		System.out.println("Passando pela controladora cadastarSolo");
		// lista de solos
		 for (Solo solo : reservaRecursos.getSolos()) {
		 this.repositorioSolo.cadastrarSolo(solo);
		 }
	}

	public ArrayList<Solo> listarSolo() throws SQLException {
		System.out.println("Passando pela controladora listarSolo");
		return this.repositorioSolo.listarSolo();
	}

	public Solo procurarSolo(int idSolo) {
		System.out.println("Passando pela controladora procurarSolo");
		return this.repositorioSolo.procurarSolo(idSolo);
	}

	public void editarSolo(Solo solo) {
		System.out.println("Passando pela controladora editarSolo");
		this.repositorioSolo.editarSolo(solo);
	}

	public void removerSolo(int idSolo) {
		System.out.println("Passando pela controladora removerSolo");
		this.repositorioSolo.removerSolo(idSolo);
	}



}
