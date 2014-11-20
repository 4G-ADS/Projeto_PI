package com.fafica.projeto_pi.repositorioCollections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.repositorioCollections.irepositorioCollections.IRepositorioPesquisadorMap;

public class RepositorioPesquisadorMap implements IRepositorioPesquisadorMap{

	private Map<Integer, Pesquisador> mapaPesquisador = new LinkedHashMap <Integer, Pesquisador>();
	private static int contador;
	
	@Override
	public void cadastrarPesquisadores(Pesquisador pesquisador) {
		contador++;
		pesquisador.setIdPesquisador(contador);
		mapaPesquisador.put(contador, pesquisador);
		
	}

	@Override
	public ArrayList<Pesquisador> listarPesquisadores() {
ArrayList<Pesquisador> listaProvisoria = new ArrayList<Pesquisador>();
		
		for (int i : mapaPesquisador.keySet()) {
			listaProvisoria.add(mapaPesquisador.get(i));
		}
		
		return listaProvisoria;
	}

	@Override
	public Pesquisador procurarPesquisadores(int idPesquisador) {

		Pesquisador Pesquisador = null;
		for (int i : mapaPesquisador.keySet()) {
			Pesquisador PesquisadorProvisorio = mapaPesquisador.get(i);
			if(PesquisadorProvisorio.getIdPesquisador() == idPesquisador){
				Pesquisador =	PesquisadorProvisorio;
				break;
			}
		}
		
	
		return Pesquisador;
		}

	@Override
	public void editarPesquisadores(Pesquisador pesquisador) {
		for (int i : mapaPesquisador.keySet()) {
			Pesquisador pesquisadorProvisorio = mapaPesquisador.get(i);
			if(pesquisadorProvisorio.getIdPesquisador() == pesquisador.getIdPesquisador()){
				pesquisadorProvisorio = pesquisador;
				break;
			}
		}
		
	}

	@Override
	public void removerPesquisadores(int idPesquisador) {
		for (int i : mapaPesquisador.keySet()) {
			Pesquisador pesquisador = mapaPesquisador.get(i);
			if(pesquisador.getIdPesquisador()== idPesquisador){
				mapaPesquisador.remove(pesquisador);
				break;
			}
		}
		
	
		// TODO Auto-generated method stub
		
	}

}
