package com.fafica.projeto_pi.repositorio.irepositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;

public interface IRepositorioPlantaPequenoPorte {

	public void cadastrarPlantaPequenoPorte(PlantaPequenoPorte plantapequena);
	public PlantaPequenoPorte procurarPlantaPequenoPorte(int idPlantaPequena);
	public ArrayList<PlantaPequenoPorte> listarPlantaPequenoPorte();
	public void removerPlantaPequenoPorte(int idPlantaPequena);
	public boolean existePlantaPequenoPorte(int idPlantaPequena);
}
