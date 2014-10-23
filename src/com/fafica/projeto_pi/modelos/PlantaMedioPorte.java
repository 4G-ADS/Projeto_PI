package com.fafica.projeto_pi.modelos;

import java.awt.Image;

public class PlantaMedioPorte extends Planta {

	private int idPlantaMedioPorte;

	public PlantaMedioPorte(int idReserva, int idPlanta, String especie,
			String nome, double tamanho, Image imagem, int idPlantaMedioPorte) {
		super(idReserva, idPlanta, especie, nome, tamanho, imagem);
		this.idPlantaMedioPorte = idPlantaMedioPorte;
	}

	public int getIdPlantaMedioPorte() {
		return idPlantaMedioPorte;
	}

	public void setIdPlantaMedioPorte(int idPlantaMedioPorte) {
		this.idPlantaMedioPorte = idPlantaMedioPorte;
	}

	@Override
	public String toString() {
		return "PlantaMedioPorte [idPlantaMedioPorte=" + idPlantaMedioPorte
				+ "]";
	}

}
