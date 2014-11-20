package com.fafica.projeto_pi.repositorioBDR.irepositorioBDR;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.NascenteAgua;

public interface IRepositorioNascenteAgua {

	public void cadastrarAgua(NascenteAgua agua) throws SQLException;
	public NascenteAgua procurarAgua(int idAgua) throws SQLException;
	public ArrayList<NascenteAgua> listarNascenteAgua() throws SQLException;
	public ArrayList<NascenteAgua> listarNascenteAgua(int idReserva) throws SQLException;
	public void removerAgua(int idAgua) throws SQLException;
	public void editarAgua(NascenteAgua agua) throws SQLException;
	public boolean existeAgua(int idAgua) throws SQLException;
	
}
