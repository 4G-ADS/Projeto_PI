package com.fafica.projeto_pi.repositorio.irepositorio;

import com.fafica.projeto_pi.modelos.Pesquisador;

public interface IRepositorioPesquisador {

	public void cadastrarPesquisadores(Pesquisador pesquisador);
	public void listarPesquisadores();
	public Pesquisador procurarPesquisadores(int id);
	public void editarPesquisadores(Pesquisador pesquisador);
	public void removerPesquisadores(int id);
	public boolean existePesquisadores(int id);
}
