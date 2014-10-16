package com.fafica.projeto_pi.modelos;

import java.util.List;

public class Reserva {

	private int idReserva;
	private String clima;
	private String nome;
	private double tamanho;
	private double latitude;
	private double longitude;
	private List<Planta> Plantas;
	private List<Solo> Solos;
	private List<Agua> agua;
	private List<Pesquisador> pesquisadores;

	public Reserva(int idReserva, String clima, String nome, double tamanho,
			double latitude, double longitude, List<Pesquisador> pesquisadores,
			List<Planta> plantas, List<Solo> solos, List<Agua> agua) {
		this.idReserva = idReserva;
		this.clima = clima;
		this.nome = nome;
		this.tamanho = tamanho;
		this.latitude = latitude;
		this.longitude = longitude;
		this.pesquisadores = pesquisadores;
		this.Plantas = plantas;
		this.Solos = solos;
		this.agua = agua;
	}

	public Reserva(int idReserva, String clima, String nome, double tamanho,
			double latitude, double longitude) {
		super();
		this.idReserva = idReserva;
		this.clima = clima;
		this.nome = nome;
		this.tamanho = tamanho;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public List<Planta> getPlantas() {
		return Plantas;
	}

	public void setPlantas(List<Planta> plantas) {
		Plantas = plantas;
	}

	public List<Solo> getSolos() {
		return Solos;
	}

	public void setSolos(List<Solo> solos) {
		Solos = solos;
	}

	public List<Agua> getAgua() {
		return agua;
	}

	public void setAgua(List<Agua> agua) {
		this.agua = agua;
	}

	public List<Pesquisador> getPesquisadores() {
		return pesquisadores;
	}

	public void setPesquisadores(List<Pesquisador> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", clima=" + clima
				+ ", nome=" + nome + ", tamanho=" + tamanho + ", latitude="
				+ latitude + ", longitude=" + longitude + ", Plantas="
				+ Plantas + ", Solos=" + Solos + ", agua=" + agua
				+ ", pesquisadores=" + pesquisadores + "]";
	}
}
