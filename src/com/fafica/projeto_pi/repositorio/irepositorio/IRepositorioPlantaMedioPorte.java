package com.fafica.projeto_pi.repositorio.irepositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.PlantaMedioPorte;

public interface IRepositorioPlantaMedioPorte {

	public void cadastrarPlantaMedioPorte(PlantaMedioPorte plantamedia);
	public ArrayList<PlantaMedioPorte> listarPlantaMedioPorte();
	public PlantaMedioPorte procurar(int idPlantaMedia);
	public void removerPlantaMedioPorte(int idPlantaMedia);
	public boolean existePlantaMedioPorte(int idPlantaMedia);
}
