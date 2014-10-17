package com.fafica.projeto_pi.repositorio.irepositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Pesquisador;

public interface IRepositorioPesquisador {

	public void cadastrarPesquisadores(Pesquisador pesquisador);
	public ArrayList<Pesquisador> listarPesquisadores();
	public Pesquisador procurarPesquisadores(int idPesquisador);
	public void editarPesquisadores(Pesquisador pesquisador);
	public void removerPesquisadores(int idPesquisador);
	public boolean existePesquisadores(int idPesquisador);
}
