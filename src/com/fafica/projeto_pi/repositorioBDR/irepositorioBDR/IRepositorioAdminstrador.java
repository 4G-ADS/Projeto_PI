package com.fafica.projeto_pi.repositorioBDR.irepositorioBDR;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.AdministradorNaoEncontradoException;
import com.fafica.projeto_pi.modelos.Administrador;

public interface IRepositorioAdminstrador {
	
	public void cadastrarAdministrador(Administrador administrador) throws SQLException;
	public void editarAdministrador(Administrador administrador) throws SQLException, AdministradorNaoEncontradoException;
	public void removerAdministrador(int idAdministrador) throws SQLException, AdministradorNaoEncontradoException;
	public Administrador procurarAdministrador(int idAdministrador) throws SQLException, AdministradorNaoEncontradoException;
	public ArrayList<Administrador> listarAdministrador() throws SQLException;
	public boolean existe(Administrador adm) throws SQLException;

}
