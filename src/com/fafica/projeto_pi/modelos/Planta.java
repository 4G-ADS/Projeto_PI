package com.fafica.projeto_pi.modelos;

import java.awt.Image;

public abstract class Planta {

	private int idReserva;
	private int idPlanta;
	private String especie;
	private String nome;
	private double tamanho;
	private Image imagem;
	
	public Planta(int idReserva, int idPlanta, String especie, String nome, double tamanho,
			Image imagem) {
		this.idReserva = idReserva;
		this.idPlanta = idPlanta;
		this.especie = especie;
		this.nome = nome;
		this.tamanho = tamanho;
		this.imagem = imagem;
	}
	
	public int getIdReserva() {
		return idReserva;
	}



	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
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
	
	
	
	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "Planta [idReserva=" + idReserva + ", idPlanta=" + idPlanta
				+ ", especie=" + especie + ", nome=" + nome + ", tamanho="
				+ tamanho + ", imagem=" + imagem + "]";
	}
	
}
