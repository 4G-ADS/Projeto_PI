package com.fafica.projeto_pi.controladora;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.excecoes.InstituicacaoNaoEncontrada;
import com.fafica.projeto_pi.excecoes.Validacao;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.repoditoioIO.RepositorioInstituicaoIO;
import com.fafica.projeto_pi.repoditoioIO.irepositorioIO.IRepositorioInstituicaoIO;
import com.fafica.projeto_pi.repositorioBDR.RepositorioIntituicaoBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioInstituicao;
import com.fafica.projeto_pi.repositorioCollections.RepositorioInstituicaoMap;
import com.fafica.projeto_pi.repositorioCollections.RepositorioInstituicaoSet;
import com.fafica.projeto_pi.repositorioCollections.irepositorioCollections.IRepositorioInstituicaoMap;
import com.fafica.projeto_pi.repositorioCollections.irepositorioCollections.IRepositorioInstituicaoSet;

public class ControladoraInstituicao {

	IRepositorioInstituicao repositorioInstituicao;
	IRepositorioInstituicaoIO repositorioInstituicaoIO;
	IRepositorioInstituicaoMap repositorioInstituicaoMap;
	IRepositorioInstituicaoSet repositorioInstituicaoSet;

	private int banco = Database.TIPOBANCO;

	public ControladoraInstituicao() throws Exception {

		if (banco == 1) {
			this.repositorioInstituicao = new RepositorioIntituicaoBDR();
		} else if (banco == 2) {
			this.repositorioInstituicaoIO = new RepositorioInstituicaoIO();
		} else if (banco == 3) {
			this.repositorioInstituicaoMap = new RepositorioInstituicaoMap();
		} else if (banco == 4) {
			this.repositorioInstituicaoSet = new RepositorioInstituicaoSet();
		}
	}

	public void cadastrarInstituicao(Instituicao instituicao)
			throws SQLException, IOException,
			CampoObritarorioInvalidoException, CPFInvalidoException,
			AdministradorJaCadastradoException {
		System.out
				.println("Panssando pelo cadastrarInstituicao em controladoraInstituicao");

		if (instituicao.getNome().equals("") == true)
			throw new CampoObritarorioInvalidoException(
					"Campo Nome � nulo ou inv�lido.");
		if (instituicao.getCnpj().equals("") == true)
			throw new CampoObritarorioInvalidoException(
					"Campo CPF � nulo ou inv�lido.");
		if (!Validacao.validaCPF(instituicao.getCnpj()))
			throw new CPFInvalidoException(instituicao.getCnpj());
		if (this.repositorioInstituicao.existeInstituicao(instituicao))
			throw new AdministradorJaCadastradoException();

		if (banco == 1) {
			this.repositorioInstituicao.cadastrarInstituicao(instituicao);
		} else if (banco == 2) {
			this.repositorioInstituicaoIO.cadastrarInstituicao(instituicao);
		} else if (banco == 3) {
			this.repositorioInstituicaoMap.cadastrarInstituicao(instituicao);
		} else if (banco == 4) {
			this.repositorioInstituicaoSet.cadastrarInstituicao(instituicao);
		}
	}

	public ArrayList<Instituicao> listarInstituicao() throws SQLException,
			IOException {
		System.out
				.println("Panssando pelo listarInstituicao em controladoraInstituicao");
		ArrayList<Instituicao> lista = null;
		if (banco == 1) {
			lista = this.repositorioInstituicao.listarInstituicao();
		} else if (banco == 2) {
			lista = repositorioInstituicaoIO.listarInstituicao();
		} else if (banco == 3) {
			lista = repositorioInstituicaoMap.listarInstituicao();
		} else if (banco == 4) {
			lista = repositorioInstituicaoSet.listarInstituicao();
		}
		return lista;
	}

	public ArrayList<Instituicao> listarInstituicao(int idReserva)
			throws SQLException {
		System.out
				.println("Panssando pelo listarInstituicao em controladoraInstituicao");
		return this.repositorioInstituicao.listarInstituicao(idReserva);
	}

	public Instituicao procurarInstituicao(int idInstituicao)
			throws SQLException, InstituicacaoNaoEncontrada {
		System.out
				.println("Panssando pelo procurarInstituicao em controladoraInstituicao");
		return this.repositorioInstituicao.procurarInstituicao(idInstituicao);
	}

	public void editarInstituicao(Instituicao instituicao) throws SQLException,
			IOException, InstituicacaoNaoEncontrada {
		System.out
				.println("Panssando pelo editarInstituicao em controladoraInstituicao");

		if (banco == 1) {
			this.repositorioInstituicao.editarInstituicao(instituicao);
		} else if (banco == 2) {
			this.repositorioInstituicaoIO.editarInstituicao(instituicao);
		} else if (banco == 3) {
			this.repositorioInstituicaoMap.editarInstituicao(instituicao);
		} else if (banco == 4) {
			this.repositorioInstituicaoSet.editarInstituicao(instituicao);
		}
	}

	public void removerInstituicao(int idIntituicao) throws SQLException,
			IOException, InstituicacaoNaoEncontrada {
		System.out
				.println("Panssando pelo removerInstituicao em controladoraInstituicao");

		if (banco == 1) {
			this.repositorioInstituicao.removerInstituicao(idIntituicao);
		} else if (banco == 2) {
			this.repositorioInstituicaoIO.removerInstituicao(idIntituicao);
		} else if (banco == 3) {
			this.repositorioInstituicaoMap.removerInstituicao(idIntituicao);
		} else if (banco == 4) {
			this.repositorioInstituicaoSet.removerInstituicao(idIntituicao);
		}

	}

}
