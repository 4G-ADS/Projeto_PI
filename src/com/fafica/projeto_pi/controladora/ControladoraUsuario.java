package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Usuario;
import com.fafica.projeto_pi.repositorio.RepositorioUsuario;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioUsuario;

public class ControladoraUsuario {

	IRepositorioUsuario repositorioUsuario;
	
	public ControladoraUsuario() throws Exception{
		this.repositorioUsuario = new RepositorioUsuario();
	}
	
	public void cadastrarUsuario(Usuario usuario) throws SQLException{
		System.out.println("Passando pela controladoraUsuario CadastrarUsuario");
		this.repositorioUsuario.cadastrarUsuario(usuario);
	}

	public ArrayList<Usuario> listarUsuarios() throws SQLException{
		System.out.println("Passando pela controladoraUsuario listarUsuario");
		return this.repositorioUsuario.listarUsuario();
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
