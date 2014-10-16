package com.fafica.projeto_pi.repositorio.irepositorio;

import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;

public interface IRepositorioPlantaPequenoPorte {

	public void cadastrarPlantaPequenoPorte(PlantaPequenoPorte plantapequena);
	public PlantaPequenoPorte procurarPlantaPequenoPorte(int id);
	public void listarPlantaPequenoPorte();
	public void removerPlantaPequenoPorte(int id);
	public boolean existePlantaPequenoPorte(int id);
}
