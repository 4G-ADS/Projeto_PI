package com.fafica.projeto_pi.repositorio.irepositorio;

import com.fafica.projeto_pi.modelos.Usuario;

public interface IRepositorioUsuario {
	
	public void cadastrarUsuario(Usuario usuario);
	public void editarUsuario(Usuario usuario);
	public void removerUsuario(int idUsuario);
	public void procurarUsuario(int idUsuario);

}
