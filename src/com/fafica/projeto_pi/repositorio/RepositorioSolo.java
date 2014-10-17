package com.fafica.projeto_pi.repositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioSolo;

public class RepositorioSolo implements IRepositorioSolo{

	@Override
	public void cadastrarSolo(Solo solo) {
		System.out.println("Chegando ao repositorio cadastrarSolo");
		
	}

	@Override
	public Solo procurarSolo(int idSolo) {
		System.out.println("Chegando ao repositorio procurarSolo");
		return null;
	}

	@Override
	public ArrayList<Solo> listarSolo() {
		System.out.println("Chegando ao repositorio listarSolos");
		return null;
		
	}

	@Override
	public void editarSolo(Solo Solo) {
		System.out.println("Chegando ao repositorio editarsolo");
		
	}

	@Override
	public void removerSolo(int idSolo) {
		System.out.println("Chegando ao repositorio removerSolo");
		
	}

	@Override
	public boolean existeSolo(int idSolo) {
		System.out.println("Chegando ao repositorio existeSolo");
		return false;
	}

}
