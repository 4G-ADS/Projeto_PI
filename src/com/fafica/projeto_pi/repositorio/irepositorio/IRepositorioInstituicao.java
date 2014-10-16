package com.fafica.projeto_pi.repositorio.irepositorio;

import com.fafica.projeto_pi.modelos.Instituicao;

public interface IRepositorioInstituicao {

		public void cadastrarInstituicao(Instituicao instituicao);
		public void listarInstituicao();
		public Instituicao procurarInstituicao(int id);
		public void editarInstituicao(Instituicao instituicao);
		public void removerInstituicao(int id);
		public boolean existeInstituicao(int id);
	
}
