package com.fafica.projeto_pi.controladora;

import com.fafica.projeto_pi.modelos.Usuario;
import com.fafica.projeto_pi.repositorio.RepositorioUsuario;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioUsuario;

public class ControladoraUsuario {

	IRepositorioUsuario repositorioUsuario;
	
	public ControladoraUsuario(){
		this.repositorioUsuario = new RepositorioUsuario();
	}
	
	public void cadastrarUsuario(Usuario usuario){
		System.out.println("Passando pela controladoraUsuario CadastrarUsuario");
		this.repositorioUsuario.cadastrarUsuario(usuario);
	}

	public void editarUsuario(Usuario usuario){
		System.out.println("Passando pela controladoraUsuario editarUsuario");
		this.repositorioUsuario.editarUsuario(usuario);
	}
	
	public void removerUsuario(int idUsuario){
		System.out.println("Passando pela controladoraUsuario removerUsuario");
		this.repositorioUsuario.removerUsuario(idUsuario);
	}
	
	public void procurarUsuario(int idUsuario){
		System.out.println("Passando pela controladoraUsuario procurarUsuario");
		this.repositorioUsuario.removerUsuario(idUsuario);
	}
	
}
