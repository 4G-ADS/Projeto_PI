package com.fafica.projeto_pi.repositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPesquisador;

public class RepositorioPesquisador implements IRepositorioPesquisador{

	@Override
	public void cadastrarPesquisadores(Pesquisador pesquisador) {
		System.out.println("Chegando ao repositorio cadastarPesquisadores");
		
	}

	@Override
	public ArrayList<Pesquisador> listarPesquisadores() {
		System.out.println("Chegando ao repositorio listarPesquisadores");
		return null;
		
	}

	@Override
	public Pesquisador procurarPesquisadores(int id) {
		System.out.println("Chegando ao repositorio procurarPesquisadores");
		return null;
	}

	@Override
	public void editarPesquisadores(Pesquisador pesquisador) {
		System.out.println("Chegando ao repositorio editarPesiquisadores");
		
	}

	@Override
	public void removerPesquisadores(int id) {
		System.out.println("Chegando ao repositorio removerPesquisadores");
		
	}

	@Override
	public boolean existePesquisadores(int id) {
		System.out.println("Chegando ao repositorio existePesquisadores");
		return false;
	}

}
