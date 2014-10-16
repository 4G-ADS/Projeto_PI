package com.fafica.projeto_pi.repositorio;

import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioSolo;

public class RepositorioSolo implements IRepositorioSolo{

	@Override
	public void cadastrarSolo(Solo solo) {
		System.out.println("Chegando ao repositorio cadastrarSolo");
		
	}

	@Override
	public Solo procurarSolo(int id) {
		System.out.println("Chegando ao repositorio procurarSolo");
		return null;
	}

	@Override
	public void listarSolo() {
		System.out.println("Chegando ao repositorio listarSolos");
		
	}

	@Override
	public void editarSolo(Solo Solo) {
		System.out.println("Chegando ao repositorio editarsolo");
		
	}

	@Override
	public void removerSolo(int id) {
		System.out.println("Chegando ao repositorio removerSolo");
		
	}

	@Override
	public boolean existeSolo(int id) {
		System.out.println("Chegando ao repositorio existeSolo");
		return false;
	}

}
