package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaGrandePorteBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaGrandePorte;

public class ControladorPlantaGrandePorte {

	IRepositorioPlantaGrandePorte repositorioPlantaGrandePorte;
	
	public ControladorPlantaGrandePorte() throws Exception {

		repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorteBDR();
	}

	public ArrayList<PlantaGrandePorte> listarPlantaGrande() throws Exception{
		System.out.println("Pasando pela ControladorA lsitarPlantaGrandePorte");
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorteBDR();
		return this.repositorioPlantaGrandePorte.listarPlantaGrandePorte();
	}
	
	public ArrayList<PlantaGrandePorte> listarPlantaGrande(int idReserva) throws Exception{
		System.out.println("Pasando pela ControladorA lsitarPlantaGrandePorte");
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorteBDR();
		return this.repositorioPlantaGrandePorte.listarPlantaGrandePorte(idReserva);
	}
	
	public void removerPlantaGrandePorte(int idPlantaGrande) throws Exception{
		System.out.println("Passando pela controladora removerPlantaGrande");
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorteBDR();
		this.repositorioPlantaGrandePorte.removerPlantaGrandePorte(idPlantaGrande);
		
	}
	
	public PlantaGrandePorte procurarPlantaGrande(int idPlantaGrande) throws Exception{
		System.out.println("Passando pela controladora procurarPlantaGrande");
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorteBDR();
		return repositorioPlantaGrandePorte.procurarPlantaGrandePorte(idPlantaGrande);
	}
	
}
