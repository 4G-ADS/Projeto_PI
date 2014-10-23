package com.fafica.projeto_pi.repositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioAgua;

public class RepositorioAgua implements IRepositorioAgua{

	@Override
	public void cadastrarAgua(NascenteAgua agua) {
		// TODO Auto-generated method stub
		System.out.println("Chegando ao repositorio cadastrarAgua");
		
	}

	@Override
	public NascenteAgua procurarAgua(int idAgua) {
		// TODO Auto-generated method stub
		System.out.println("Chegando ao repositorio ProcurarAgua");
		return null;
	}

	@Override
	public ArrayList<NascenteAgua> listaAgua() {
		System.out.println("Chegando ao repositorio listarAgua");
		return null;
		
	}

	@Override
	public void removerAgua(int idAgua) {
		System.out.println("Chegando ao repositorio removerAgua");
		
	}

	@Override
	public void editarAgua(NascenteAgua agua) {
		System.out.println("Chegando ao repositorio editarAgua");
		
	}

	@Override
	public boolean existeAgua(int idAgua) {
		System.out.println("Chegando ao repositorio existeAgua");
		return false;
	}

}
