package com.fafica.projeto_pi.modelos;

import java.util.List;

public class Reserva {

	private int idReserva;
	private int idAdm;
	private String clima;
	private String nome;
	private double tamanho;
	private double latitude;
	private double longitude;
	private List<PlantaPequenoPorte> listaPlantaPequena;
	private List<PlantaMedioPorte> listaPlantaMedia;
	private List<PlantaGrandePorte> listaPlantaGrande;
	private List<Solo> Solos;
	private List<NascenteAgua> nascenteAgua;
	private List<Pesquisador> pesquisadores;
	
	public Reserva(int idAdm, String clima, String nome, double tamanho,
			double latitude, double longitude) {
		super();
		this.idAdm = idAdm;
		this.clima = clima;
		this.nome = nome;
		this.tamanho = tamanho;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Reserva(int idAdm ,int idReserva, String clima, String nome, double tamanho,
			double latitude, double longitude) {
		super();
		this.idAdm = idAdm;
		this.idReserva = idReserva;
		this.clima = clima;
		this.nome = nome;
		this.tamanho = tamanho;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Reserva(int idAdm ,int idReserva, String clima, String nome, double tamanho,
			double latitude, double longitude,
			List<PlantaPequenoPorte> listaPlantaPequena,
			List<PlantaMedioPorte> listaPlantaMedia,
			List<PlantaGrandePorte> listaPlantaGrande, List<Solo> solos,
			List<NascenteAgua> nascenteAgua, List<Pesquisador> pesquisadores) {
		this.idAdm = idAdm;
		this.idReserva = idReserva;
		this.clima = clima;
		this.nome = nome;
		this.tamanho = tamanho;
		this.latitude = latitude;
		this.longitude = longitude;
		this.listaPlantaPequena = listaPlantaPequena;
		this.listaPlantaMedia = listaPlantaMedia;
		this.listaPlantaGrande = listaPlantaGrande;
		Solos = solos;
		this.nascenteAgua = nascenteAgua;
		this.pesquisadores = pesquisadores;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public List<PlantaPequenoPorte> getListaPlantaPequena() {
		return listaPlantaPequena;
	}

	public void setListaPlantaPequena(
			List<PlantaPequenoPorte> listaPlantaPequena) {
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


	public int getIdAdm() {
		return idAdm;
	}

	public void setIdAdm(int idAdm) {
		this.idAdm = idAdm;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", idAdm=" + idAdm
				+ ", clima=" + clima + ", nome=" + nome + ", tamanho="
				+ tamanho + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	
	
}
