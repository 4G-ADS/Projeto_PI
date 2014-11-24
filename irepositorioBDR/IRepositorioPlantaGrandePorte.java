package com.fafica.projeto_pi.repositorioBDR.irepositorioBDR;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.PlantaNaoEncontradaException;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;

public interface IRepositorioPlantaGrandePorte {

	public void cadastrarPlantaGrandePorte(PlantaGrandePorte plantagrande) throws SQLException;
	public ArrayList<PlantaGrandePorte> listarPlantaGrandePorte() throws SQLException;
	public ArrayList<PlantaGrandePorte> listarPlantaGrandePorte(int idReserva) throws SQLException;
	public void removerPlantaGrandePorte(int idPlantaGrande) throws SQLException,PlantaNaoEncontradaException;
}
