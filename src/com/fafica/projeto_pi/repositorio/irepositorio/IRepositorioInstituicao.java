package com.fafica.projeto_pi.repositorio.irepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Instituicao;

public interface IRepositorioInstituicao {

		public void cadastrarInstituicao(Instituicao instituicao) throws SQLException;
		public ArrayList<Instituicao> listarInstituicao() throws SQLException;
		public ArrayList<Instituicao> listarInstituicao(int idReserva) throws SQLException;
		public Instituicao procurarInstituicao(int idInstituicao) throws SQLException;
		public void editarInstituicao(Instituicao instituicao) throws SQLException;
		public void removerInstituicao(int idInstituicao) throws SQLException;
		public boolean existeInstituicao(int idInstituicao);
		
		
		
}
