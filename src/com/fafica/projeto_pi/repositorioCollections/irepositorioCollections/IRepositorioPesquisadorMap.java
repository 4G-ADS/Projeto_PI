package com.fafica.projeto_pi.repositorioCollections.irepositorioCollections;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Pesquisador;

public interface IRepositorioPesquisadorMap {

	public void cadastrarPesquisadores(Pesquisador pesquisador);
	public ArrayList<Pesquisador> listarPesquisadores();
	public Pesquisador procurarPesquisadores(int idPesquisador);
	public void editarPesquisadores(Pesquisador pesquisador);
	public void removerPesquisadores(int idPesquisador);

}
