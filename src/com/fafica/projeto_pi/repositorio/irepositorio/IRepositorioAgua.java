package com.fafica.projeto_pi.repositorio.irepositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Agua;

public interface IRepositorioAgua {

	public void cadastrarAgua(Agua agua);
	public Agua procurarAgua(int idAgua);
	public ArrayList<Agua> listaAgua();
	public void removerAgua(int idAgua);
	public void editarAgua(Agua agua);
	public boolean existeAgua(int idAgua);
	
}
