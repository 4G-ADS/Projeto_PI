package com.fafica.projeto_pi.repositorioBDR.irepositorioBDR;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.NascenteNaoEncontradaException;
import com.fafica.projeto_pi.excecoes.PesquisadorNaoEncontradoException;
import com.fafica.projeto_pi.modelos.Pesquisador;

public interface IRepositorioPesquisador {

	public void cadastrarPesquisadores(Pesquisador pesquisador) throws  SQLException;
	public ArrayList<Pesquisador> listarPesquisadores() throws   SQLException;
	public Pesquisador procurarPesquisadores(int idPesquisador) throws   SQLException,PesquisadorNaoEncontradoException;
	public void editarPesquisadores(Pesquisador pesquisador) throws   SQLException,PesquisadorNaoEncontradoException;
	public void removerPesquisadores(int idPesquisador) throws  SQLException,PesquisadorNaoEncontradoException;
	public ArrayList<Pesquisador> listarPesquisadores(int idReserva)
			throws SQLException;
	public boolean existe(Pesquisador pesquisador) throws SQLException;

	}
