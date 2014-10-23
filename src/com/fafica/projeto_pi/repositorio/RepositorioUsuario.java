package com.fafica.projeto_pi.repositorio;

import com.fafica.projeto_pi.modelos.Usuario;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioUsuario;

public class RepositorioUsuario implements IRepositorioUsuario{

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		System.out.println("chegando ao repositorioUsuario cadastrarUsuario");
		
	}

	@Override
	public void editarUsuario(Usuario usuario) {
		System.out.println("chegando ao repositorioUsuario editarUsuario");
		
	}

	@Override
	public void removerUsuario(int idUsuario) {
		System.out.println("chegando ao repositorio removerUsuario");
		
	}

	@Override
	public void procurarUsuario(int idUsuario) {
		System.out.println("Chegando ao repositorio procurarUsuario");
		
	}

	
	
}
