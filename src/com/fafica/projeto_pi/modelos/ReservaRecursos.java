package com.fafica.projeto_pi.modelos;

import java.util.List;

public class ReservaRecursos {

	private List<PlantaPequenoPorte> listaPlantaPequena;
	private List<PlantaMedioPorte> listaPlantaMedia;
	private List<PlantaGrandePorte> listaPlantaGrande;
	private List<Solo> Solos;
	private List<NascenteAgua> nascenteAgua;
	private List<Pesquisador> pesquisadores;
	
	public ReservaRecursos(List<PlantaPequenoPorte> listaPlantaPequena,
			List<PlantaMedioPorte> listaPlantaMedia,
			List<PlantaGrandePorte> listaPlantaGrande,
			List<Solo> solos,			
			List<NascenteAgua> nascenteAgua, 
			List<Pesquisador> pesquisadores) {

		this.listaPlantaPequena = listaPlantaPequena;
		this.listaPlantaMedia = listaPlantaMedia;
		this.listaPlantaGrande = listaPlantaGrande;
		Solos = solos;
		this.nascenteAgua = nascenteAgua;
		this.pesquisadores = pesquisadores;
	}
	

	

	public List<PlantaPequenoPorte> getListaPlantaPequena() {
		return listaPlantaPequena;
	}

	public void setListaPlantaPequena(List<PlantaPequenoPorte> listaPlantaPequena) {
		this.listaPlantaPequena = listaPlantaPequena;
	}

	public List<PlantaMedioPorte> getListaPlantaMedia() {
		return listaPlantaMedia;
	}

	public void setListaPlantaMedia(List<PlantaMedioPorte> listaPlantaMedia) {
		this.listaPlantaMedia = listaPlantaMedia;
	}

	public List<PlantaGrandePorte> getListaPlantaGrande() {
		return listaPlantaGrande;
	}

	public void setListaPlantaGrande(List<PlantaGrandePorte> listaPlantaGrande) {
		this.listaPlantaGrande = listaPlantaGrande;
	}

	public List<Solo> getSolos() {
		return Solos;
	}

	public void setSolos(List<Solo> solos) {
		Solos = solos;
	}

	public List<NascenteAgua> getNascenteAgua() {
		return nascenteAgua;
	}

	public void setNascenteAgua(List<NascenteAgua> agua) {
		this.nascenteAgua = agua;
	}

	public List<Pesquisador> getPesquisadores() {
		return pesquisadores;
	}

	public void setPesquisadores(List<Pesquisador> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}

	@Override
	public String toString() {
		return "Reserva [ listaPlantaPequena=" + listaPlantaPequena
				+ ", listaPlantaMedia=" + listaPlantaMedia
				+ ", listaPlantaGrande=" + listaPlantaGrande + ", Solos="
				+ Solos + ", nascenteAgua=" + nascenteAgua + ", pesquisadores=" + pesquisadores
				+ "]";
	}	
}
