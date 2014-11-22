package com.fafica.projeto_pi.repoditoioIO.irepositorioIO;

import java.io.IOException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Administrador;

public interface IRepositorioAdminstradorIO {
	
	public void cadastrarAdministrador(Administrador administrador) throws IOException;
	public void editarAdministrador(Administrador administrador) throws IOException;
	public void removerAdministrador(int idAdministrador) throws IOException;
	public Administrador procurarAdministrador(int idAdministrador) throws IOException;
	public ArrayList<Administrador> listarAdministrador() throws IOException;

}
