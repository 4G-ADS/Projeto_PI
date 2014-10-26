package com.fafica.projeto_pi.repositorio.irepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Usuario;

public interface IRepositorioUsuario {
	
	public void cadastrarUsuario(Usuario usuario) throws SQLException;
	public void editarUsuario(Usuario usuario);
	public void removerUsuario(int idUsuario);
	public void procurarUsuario(int idUsuario);
	public ArrayList<Usuario> listarUsuario() throws SQLException;

}
