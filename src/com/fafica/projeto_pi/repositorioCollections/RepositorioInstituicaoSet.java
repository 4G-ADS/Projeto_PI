package com.fafica.projeto_pi.repositorioCollections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.repositorioCollections.irepositorioCollections.IRepositorioInstituicaoSet;

public class RepositorioInstituicaoSet implements IRepositorioInstituicaoSet{

	private static Set <Instituicao> setListaInstituicao = new HashSet<Instituicao>();
	private static int contador;
	
	@Override
	public void cadastrarInstituicao(Instituicao instituicao) {
		instituicao.setIdInstituicao(contador);
		setListaInstituicao.add(instituicao);
	}
	@Override
	public ArrayList<Instituicao> listarInstituicao() {
		ArrayList<Instituicao> lista = new ArrayList<Instituicao>();
		for (Instituicao instituicao : setListaInstituicao) {
			lista.add(instituicao);
		}
		return lista;
	}

	@Override
	public Instituicao procurarInstituicao(int idInstituicao) {
		Instituicao instituicao = null;
		for (Instituicao instituicaoProvisorio : setListaInstituicao) {
			if(instituicaoProvisorio.getIdInstituicao() == idInstituicao){
				instituicao = instituicaoProvisorio;
			}
		}
		return instituicao;
	}

	@Override
	public void editarInstituicao(Instituicao instituicao) {
		for (Instituicao instituicaoProvisorio : setListaInstituicao) {
			if(instituicao.getIdInstituicao() == instituicaoProvisorio.getIdInstituicao()){
				instituicaoProvisorio = instituicao;
				break;
			}
		}
		
	}

	@Override
	public void removerInstituicao(int idInstituicao) {
		for (Instituicao instituicao : setListaInstituicao) {
			if(instituicao.getIdInstituicao() == idInstituicao){
				setListaInstituicao.remove(instituicao);
			}
		}
		
	}

}
