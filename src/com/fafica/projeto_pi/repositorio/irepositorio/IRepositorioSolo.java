package com.fafica.projeto_pi.repositorio.irepositorio;

import com.fafica.projeto_pi.modelos.Solo;

public interface IRepositorioSolo {

	public void cadastrarSolo(Solo solo);
	public Solo procurarSolo(int id);
	public void listarSolo();
	public void editarSolo(Solo Solo);
	public void removerSolo(int id);
	public boolean existeSolo(int id);
}
