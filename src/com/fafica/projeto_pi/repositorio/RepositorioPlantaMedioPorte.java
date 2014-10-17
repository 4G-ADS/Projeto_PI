package com.fafica.projeto_pi.repositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaMedioPorte;

public class RepositorioPlantaMedioPorte implements IRepositorioPlantaMedioPorte{

	@Override
	public void cadastrarPlantaMedioPorte(PlantaMedioPorte plantamedia) {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte cadastrarPlantaMedioPorte");
		
	}

	@Override
	public ArrayList<PlantaMedioPorte> listarPlantaMedioPorte() {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte listarPlantaMedioPorte");
		return null;
		
	}

	@Override
	public PlantaMedioPorte procurar(int id) {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte procurarPlantaMedioPorte");
		return null;
	}

	@Override
	public void removerPlantaMedioPorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte removerPlantaMedioPorte");
		
	}

	@Override
	public boolean existePlantaMedioPorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaMedioPorte existePlantaMedioPorte");
		return false;
	}

}
