package com.fafica.projeto_pi.repositorio.irepositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.PlantaGrandePorte;

public interface IRepositorioPlantaGrandePorte {

	public void cadastrarPlantaGrandePorte(PlantaGrandePorte plantagrande);
	public PlantaGrandePorte procurarPlantaGrandePorte(int idPlantaGrande);
	public ArrayList<PlantaGrandePorte> listarPlantaGrandePorte();
	public void removerPlantaGrandePorte(int idPlantaGrande);
	public boolean existePlantaGrandePorte(int idPlantaGrande);
}
