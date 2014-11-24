package com.fafica.projeto_pi.repositorioBDR.irepositorioBDR;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.SoloNaoEncontradorException;
import com.fafica.projeto_pi.modelos.Solo;

public interface IRepositorioSolo {

	public void cadastrarSolo(Solo solo) throws SQLException;
	public Solo procurarSolo(int idSolo) throws SQLException,SoloNaoEncontradorException;
	public ArrayList<Solo> listarSolo() throws SQLException;
	public ArrayList<Solo> listarSolo(int idReserva) throws SQLException;
	public void editarSolo(Solo Solo) throws SQLException,SoloNaoEncontradorException;
	public void removerSolo(int idSolo) throws SQLException,SoloNaoEncontradorException;
}
