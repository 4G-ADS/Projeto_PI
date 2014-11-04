package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorio.RepositorioPlantaGrandePorte;
import com.fafica.projeto_pi.repositorio.RepositorioPlantaMedioPorte;
import com.fafica.projeto_pi.repositorio.RepositorioPlantaPequenoPorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaGrandePorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaMedioPorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaPequenoPorte;

public class ControladorReservaPlantas {
	
	IRepositorioPlantaPequenoPorte repositorioPlantaPequenaPorte;
	IRepositorioPlantaMedioPorte repositorioPlantaMediaPorte;
	IRepositorioPlantaGrandePorte repositorioPlantaGrandePorte;
	
	public ControladorReservaPlantas() throws Exception {
		repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorte();
		repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorte();
		repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorte();
	}
	
	
	public void cadastrarPlantaPequenoPorte(Reserva reserva) throws SQLException{
		System.out.println("Passando pela controladora cadastrarPlantaPequenoPorte");
		 // lista de Plantas de pequeno porte
		 for (PlantaPequenoPorte PlantaPequna :reserva.getListaPlantaPequena()) {
		 this.repositorioPlantaPequenaPorte .cadastrarPlantaPequenoPorte(PlantaPequna);
		 }
	
	}

	public ArrayList<PlantaPequenoPorte> listarPlantaPequena() throws Exception{
		System.out.println("Pasando pela Controladora lsitarPlantaPequenoPorte");
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorte();
		return this.repositorioPlantaPequenaPorte.listarPlantaPequenoPorte();
	}
	
	public ArrayList<PlantaPequenoPorte> listarPlantaPequena(int idReserva) throws Exception{
		System.out.println("Pasando pela Controladora lsitarPlantaPequenoPorte");
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorte();
		return this.repositorioPlantaPequenaPorte.listarPlantaPequenoPorte(idReserva);
	}
	
	public void removerPlantaPequenoPorte(int idPlantaPequena) throws Exception{
		System.out.println("Passando pela controladora removerPlantaPequena");
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorte();
		this.repositorioPlantaPequenaPorte.removerPlantaPequenoPorte(idPlantaPequena);
		
	}
	
	public PlantaPequenoPorte procurarPlantaPequena(int idPlantaPequena) throws Exception{
		System.out.println("Passando pela controladora procurarPlantaPequena");
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorte();
		return repositorioPlantaPequenaPorte.procurarPlantaPequenoPorte(idPlantaPequena);
	}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public void cadastrarPlantaMedioPorte(Reserva reserva) throws SQLException{
		System.out.println("Passando pela controladora cadastrarPlantaMedioPorte");
		 // lista de Plantas de pequeno porte
		 for (PlantaMedioPorte PlantaMedia :reserva.getListaPlantaMedia()) {
		 this.repositorioPlantaMediaPorte.cadastrarPlantaMedioPorte(PlantaMedia);
		 }
	
	}
	
	public ArrayList<PlantaMedioPorte> listarPlantaMedia() throws Exception{
		System.out.println("Pasando pela ControladorA lsitarPlantaPequenoPorte");
		this.repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorte();
		return this.repositorioPlantaMediaPorte.listarPlantaMedioPorte();
	}
	
	public ArrayList<PlantaMedioPorte> listarPlantaMedia(int idReserva) throws Exception{
		System.out.println("Pasando pela ControladorA lsitarPlantaPequenoPorte");
		this.repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorte();
		return this.repositorioPlantaMediaPorte.listarPlantaMedioPorte(idReserva);
	}
	
	public void removerPlantaMedioPorte(int idPlantaMedia) throws Exception{
		System.out.println("Passando pela controladora removerPlantaMedia");
		this.repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorte();
		this.repositorioPlantaMediaPorte.removerPlantaMedioPorte(idPlantaMedia);
		
	}
	
	public PlantaMedioPorte procurarPlantaMedia(int idPlantaMedia) throws Exception{
		System.out.println("Passando pela controladora procurarPlantaMedia");
		this.repositorioPlantaMediaPorte = new RepositorioPlantaMedioPorte();
		return repositorioPlantaMediaPorte.procurarPlantaMedia(idPlantaMedia);
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void cadastrarPlantaGrandePorte(Reserva reserva) throws SQLException{
		System.out.println("Passando pela controladora cadastrarPlantaGrandePorte");
		 // lista de Plantas de pequeno porte
		 for (PlantaGrandePorte PlantaGrande :reserva.getListaPlantaGrande()) {
		 this.repositorioPlantaGrandePorte.cadastrarPlantaGrandePorte(PlantaGrande);
		 }
	}

	public ArrayList<PlantaGrandePorte> listarPlantaGrande() throws Exception{
		System.out.println("Pasando pela ControladorA lsitarPlantaGrandePorte");
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorte();
		return this.repositorioPlantaGrandePorte.listarPlantaGrandePorte();
	}
	
	public ArrayList<PlantaGrandePorte> listarPlantaGrande(int idReserva) throws Exception{
		System.out.println("Pasando pela ControladorA lsitarPlantaGrandePorte");
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorte();
		return this.repositorioPlantaGrandePorte.listarPlantaGrandePorte(idReserva);
	}
	
	public void removerPlantaGrandePorte(int idPlantaGrande) throws Exception{
		System.out.println("Passando pela controladora removerPlantaGrande");
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorte();
		this.repositorioPlantaGrandePorte.removerPlantaGrandePorte(idPlantaGrande);
		
	}
	
	public PlantaGrandePorte procurarPlantaGrande(int idPlantaGrande) throws Exception{
		System.out.println("Passando pela controladora procurarPlantaGrande");
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorte();
		return repositorioPlantaGrandePorte.procurarPlantaGrandePorte(idPlantaGrande);
	}
	
}
