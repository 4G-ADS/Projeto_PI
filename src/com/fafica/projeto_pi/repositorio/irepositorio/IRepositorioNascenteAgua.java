package com.fafica.projeto_pi.repositorio.irepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.NascenteAgua;

public interface IRepositorioNascenteAgua {

	public void cadastrarAgua(NascenteAgua agua) throws SQLException;
	public NascenteAgua procurarAgua(int idAgua);
	public ArrayList<NascenteAgua> listarNascenteAgua() throws SQLException;
	public void removerAgua(int idAgua);
	public void editarAgua(NascenteAgua agua);
	public boolean existeAgua(int idAgua);
	
}
