package com.fafica.projeto_pi.repositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaPequenoPorte;

public class RepositorioPlantaPequenoPorte implements IRepositorioPlantaPequenoPorte{

	@Override
	public void cadastrarPlantaPequenoPorte(PlantaPequenoPorte plantapequena) {
		System.out.println("Chegando ao RepositorioPlantaPequenoPorte cadastrarPlantaPequenoPorte");
		
	}

	@Override
	public PlantaPequenoPorte procurarPlantaPequenoPorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaPequenoPorte procurarPlantaPequenoPorte");
		return null;
	}

	@Override
	public ArrayList<PlantaPequenoPorte> listarPlantaPequenoPorte() {
		System.out.println("Chegando ao RepositorioPlantaPequenoPorte listarPlantaPequenoPortre");
		return null;
		
	}

	@Override
	public void removerPlantaPequenoPorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaPequenoPorte removerPlantaPequenoPorte");
		
	}

	@Override
	public boolean existePlantaPequenoPorte(int id) {
		System.out.println("Chegando ao RepositorioPlantaPequenoPorte existePlantaPequenoPorte");
		return false;
	}

}
