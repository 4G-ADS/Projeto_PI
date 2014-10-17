package com.fafica.projeto_pi.repositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioInstituicao;

public class RepositorioIntituicao implements IRepositorioInstituicao{

	@Override
	public void cadastrarInstituicao(Instituicao instituicao) {
		System.out.println("Chegando ao repositorio cadastrarIntituicao");
		
	}

	@Override
	public ArrayList<Instituicao> listarInstituicao() {
		System.out.println("Chegando ao repositorio listarInstituicao");
		return null;
		
	}

	@Override
	public Instituicao procurarInstituicao(int idInstiruicao) {
		System.out.println("Chegando ao repositorio procurarInstituicao");
		return null;
	}

	@Override
	public void editarInstituicao(Instituicao instituicao) {
		System.out.println("Chegando ao repositorio editarInstituicao");
		
	}

	@Override
	public void removerInstituicao(int idInstituicao) {
		System.out.println("Chegando ao repositorio removerIntituicao");
		
	}

	@Override
	public boolean existeInstituicao(int idInstituicao) {
		System.out.println("Chegando ao repositorio exibirIntituicao");
		return false;
	}

}
