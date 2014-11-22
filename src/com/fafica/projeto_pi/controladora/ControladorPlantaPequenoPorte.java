package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.PesquisadorNaoEncontradoException;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaGrandePorteBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaMedioPorteBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaPequenoPorteBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaGrandePorte;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaMedioPorte;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaPequenoPorte;

public class ControladorPlantaPequenoPorte {
	
	IRepositorioPlantaPequenoPorte repositorioPlantaPequenaPorte;
	
	
	public ControladorPlantaPequenoPorte() throws Exception {
		repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorteBDR();

	}
	
	
	public ArrayList<PlantaPequenoPorte> listarPlantaPequena() throws Exception{
		System.out.println("Pasando pela Controladora lsitarPlantaPequenoPorte");
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorteBDR();
		return this.repositorioPlantaPequenaPorte.listarPlantaPequenoPorte();
	}
	
	public ArrayList<PlantaPequenoPorte> listarPlantaPequena(int idReserva) throws Exception{
		System.out.println("Pasando pela Controladora lsitarPlantaPequenoPorte");
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorteBDR();
		return this.repositorioPlantaPequenaPorte.listarPlantaPequenoPorte(idReserva);
	}
	
	public void removerPlantaPequenoPorte(int idPlantaPequena) throws Exception,PesquisadorNaoEncontradoException{
		System.out.println("Passando pela controladora removerPlantaPequena");
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorteBDR();
		this.repositorioPlantaPequenaPorte.removerPlantaPequenoPorte(idPlantaPequena);
		
	}
	
	public PlantaPequenoPorte procurarPlantaPequena(int idPlantaPequena) throws Exception,PesquisadorNaoEncontradoException{
		System.out.println("Passando pela controladora procurarPlantaPequena");
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorteBDR();
		return repositorioPlantaPequenaPorte.procurarPlantaPequenoPorte(idPlantaPequena);
	}
	
}
