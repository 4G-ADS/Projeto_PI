package com.fafica.projeto_pi.controladora;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.AdministradorNaoEncontradoException;
import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.repositorioBDR.RepositorioAdministradorBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioAdminstrador;


public class ControladorAdministrador {

	IRepositorioAdminstrador repositorioAdminstrador;



	public ControladorAdministrador() throws Exception {

		
			this.repositorioAdminstrador = new RepositorioAdministradorBDR(
					Database.MYSQL);

	}

	public void cadastrarAdministrardor(Administrador administrador)
			throws SQLException, IOException,
			AdministradorJaCadastradoException,
			CampoObritarorioInvalidoException, CPFInvalidoException {
		System.out
				.println("Passando pela controladoraUsuario CadastrarUsuarioBDR");
		System.out.println(administrador);
		
		if (administrador.getLogin().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Login � nulo ou inv�lido.");
		if (administrador.getNome().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Nome � nulo ou inv�lido.");
		if (administrador.getCpf().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo CPF � nulo ou inv�lido.");
		if (administrador.getSenha() ==0)	throw new CampoObritarorioInvalidoException("Campo Senha � nulo ou inv�lido.");

			this.repositorioAdminstrador.cadastrarAdministrador(administrador);

	}

	public ArrayList<Administrador> listarAdministrardor() throws SQLException,
			IOException {
		System.out.println("Passando pela controladoraUsuario listarUsuario");
		ArrayList<Administrador> lista = null;

			lista = this.repositorioAdminstrador.listarAdministrador();

		return lista;
	}

	public void editarAdministrardor(Administrador administrador)
			throws SQLException, IOException,
			AdministradorNaoEncontradoException {
		System.out.println("Passando pela controladoraUsuario editarUsuario");

			this.repositorioAdminstrador.editarAdministrador(administrador);


	}

	public void removerAdministrardor(int idAdministrador) throws SQLException,
			IOException, AdministradorNaoEncontradoException {
		System.out.println("Passando pela controladoraUsuario removerUsuario");

			this.repositorioAdminstrador.removerAdministrador(idAdministrador);

	}

	public Administrador procurarAdministrardor(int idAdministrador)
			throws SQLException, IOException,
			AdministradorNaoEncontradoException {
		System.out.println("Passando pela controladoraUsuario procurarUsuario");
		Administrador adm = null;
		adm =	this.repositorioAdminstrador.procurarAdministrador(idAdministrador);

		return adm;
	}

}
