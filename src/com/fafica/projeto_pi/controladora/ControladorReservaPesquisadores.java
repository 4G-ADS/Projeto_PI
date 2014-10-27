package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.ReservaRecursos;
import com.fafica.projeto_pi.repositorio.RepositorioPesquisador;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPesquisador;

public class ControladorReservaPesquisadores {

	IRepositorioPesquisador repositorioPesquisador;

	public ControladorReservaPesquisadores() throws Exception {
		this.repositorioPesquisador = new RepositorioPesquisador();

	}

	public void cadastrarPesquisadores(ReservaRecursos reservaRecursos) throws SQLException {
		System.out.println("Passando pela controladora cadastrarPesquisadores");
		
		// lista de pesquisadores
		 for (Pesquisador pesquisador :reservaRecursos.getPesquisadores()) {
		 this.repositorioPesquisador.cadastrarPesquisadores(pesquisador);
		 }
	}

	public ArrayList<Pesquisador> listarPesquisadores() throws SQLException {
		System.out.println("Passando pela controladora listarPesquisadores");
		return this.repositorioPesquisador.listarPesquisadores();
	}

	public Pesquisador procurarPesquisador(int idPesquisador) {
		System.out.println("Passando pela controladora procurarPesquisador");
		return this.repositorioPesquisador.procurarPesquisadores(idPesquisador);
	}

	public void editarPesquisador(Pesquisador pesquisador) {
		System.out.println("Passando pela controladora editarPesquisador");
		this.repositorioPesquisador.editarPesquisadores(pesquisador);
	}

	public void removerPesquisadores(int idPesquisador) {
		System.out.println("Passando pela controladora removerPesquisador");
		this.repositorioPesquisador.removerPesquisadores(idPesquisador);
	}

}
