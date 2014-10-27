package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;

import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.ReservaRecursos;
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
	
	
	public void cadastrarPlantaPequenoPorte(ReservaRecursos reservaRecursos) throws SQLException{
		System.out.println("Passando pela controladora cadastrarPlantaPequenoPorte");
		 // lista de Plantas de pequeno porte
		 for (PlantaPequenoPorte PlantaPequna :reservaRecursos.getListaPlantaPequena()) {
		 this.repositorioPlantaPequenaPorte .cadastrarPlantaPequenoPorte(PlantaPequna);
		 }
	
	}

	
	public void cadastrarPlantaMedioPorte(ReservaRecursos reservaRecursos) throws SQLException{
		System.out.println("Passando pela controladora cadastrarPlantaMedioPorte");
		 // lista de Plantas de pequeno porte
		 for (PlantaMedioPorte PlantaMedia :reservaRecursos.getListaPlantaMedia()) {
		 this.repositorioPlantaMediaPorte.cadastrarPlantaMedioPorte(PlantaMedia);
		 }
	
	}
	
	public void cadastrarPlantaGrandePorte(ReservaRecursos reservaRecursos) throws SQLException{
		System.out.println("Passando pela controladora cadastrarPlantaGrandePorte");
		 // lista de Plantas de pequeno porte
		 for (PlantaGrandePorte PlantaGrande :reservaRecursos.getListaPlantaGrande()) {
		 this.repositorioPlantaGrandePorte .cadastrarPlantaGrandePorte(PlantaGrande);
		 }	
	}

}
