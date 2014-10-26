package com.fafica.projeto_pi.repositorio.irepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Solo;

public interface IRepositorioSolo {

	public void cadastrarSolo(Solo solo) throws SQLException;
	public Solo procurarSolo(int idSolo);
	public ArrayList<Solo> listarSolo() throws SQLException;
	public void editarSolo(Solo Solo);
	public void removerSolo(int idSolo);
	public boolean existeSolo(int idSolo);
}
