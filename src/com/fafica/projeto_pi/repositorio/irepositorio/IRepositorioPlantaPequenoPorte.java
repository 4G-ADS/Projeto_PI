package com.fafica.projeto_pi.repositorio.irepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;

public interface IRepositorioPlantaPequenoPorte {

	public void cadastrarPlantaPequenoPorte(PlantaPequenoPorte plantapequena) throws SQLException;
	public PlantaPequenoPorte procurarPlantaPequenoPorte(int idPlantaPequena);
	public ArrayList<PlantaPequenoPorte> listarPlantaPequenoPorte();
	public void removerPlantaPequenoPorte(int idPlantaPequena);
	public boolean existePlantaPequenoPorte(int idPlantaPequena);
}
