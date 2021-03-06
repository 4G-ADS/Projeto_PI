package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.PlantaNaoEncontradaException;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaGrandePorteBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaGrandePorte;

public class ControladorPlantaGrandePorte {

	IRepositorioPlantaGrandePorte repositorioPlantaGrandePorte;
	
	public ControladorPlantaGrandePorte() throws Exception {

		repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorteBDR();
	}

	public void cadastrarPlantaGrande(PlantaGrandePorte planta) throws SQLException{
		this.repositorioPlantaGrandePorte.cadastrarPlantaGrandePorte(planta);
	}
	public ArrayList<PlantaGrandePorte> listarPlantaGrande() throws SQLException,Exception {
		System.out.println("Pasando pela ControladorA lsitarPlantaGrandePorte");
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorteBDR();
		return this.repositorioPlantaGrandePorte.listarPlantaGrandePorte();
	}
	
	public ArrayList<PlantaGrandePorte> listarPlantaGrande(int idReserva) throws SQLException,Exception {
		System.out.println("Pasando pela ControladorA lsitarPlantaGrandePorte");
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorteBDR();
		return this.repositorioPlantaGrandePorte.listarPlantaGrandePorte(idReserva);
	}
	
	public void removerPlantaGrandePorte(int idPlantaGrande) throws SQLException, PlantaNaoEncontradaException,Exception {
		System.out.println("Passando pela controladora removerPlantaGrande");
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorteBDR();
		this.repositorioPlantaGrandePorte.removerPlantaGrandePorte(idPlantaGrande);
		
	}
	
}
