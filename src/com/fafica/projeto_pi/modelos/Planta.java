package com.fafica.projeto_pi.modelos;

public class Planta {

	private int idPlanta;
	private String especie;
	private String nome;
	private double tamanho;
	
	public Planta(int idPlanta, String especie, String nome, double tamanho) {
		this.idPlanta = idPlanta;
		this.especie = especie;
		this.nome = nome;
		this.tamanho = tamanho;
	}

	public int getIdPlanta() {
		return idPlanta;
	}

	public void setIdPlanta(int idPlanta) {
		this.idPlanta = idPlanta;
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
		return "Planta [idPlanta=" + idPlanta + ", especie=" + especie
				+ ", nome=" + nome + ", tamanho=" + tamanho + "]";
	}
	
}
