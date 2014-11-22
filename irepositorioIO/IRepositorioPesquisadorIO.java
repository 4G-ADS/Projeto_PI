package com.fafica.projeto_pi.repoditoioIO.irepositorioIO;

import java.io.IOException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Pesquisador;

public interface IRepositorioPesquisadorIO {

	public void cadastrarPesquisadores(Pesquisador pesquisador) throws IOException;
	public ArrayList<Pesquisador> listarPesquisadores() throws IOException;
	public Pesquisador procurarPesquisadores(int idPesquisador) throws IOException;
	public void editarPesquisadores(Pesquisador pesquisador) throws IOException;
	public void removerPesquisadores(int idPesquisador) throws IOException;
}
