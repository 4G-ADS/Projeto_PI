package com.fafica.projeto_pi.repositorioCollections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.repositorioCollections.irepositorioCollections.IRepositorioPesquisadorSet;

public class RepositorioPesquisadorSet implements IRepositorioPesquisadorSet{

	private static Set <Pesquisador> setListaPesquisador = new HashSet<Pesquisador>();
	private static int contador;
	
	@Override
	public void cadastrarPesquisadores(Pesquisador pesquisador) {
		pesquisador.setIdPesquisador(contador);
		setListaPesquisador.add(pesquisador);
	
		
		
	}

	@Override
	public ArrayList<Pesquisador> listarPesquisadores() {
		ArrayList<Pesquisador> lista = new ArrayList<Pesquisador>();
		for (Pesquisador pesquisador : setListaPesquisador) {
			lista.add(pesquisador);
		}
		return lista;
	}

	@Override
	public Pesquisador procurarPesquisadores(int idPesquisador) {
		Pesquisador pesquisador = null;
		for (Pesquisador pesquisadorProvisorio : setListaPesquisador) {
			if(pesquisadorProvisorio.getIdPesquisador() == idPesquisador){
				pesquisador = pesquisadorProvisorio;
			}
		}
		return pesquisador;
	}

	@Override
	public void editarPesquisadores(Pesquisador pesquisador) {
		for (Pesquisador pesquisadorProvisorio : setListaPesquisador) {
			if(pesquisador.getIdPesquisador() == pesquisadorProvisorio.getIdPesquisador()){
				pesquisadorProvisorio = pesquisador;
				break;
			}
		}
		
	}

	@Override
	public void removerPesquisadores(int idPesquisador) {
		for (Pesquisador pesquisador : setListaPesquisador) {
			if(pesquisador.getIdPesquisador() == idPesquisador){
				setListaPesquisador.remove(pesquisador);
			}
		}
		
	}

}
