package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.PlantaNaoEncontradaException;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaPequenoPorteBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaPequenoPorte;

public class ControladorPlantaPequenoPorte {
	
	IRepositorioPlantaPequenoPorte repositorioPlantaPequenaPorte;
	
	
	public ControladorPlantaPequenoPorte() throws Exception {
		repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorteBDR();

	}
	
	public void cadastrarPlantaPequenoPorte(PlantaPequenoPorte planta) throws SQLException{
		this.repositorioPlantaPequenaPorte.cadastrarPlantaPequenoPorte(planta);
	}
	
	public ArrayList<PlantaPequenoPorte> listarPlantaPequena() throws SQLException,Exception {
		System.out.println("Pasando pela Controladora lsitarPlantaPequenoPorte");
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorteBDR();
		return this.repositorioPlantaPequenaPorte.listarPlantaPequenoPorte();
	}
	
	public ArrayList<PlantaPequenoPorte> listarPlantaPequena(int idReserva) throws SQLException,Exception {
		System.out.println("Pasando pela Controladora lsitarPlantaPequenoPorte");
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorteBDR();
		return this.repositorioPlantaPequenaPorte.listarPlantaPequenoPorte(idReserva);
	}
	
	public void removerPlantaPequenoPorte(int idPlantaPequena) throws SQLException, PlantaNaoEncontradaException,Exception {
		System.out.println("Passando pela controladora removerPlantaPequena");
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorteBDR();
		this.repositorioPlantaPequenaPorte.removerPlantaPequenoPorte(idPlantaPequena);
		
	}
	
}
