package com.fafica.projeto_pi.modelos;


public abstract class Planta {

	private Reserva reserva;
	private String especie;
	private String nome;
	private double tamanho;

	public Planta(Reserva reserva, String especie, String nome, double tamanho) {
		this.reserva = reserva;
		this.especie = especie;
		this.nome = nome;
		this.tamanho = tamanho;
	}

	public Planta(String especie, String nome, double tamanho) {
		this.especie = especie;
		this.nome = nome;
		this.tamanho = tamanho;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
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


	@Override
	public String toString() {
		return "Planta [Reserva=" + reserva + ", especie=" + especie
				+ ", nome=" + nome + ", tamanho=" + tamanho + "]";
	}

}
