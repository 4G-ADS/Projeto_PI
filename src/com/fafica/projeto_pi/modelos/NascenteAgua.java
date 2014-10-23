package com.fafica.projeto_pi.modelos;

public class NascenteAgua {

	private int idReserva;
	private int idAgua;
	private double latitude;
	private double longitude;
	private String nomeFonte;
	private String tipo;

	public NascenteAgua(int idReserva, int idAgua, double latitude, double longitude,
			String nomeFonte, String tipo) {

		this.idReserva = idReserva;
		this.idAgua = idAgua;
		this.latitude = latitude;
		this.longitude = longitude;
		this.nomeFonte = nomeFonte;
		this.tipo = tipo;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdAgua() {
		return idAgua;
	}

	public void setIdAgua(int idAgua) {
		this.idAgua = idAgua;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getNomeFonte() {
		return nomeFonte;
	}

	public void setNomeFonte(String nomeFonte) {
		this.nomeFonte = nomeFonte;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Agua [idReserva=" + idReserva + ", idAgua=" + idAgua
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", nomeFonte=" + nomeFonte + ", tipo=" + tipo + "]";
	}

}
