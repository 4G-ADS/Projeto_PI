package com.fafica.projeto_pi.repositorio;

public interface IRepositorioSolo {

	public void cadastrar(Solo solo);
	public Solo procurar(int id);
	public void atualizar(Solo Solo);
	public void remover(int id);
	public boolean existe(int id);
}
