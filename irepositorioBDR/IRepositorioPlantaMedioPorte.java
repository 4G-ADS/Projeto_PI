package com.fafica.projeto_pi.repositorioBDR.irepositorioBDR;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.PlantaNaoEncontradaException;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;

public interface IRepositorioPlantaMedioPorte {

	public void cadastrarPlantaMedioPorte(PlantaMedioPorte plantamedia) throws SQLException;
	public ArrayList<PlantaMedioPorte> listarPlantaMedioPorte() throws SQLException;
	public ArrayList<PlantaMedioPorte> listarPlantaMedioPorte(int idReserva) throws SQLException;
	public PlantaMedioPorte procurarPlantaMedia(int idPlantaMedia) throws SQLException,PlantaNaoEncontradaException;
	public void removerPlantaMedioPorte(int idPlantaMedia) throws SQLException,PlantaNaoEncontradaException;
	public boolean existePlantaMedioPorte(PlantaMedioPorte plantamedia) throws SQLException;
}
