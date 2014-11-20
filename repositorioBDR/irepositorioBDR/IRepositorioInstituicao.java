package com.fafica.projeto_pi.repositorioBDR.irepositorioBDR;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Instituicao;

public interface IRepositorioInstituicao {

		public void cadastrarInstituicao(Instituicao instituicao) throws  SQLException;
		public ArrayList<Instituicao> listarInstituicao() throws   SQLException;
		public Instituicao procurarInstituicao(int idInstituicao) throws   SQLException;
		public void editarInstituicao(Instituicao instituicao) throws   SQLException;
		public void removerInstituicao(int idInstituicao) throws SQLException;
		public boolean existeInstituicao(int idInstituicao);
		public ArrayList<Instituicao> listarInstituicao(int idReserva) throws SQLException;
		public boolean existe(int idInstituicao) throws SQLException;
		
		
}
