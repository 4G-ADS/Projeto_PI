package com.fafica.projeto_pi.repositorioCollections.irepositorioCollections;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Instituicao;

public interface IRepositorioInstituicaoSet {

	public void cadastrarInstituicao(Instituicao instituicao);
	public ArrayList<Instituicao> listarInstituicao();
	public Instituicao procurarInstituicao(int idInstituicao);
	public void editarInstituicao(Instituicao instituicao);
	public void removerInstituicao(int idInstituicao);
}
