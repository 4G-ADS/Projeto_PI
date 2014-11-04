package com.fafica.projeto_pi.repositorio.irepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Solo;

public interface IRepositorioSolo {

	public void cadastrarSolo(Solo solo) throws SQLException;
	public Solo procurarSolo(int idSolo) throws SQLException;
	public ArrayList<Solo> listarSolo() throws SQLException;
	public ArrayList<Solo> listarSolo(int idReserva) throws SQLException;
	public void editarSolo(Solo Solo) throws SQLException;
	public void removerSolo(int idSolo) throws SQLException;
	public boolean existeSolo(int idSolo);
}
