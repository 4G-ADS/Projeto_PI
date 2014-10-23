package com.fafica.projeto_pi.modelos;

import java.awt.Image;

public class PlantaPequenoPorte extends Planta{
	
	private int idPlantaPequenaPorte;
	public PlantaPequenoPorte(int idReserva, int idPlanta, 
			String especie, String nome, double tamanho, Image imagem,
			int idPlantaPequenaPorte) {
		super(idReserva, idPlanta, especie, nome, tamanho, imagem);
		this.idPlantaPequenaPorte = idPlantaPequenaPorte;
	}
	public int getIdPlantaPequenaPorte() {
		return idPlantaPequenaPorte;
	}
	public void setIdPlantaPequenaPorte(int idPlantaPequenaPorte) {
		this.idPlantaPequenaPorte = idPlantaPequenaPorte;
	}
	
	@Override
	public String toString() {
		return "PlantaPequenoPorte [idPlantaPequenaPorte="
				+ idPlantaPequenaPorte + "]";
	}

}
