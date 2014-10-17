package com.fafica.projeto_pi.controladora;

import com.fafica.projeto_pi.repositorio.RepositorioPlantaGrandePorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaGrandePorte;

public class ControladorPlantaGrandePorte {

	IRepositorioPlantaGrandePorte repositorioPlantaGrandePorete;
	
	public ControladorPlantaGrandePorte(){
		
		this.repositorioPlantaGrandePorete = new RepositorioPlantaGrandePorte();
	}
	

	
}
