package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.NascenteNaoEncontradaException;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.repositorioBDR.RepositorioNascenteAguaBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioNascenteAgua;

public class ControladorNascente {

	IRepositorioNascenteAgua repositorioNascenteAgua;

	public ControladorNascente() throws Exception {
		this.repositorioNascenteAgua = new RepositorioNascenteAguaBDR();

	}

	public ArrayList<NascenteAgua> listarNascentes() throws SQLException {
		System.out.println("Passando pela controladora listarNascentes");
		return this.repositorioNascenteAgua.listarNascenteAgua();
	}
	
	public ArrayList<NascenteAgua> listarNascentes(int idReserva) throws SQLException {
		System.out.println("Passando pela controladora listarNascentes");
		return this.repositorioNascenteAgua.listarNascenteAgua(idReserva);
	}

	public NascenteAgua procurarNascente(int idNascente) throws SQLException,NascenteNaoEncontradaException{
		System.out.println("Passando pela controladora procurarNascente");
		return this.repositorioNascenteAgua.procurarAgua(idNascente);
	}

	public void editarNascente(NascenteAgua nascente) throws SQLException,NascenteNaoEncontradaException{
		System.out.println("Passando pelo controladora editarNascente");
		this.repositorioNascenteAgua.editarAgua(nascente);
	}

	public void removerNascente(int idNascente) throws SQLException,NascenteNaoEncontradaException {
		System.out.println("Passando pela controladora removerNascente");
		this.repositorioNascenteAgua.removerAgua(idNascente);
	}


	
}
