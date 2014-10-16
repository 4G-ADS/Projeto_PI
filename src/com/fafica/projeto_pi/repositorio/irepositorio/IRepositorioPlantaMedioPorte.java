package com.fafica.projeto_pi.repositorio.irepositorio;

import com.fafica.projeto_pi.modelos.PlantaMedioPorte;

public interface IRepositorioPlantaMedioPorte {

	public void cadastrarPlantaMedioPorte(PlantaMedioPorte plantamedia);
	public void listarPlantaMedioPorte();
	public PlantaMedioPorte procurar(int id);
	public void removerPlantaMedioPorte(int id);
	public boolean existePlantaMedioPorte(int id);
}
