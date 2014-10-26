package com.fafica.projeto_pi.repositorio.irepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Instituicao;

public interface IRepositorioInstituicao {

		public void cadastrarInstituicao(Instituicao instituicao) throws SQLException;
		public ArrayList<Instituicao> listarInstituicao() throws SQLException;
		public Instituicao procurarInstituicao(int idInstituicao);
		public void editarInstituicao(Instituicao instituicao);
		public void removerInstituicao(int idInstituicao);
		public boolean existeInstituicao(int idInstituicao);
	
}
