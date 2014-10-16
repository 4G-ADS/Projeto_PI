package com.fafica.projeto_pi.repositorio.irepositorio;

import com.fafica.projeto_pi.modelos.PlantaGrandePorte;

public interface IRepositorioPlantaGrandePorte {

	public void cadastrarPlantaGrandePorte(PlantaGrandePorte plantagrande);
	public PlantaGrandePorte procurarPlantaGrandePorte(int id);
	public void listarPlantaGrandePorte();
	public void removerPlantaGrandePorte(int id);
	public boolean existePlantaGrandePorte(int id);
}
