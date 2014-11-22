package com.fafica.projeto_pi.repositorioCollections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.repositorioCollections.irepositorioCollections.IRepositorioAdministradorMap;

public class RepositorioAdministradorMap implements IRepositorioAdministradorMap{

	private Map<Integer, Administrador> mapaAdmisnitrador = new LinkedHashMap <Integer, Administrador>();
	private static int contador;
	
	
	
	public void cadastrarAdministrador(Administrador adm){
		contador++;
		adm.setId(contador);
		mapaAdmisnitrador.put(contador, adm);
	}


	@Override
	public void editarAdministrador(Administrador administrador) {
		for (int i : mapaAdmisnitrador.keySet()) {
			Administrador adm = mapaAdmisnitrador.get(i);
			if(adm.getId() == administrador.getId()){
				adm = administrador;
				break;
			}
		}
		
	}


	@Override
	public void removerAdministrador(int idAdministrador) {
		for (int i : mapaAdmisnitrador.keySet()) {
			Administrador adm = mapaAdmisnitrador.get(i);
			if(adm.getId() == idAdministrador){
				mapaAdmisnitrador.remove(adm);
				break;
			}
		}
		
	}


	@Override
	public Administrador procurarAdministrador(int idAdministrador) {
		Administrador administrador = null;
		for (int i : mapaAdmisnitrador.keySet()) {
			Administrador adm = mapaAdmisnitrador.get(i);
			if(adm.getId() == idAdministrador){
				administrador =	adm ;
				break;
			}
		}
		
	
		return administrador;
	}


	@Override
	public ArrayList<Administrador> listarAdministrador() {
ArrayList<Administrador> listaProvisoria = new ArrayList<Administrador>();
		
		for (int i : mapaAdmisnitrador.keySet()) {
			listaProvisoria.add(mapaAdmisnitrador.get(i));
		}
		
		return listaProvisoria;
	}
	
}
