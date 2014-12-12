package com.fafica.projeto_pi.modelos;

public class NascenteAgua {

	private int idAgua;
	private Reserva reserva;
	private double latitude;
	private double longitude;
	private String nomeFonte;
	private String tipo;
	
	public NascenteAgua(int idAgua, Reserva reserva, double latitude,
			double longitude, String nomeFonte, String tipo) {
		super();
		this.idAgua = idAgua;
		this.reserva = reserva;
		this.latitude = latitude;
		this.longitude = longitude;
		this.nomeFonte = nomeFonte;
		this.tipo = tipo;
	}

	public NascenteAgua(int idAgua, double latitude, double longitude,
			String nomeFonte, String tipo) {

		this.idAgua = idAgua;
		this.latitude = latitude;
		this.longitude = longitude;
		this.nomeFonte = nomeFonte;
		this.tipo = tipo;
	}

	public NascenteAgua(double latitude, double longitude, String nomeFonte,
			String tipo) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.nomeFonte = nomeFonte;
		this.tipo = tipo;
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

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "NascenteAgua [idAgua=" + idAgua + ", Reserva=" + reserva
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", nomeFonte=" + nomeFonte + ", tipo=" + tipo + "]";
	}
	
	

}
