package com.fafica.projeto_pi.controladora;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.Validacao;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.AdministradorNaoEncontradoException;
import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.repoditoioIO.RepositorioAdministradorIO;
import com.fafica.projeto_pi.repoditoioIO.irepositorioIO.IRepositorioAdminstradorIO;
import com.fafica.projeto_pi.repositorioBDR.RepositorioAdministradorBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioAdminstrador;
import com.fafica.projeto_pi.repositorioCollections.RepositorioAdministradorMap;
import com.fafica.projeto_pi.repositorioCollections.RepositorioAdministradorSet;
import com.fafica.projeto_pi.repositorioCollections.irepositorioCollections.IRepositorioAdministradorMap;
import com.fafica.projeto_pi.repositorioCollections.irepositorioCollections.IRepositorioAdministradorSet;

public class ControladorAdministrador {

	IRepositorioAdminstrador repositorioAdminstrador;
	IRepositorioAdminstradorIO repositorioAdministradorIO;
	IRepositorioAdministradorMap repositorioAdministradorMAP;
	IRepositorioAdministradorSet repositorioAdministradorSET;

	private int banco = Database.TIPOBANCO;

	public ControladorAdministrador() throws Exception {

		if (banco == 1) {
			this.repositorioAdminstrador = new RepositorioAdministradorBDR(
					Database.MYSQL);
		} else if (banco == 2) {
			this.repositorioAdministradorIO = new RepositorioAdministradorIO();
		} else if (banco == 3) {
			this.repositorioAdministradorMAP = new RepositorioAdministradorMap();
		} else if (banco == 4) {
			this.repositorioAdministradorSET = new RepositorioAdministradorSet();
		}
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
		if (!Validacao.validaCPF(administrador.getCpf())) throw new CPFInvalidoException(administrador.getCpf());
		if (this.repositorioAdminstrador.existe(administrador))	throw new AdministradorJaCadastradoException();
		

		if (banco == 1) {
			this.repositorioAdminstrador.cadastrarAdministrador(administrador);
		} else if (banco == 2) {
			this.repositorioAdministradorIO
					.cadastrarAdministrador(administrador);
		} else if (banco == 3) {
			this.repositorioAdministradorMAP
					.cadastrarAdministrador(administrador);
		} else if (banco == 4) {
			this.repositorioAdministradorSET
					.cadastrarAdministrador(administrador);
		}
	}

	public ArrayList<Administrador> listarAdministrardor() throws SQLException,
			IOException {
		System.out.println("Passando pela controladoraUsuario listarUsuario");
		ArrayList<Administrador> lista = null;
		if (banco == 1) {
			lista = this.repositorioAdminstrador.listarAdministrador();
		} else if (banco == 2) {
			lista = this.repositorioAdministradorIO.listarAdministrador();
		} else if (banco == 3) {
			lista = this.repositorioAdministradorMAP.listarAdministrador();
		} else if (banco == 4) {
			lista = this.repositorioAdministradorSET.listarAdministrador();
		}
		return lista;
	}

	public void editarAdministrardor(Administrador administrador)
			throws SQLException, IOException,
			AdministradorNaoEncontradoException {
		System.out.println("Passando pela controladoraUsuario editarUsuario");

		if (banco == 1) {
			this.repositorioAdminstrador.editarAdministrador(administrador);
		} else if (banco == 2) {
			this.repositorioAdministradorIO.editarAdministrador(administrador);
		} else if (banco == 3) {
			this.repositorioAdministradorMAP.editarAdministrador(administrador);
		} else if (banco == 4) {
			this.repositorioAdministradorSET.editarAdministrador(administrador);
		}

	}

	public void removerAdministrardor(int idAdministrador) throws SQLException,
			IOException, AdministradorNaoEncontradoException {
		System.out.println("Passando pela controladoraUsuario removerUsuario");

		if (banco == 1) {

			this.repositorioAdminstrador.removerAdministrador(idAdministrador);
		} else if (banco == 2) {
			this.repositorioAdministradorIO
					.removerAdministrador(idAdministrador);
		} else if (banco == 3) {
			this.repositorioAdministradorMAP
					.removerAdministrador(idAdministrador);
		} else if (banco == 4) {
			this.repositorioAdministradorSET
					.removerAdministrador(idAdministrador);
		}
	}

	public void procurarAdministrardor(int idAdministrador)
			throws SQLException, IOException,
			AdministradorNaoEncontradoException {
		System.out.println("Passando pela controladoraUsuario procurarUsuario");

		if (banco == 1) {
			this.repositorioAdminstrador.procurarAdministrador(idAdministrador);
		} else if (banco == 2) {
			this.repositorioAdministradorIO
					.procurarAdministrador(idAdministrador);
		} else if (banco == 3) {
			this.repositorioAdministradorMAP
					.procurarAdministrador(idAdministrador);
		} else if (banco == 4) {
			this.repositorioAdministradorSET
					.procurarAdministrador(idAdministrador);
		}
	}

}
