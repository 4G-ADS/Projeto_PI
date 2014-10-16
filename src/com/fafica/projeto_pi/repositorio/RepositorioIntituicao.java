package com.fafica.projeto_pi.repositorio;

import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioInstituicao;

public class RepositorioIntituicao implements IRepositorioInstituicao{

	@Override
	public void cadastrarInstituicao(Instituicao instituicao) {
		System.out.println("Chegando ao repositorio cadastrarIntituicao");
		
	}

	@Override
	public void listarInstituicao() {
		System.out.println("Chegando ao repositorio listarInstituicao");
		
	}

	@Override
	public Instituicao procurarInstituicao(int id) {
		System.out.println("Chegando ao repositorio procurarInstituicao");
		return null;
	}

	@Override
	public void editarInstituicao(Instituicao instituicao) {
		System.out.println("Chegando ao repositorio editarInstituicao");
		
	}

	@Override
	public void removerInstituicao(int id) {
		System.out.println("Chegando ao repositorio removerIntituicao");
		
	}

	@Override
	public boolean existeInstituicao(int id) {
		System.out.println("Chegando ao repositorio exibirIntituicao");
		return false;
	}

}
