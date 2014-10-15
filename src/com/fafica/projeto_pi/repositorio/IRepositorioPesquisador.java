package com.fafica.projeto_pi.repositorio;

public interface IRepositorioPesquisador {

	public void cadastrar(Pesquisador pesquisador);
	public Pesquisador procurar(int id);
	public void atualizar(Pesquisador pesquisador);
	public void remover(int id);
	public boolean existe(int id);
}
