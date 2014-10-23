package com.fafica.projeto_pi.repositorio.irepositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.NascenteAgua;

public interface IRepositorioAgua {

	public void cadastrarAgua(NascenteAgua agua);
	public NascenteAgua procurarAgua(int idAgua);
	public ArrayList<NascenteAgua> listaAgua();
	public void removerAgua(int idAgua);
	public void editarAgua(NascenteAgua agua);
	public boolean existeAgua(int idAgua);
	
}
