package com.fafica.projeto_pi.modelos;

import java.awt.Image;

public abstract class Planta {

	private int idReserva;
	private String especie;
	private String nome;
	private double tamanho;

	public Planta(int idReserva, String especie, String nome, double tamanho) {
		this.idReserva = idReserva;
		this.especie = especie;
		this.nome = nome;
		this.tamanho = tamanho;
	}

	public Planta(String especie, String nome, double tamanho) {
		this.especie = especie;
		this.nome = nome;
		this.tamanho = tamanho;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
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
		return "Planta [idReserva=" + idReserva + ", especie=" + especie
				+ ", nome=" + nome + ", tamanho=" + tamanho + "]";
	}

}
