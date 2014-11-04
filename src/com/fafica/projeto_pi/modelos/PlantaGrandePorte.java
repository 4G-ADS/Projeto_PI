package com.fafica.projeto_pi.modelos;

import java.awt.Image;

public class PlantaGrandePorte extends Planta{

	private int idPantaGrandePorte;
	public PlantaGrandePorte(String especie, String nome,
			double tamanho,int idPantaGrandePorte) {
		super(especie, nome, tamanho);
		this.idPantaGrandePorte = idPantaGrandePorte;

	}
	

	public PlantaGrandePorte(int idReserva, String especie,String nome, double tamanho,
			Image imagem) {
		super(idReserva,especie, nome, tamanho);

	}
	
	
	public PlantaGrandePorte(String especie,String nome, double tamanho) {
		super(especie, nome, tamanho);

	}


	public int getIdPantaGrandePorte() {
		return idPantaGrandePorte;
	}
	public void setIdPantaGrandePorte(int idPantaGrandePorte) {
		this.idPantaGrandePorte = idPantaGrandePorte;
	}


	@Override
	public String toString() {
		return "PlantaGrandePorte [idPantaGrandePorte=" + idPantaGrandePorte
				+ "]";
	}
	
}
