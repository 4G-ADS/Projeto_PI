package com.fafica.projeto_pi.modelos;

import java.awt.Image;

public class PlantaGrandePorte extends Planta{

	private int idPantaGrandePorte;
	public PlantaGrandePorte(int idReserva, int idPlanta,
			String especie, String nome,
			double tamanho, Image imagem,int idPantaGrandePorte) {
		super(idReserva, idPlanta, especie, nome, tamanho, imagem);
		this.idPantaGrandePorte = idPantaGrandePorte;
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
