package com.fafica.projeto_pi.repositorioBDR.irepositorioBDR;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.PlantaNaoEncontradaException;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;

public interface IRepositorioPlantaPequenoPorte {

	public void cadastrarPlantaPequenoPorte(PlantaPequenoPorte plantapequena) throws SQLException;
	public PlantaPequenoPorte procurarPlantaPequenoPorte(int idPlantaPequena) throws SQLException,PlantaNaoEncontradaException;
	public ArrayList<PlantaPequenoPorte> listarPlantaPequenoPorte() throws SQLException;
	public ArrayList<PlantaPequenoPorte> listarPlantaPequenoPorte(int idReserva) throws SQLException;
	public void removerPlantaPequenoPorte(int idPlantaPequena) throws SQLException,PlantaNaoEncontradaException;
	public boolean existePlantaPequenoPorte(PlantaPequenoPorte plantaPequena) throws SQLException;
}
