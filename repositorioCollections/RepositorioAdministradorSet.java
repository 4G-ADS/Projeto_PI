package com.fafica.projeto_pi.repositorioCollections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.repositorioCollections.irepositorioCollections.IRepositorioAdministradorSet;

public class RepositorioAdministradorSet implements IRepositorioAdministradorSet {

	private static Set <Administrador> setAdministrador = new HashSet<Administrador>();
	private static int contador;
	
	@Override
	public void cadastrarAdministrador(Administrador administrador) {
		administrador.setId(contador);
		setAdministrador.add(administrador);
	}

	@Override
	public void editarAdministrador(Administrador administrador) {
		for (Administrador administradorProvisorio : setAdministrador) {
			if(administrador.getId() == administradorProvisorio.getId()){
				administradorProvisorio = administrador;
				break;
			}
		}
		
	}

	@Override
	public void removerAdministrador(int idAdministrador) {
		for (Administrador administrador : setAdministrador) {
			if(administrador.getId() == idAdministrador){
				setAdministrador.remove(administrador);
			}
		}
		
	}

	@Override
	public Administrador procurarAdministrador(int idAdministrador) {
		Administrador administrador = null;
		for (Administrador administradorProvisorio : setAdministrador) {
			if(administradorProvisorio.getId() == idAdministrador){
				administrador = administradorProvisorio;
			}
		}
		return administrador;
	}

	@Override
	public ArrayList<Administrador> listarAdministrador() {
		ArrayList<Administrador> lista = new ArrayList<Administrador>();
		for (Administrador administrador : setAdministrador) {
			lista.add(administrador);
		}
		return lista;
	}

}
