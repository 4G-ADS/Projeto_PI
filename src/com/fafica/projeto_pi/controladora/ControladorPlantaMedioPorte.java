package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaMedioPorteBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaMedioPorte;

public class ControladorPlantaMedioPorte {

	IRepositorioPlantaMedioPorte repositorioPlantaMediaPorte;
	
	public ControladorPlantaMedioPorte() throws Exception {
	
		repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorteBDR();
		
	}
	
	public ArrayList<PlantaMedioPorte> listarPlantaMedia() throws Exception{
		System.out.println("Pasando pela ControladorA lsitarPlantaPequenoPorte");
		this.repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorteBDR();
		return this.repositorioPlantaMediaPorte.listarPlantaMedioPorte();
	}
	
	public ArrayList<PlantaMedioPorte> listarPlantaMedia(int idReserva) throws Exception{
		System.out.println("Pasando pela ControladorA lsitarPlantaPequenoPorte");
		this.repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorteBDR();
		return this.repositorioPlantaMediaPorte.listarPlantaMedioPorte(idReserva);
	}
	
	public void removerPlantaMedioPorte(int idPlantaMedia) throws Exception{
		System.out.println("Passando pela controladora removerPlantaMedia");
		this.repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorteBDR();
		this.repositorioPlantaMediaPorte.removerPlantaMedioPorte(idPlantaMedia);
		
	}
	
	public PlantaMedioPorte procurarPlantaMedia(int idPlantaMedia) throws Exception{
		System.out.println("Passando pela controladora procurarPlantaMedia");
		this.repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorteBDR();
		return repositorioPlantaMediaPorte.procurarPlantaMedia(idPlantaMedia);
	}
	
	
}
