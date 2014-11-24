package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.PlantaNaoEncontradaException;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaMedioPorteBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaMedioPorte;

public class ControladorPlantaMedioPorte {

	IRepositorioPlantaMedioPorte repositorioPlantaMediaPorte;
	
	public ControladorPlantaMedioPorte() throws Exception {
	
		repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorteBDR();
		
	}
	
	public ArrayList<PlantaMedioPorte> listarPlantaMedia() throws SQLException,Exception {
		System.out.println("Pasando pela ControladorA lsitarPlantaPequenoPorte");
		this.repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorteBDR();
		return this.repositorioPlantaMediaPorte.listarPlantaMedioPorte();
	}
	
	public ArrayList<PlantaMedioPorte> listarPlantaMedia(int idReserva) throws SQLException ,Exception{
		System.out.println("Pasando pela ControladorA lsitarPlantaPequenoPorte");
		this.repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorteBDR();
		return this.repositorioPlantaMediaPorte.listarPlantaMedioPorte(idReserva);
	}
	
	public void removerPlantaMedioPorte(int idPlantaMedia) throws SQLException, PlantaNaoEncontradaException,Exception {
		System.out.println("Passando pela controladora removerPlantaMedia");
		this.repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorteBDR();
		this.repositorioPlantaMediaPorte.removerPlantaMedioPorte(idPlantaMedia);
		
	}
	
}
