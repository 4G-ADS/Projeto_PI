package com.fafica.projeto_pi.controladora;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.excecoes.InstituicacaoNaoEncontrada;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.repositorioBDR.RepositorioIntituicaoBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioInstituicao;

public class ControladoraInstituicao {

	IRepositorioInstituicao repositorioInstituicao;


	public ControladoraInstituicao() throws Exception {

			this.repositorioInstituicao = new RepositorioIntituicaoBDR();

	}

	public void cadastrarInstituicao(Instituicao instituicao)
			throws SQLException, IOException,
			CampoObritarorioInvalidoException, CPFInvalidoException,
			AdministradorJaCadastradoException {
		System.out
				.println("Panssando pelo cadastrarInstituicao em controladoraInstituicao");

			this.repositorioInstituicao.cadastrarInstituicao(instituicao);

	}

	public ArrayList<Instituicao> listarInstituicao() throws SQLException,
			IOException {
		System.out
				.println("Panssando pelo listarInstituicao em controladoraInstituicao");
		ArrayList<Instituicao> lista = null;

			lista = this.repositorioInstituicao.listarInstituicao();

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

			this.repositorioInstituicao.editarInstituicao(instituicao);

	}

	public void removerInstituicao(int idIntituicao) throws SQLException,
			IOException, InstituicacaoNaoEncontrada {
		System.out
				.println("Panssando pelo removerInstituicao em controladoraInstituicao");

			this.repositorioInstituicao.removerInstituicao(idIntituicao);


	}

}
