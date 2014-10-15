package com.fafica.projeto_pi.repositorio;

public interface IRepositorioAgua {

	public void cadastrar(Agua agua);
	public Agua procurar(int id);
	public void atualizar(Agua agua);
	public void remover(int id);
	public boolean existe(int id);
}
