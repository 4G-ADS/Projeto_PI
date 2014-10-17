package com.fafica.projeto_pi.controladora;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.repositorio.RepositorioIntituicao;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioInstituicao;

public class ControladoraInstituicao {
	
	private IRepositorioInstituicao repositorioInstituicao;
	
	public ControladoraInstituicao(){
		
		this.repositorioInstituicao = new RepositorioIntituicao();
	}

	
	public void cadastrarInstituicao(Instituicao instituicao){
		System.out.println("Panssando pelo cadastrarInstituicao em controladoraInstituicao");
		this.repositorioInstituicao.cadastrarInstituicao(instituicao);
	}
	
	public ArrayList<Instituicao> listarIntituicao(){
		System.out.println("Panssando pelo listarInstituicao em controladoraInstituicao");
		return this.repositorioInstituicao.listarInstituicao();		
	}
	
	public Instituicao procurarInstituicao(int idInstituicao){
		System.out.println("Panssando pelo procurarInstituicao em controladoraInstituicao");
		return this.repositorioInstituicao.procurarInstituicao(idInstituicao);
	}
	
	public void editarInstituicao(Instituicao instituicao){
		System.out.println("Panssando pelo editarInstituicao em controladoraInstituicao");
		this.repositorioInstituicao.editarInstituicao(instituicao);
	}
	
	public void removerInstituicao(int idIntituicao){
		System.out.println("Panssando pelo removerInstituicao em controladoraInstituicao");
		this.repositorioInstituicao.removerInstituicao(idIntituicao);
	}
	
	public boolean existeInstituicao(int idInstituicao){
		System.out.println("Panssando pelo existeInstituicao em controladoraInstituicao");
		return this.repositorioInstituicao.existeInstituicao(idInstituicao);
	}
	
	
}
