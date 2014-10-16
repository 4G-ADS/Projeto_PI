package com.fafica.projeto_pi.repositorio.irepositorio;

import com.fafica.projeto_pi.modelos.Agua;

public interface IRepositorioAgua {

	public void cadastrarAgua(Agua agua);
	public Agua procurarAgua(int id);
	public void listaAgua();
	public void removerAgua(int id);
	public void editarAgua(Agua agua);
	public boolean existeAgua(int id);
	
}
