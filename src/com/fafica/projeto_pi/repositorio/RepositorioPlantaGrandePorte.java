package com.fafica.projeto_pi.repositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaGrandePorte;

public class RepositorioPlantaGrandePorte implements IRepositorioPlantaGrandePorte{

	@Override
	public void cadastrarPlantaGrandePorte(PlantaGrandePorte plantagrande) {
	System.out.println("Chegando ao RepositorioPlantaGrandePòrte cadastrarPlantaGrandePorte");
		
	}

	@Override
	public PlantaGrandePorte procurarPlantaGrandePorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaGrandePòrte procurarPLantaGrandePorte");
		return null;
	}

	@Override
	public ArrayList<PlantaGrandePorte> listarPlantaGrandePorte() {
		System.out.println("Chegando ao RepositorioPlantaGrandePòrte listarPLantaGrandePorte");
		return null;
		
	}

	@Override
	public void removerPlantaGrandePorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaGrandePòrte removerPlantaGrandePorte");
		
	}

	@Override
	public boolean existePlantaGrandePorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaGrandePòrte existePlantaGrandePorte");
		return false;
	}

}
