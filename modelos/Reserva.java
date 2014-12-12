package com.fafica.projeto_pi.modelos;

public class Reserva {

	private int idReserva;
	private int idAdm;
	private String clima;
	private String nome;
	private double tamanho;
	private double latitude;
	private double longitude;

	
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
