package com.fafica.projeto_pi.controladora;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.excecoes.PesquisadorNaoEncontradoException;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPesquisadorBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPesquisador;

public class ControladorPesquisadores {

	IRepositorioPesquisador repositorioPesquisador;

	public ControladorPesquisadores() throws Exception {

		this.repositorioPesquisador = new RepositorioPesquisadorBDR(Database.MYSQL);

	}
	public void cadastrarPesquisador(Pesquisador pesquisador) throws SQLException{
		this.repositorioPesquisador.cadastrarPesquisadores(pesquisador);
	}
	
	public ArrayList<Pesquisador> listarPesquisadores() throws SQLException, IOException {
		System.out.println("Passando pela controladora listarPesquisadores");
		ArrayList<Pesquisador> lista = null; 
	
			lista = this.repositorioPesquisador.listarPesquisadores();

		return lista;
	}

	public ArrayList<Pesquisador> listarPesquisadores(int idReserva) throws SQLException {
		System.out.println("Passando pela controladora listarPesquisadores");
		return this.repositorioPesquisador.listarPesquisadores(idReserva);
	}
	
	public Pesquisador procurarPesquisador(int idPesquisador)throws SQLException, IOException,PesquisadorNaoEncontradoException {
		System.out.println("Passando pela controladora procurarPesquisador");
		Pesquisador pesquisador = null;

			pesquisador = this.repositorioPesquisador.procurarPesquisadores(idPesquisador);

		return pesquisador;
		
	}

	public void editarPesquisador(Pesquisador pesquisador) throws SQLException, IOException,PesquisadorNaoEncontradoException{
		System.out.println("Passando pela controladora editarPesquisador");

			this.repositorioPesquisador.editarPesquisadores(pesquisador);

	}

	public void removerPesquisadores(int idPesquisador) throws SQLException, IOException ,PesquisadorNaoEncontradoException{
		System.out.println("Passando pela controladora removerPesquisador");

			this.repositorioPesquisador.removerPesquisadores(idPesquisador);

	}

}
