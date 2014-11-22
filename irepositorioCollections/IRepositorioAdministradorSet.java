package com.fafica.projeto_pi.repositorioCollections.irepositorioCollections;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Administrador;

public interface IRepositorioAdministradorSet {

	public void cadastrarAdministrador(Administrador administrador);
	public void editarAdministrador(Administrador administrador);
	public void removerAdministrador(int idAdministrador);
	public Administrador procurarAdministrador(int idAdministrador);
	public ArrayList<Administrador> listarAdministrador() ;
}
