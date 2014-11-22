package com.fafica.projeto_pi.repositorioCollections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.repositorioCollections.irepositorioCollections.IRepositorioInstituicaoMap;

public class RepositorioInstituicaoMap implements IRepositorioInstituicaoMap{

	private Map<Integer, Instituicao> mapaInstituicao = new LinkedHashMap <Integer, Instituicao>();
	private static int contador;
	@Override
	public void cadastrarInstituicao(Instituicao instituicao) {
		contador++;
		instituicao.setIdInstituicao(contador);
		mapaInstituicao.put(contador, instituicao);
		
	}

	@Override
	public ArrayList<Instituicao> listarInstituicao() {
ArrayList<Instituicao> listaProvisoria = new ArrayList<Instituicao>();
		
		for (int i : mapaInstituicao.keySet()) {
			listaProvisoria.add(mapaInstituicao.get(i));
		}
		
		return listaProvisoria;
	}

	@Override
	public Instituicao procurarInstituicao(int idInstituicao) {

		Instituicao instituicao = null;
		for (int i : mapaInstituicao.keySet()) {
			Instituicao instituicaoProvisoria = mapaInstituicao.get(i);
			if(instituicaoProvisoria.getIdInstituicao() == idInstituicao){
				instituicao =	instituicaoProvisoria;
				break;
			}
		}
		
	
		return instituicao;
		}

	@Override
	public void editarInstituicao(Instituicao instituicao) {
		for (int i : mapaInstituicao.keySet()) {
			Instituicao instituicaoProvisorio = mapaInstituicao.get(i);
			if(instituicaoProvisorio.getIdInstituicao() == instituicao.getIdInstituicao()){
				instituicaoProvisorio = instituicao;
				break;
			}
		}
		
	}

	@Override
	public void removerInstituicao(int idInstituicao) {
		for (int i : mapaInstituicao.keySet()) {
			Instituicao instituicao = mapaInstituicao.get(i);
			if(instituicao.getIdInstituicao() == idInstituicao){
				mapaInstituicao.remove(instituicao);
				break;
			}
		}
		
	}

}
