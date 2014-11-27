package com.fafica.projeto_pi.modelos;


public class PlantaMedioPorte extends Planta {

	private int idPlantaMedioPorte;
	
	public PlantaMedioPorte(int idPlantaMedioPorte,String especie,
			String nome, double tamanho) {
		super(especie, nome, tamanho);
		this.idPlantaMedioPorte = idPlantaMedioPorte;
	
	}

	public PlantaMedioPorte(String especie,
			String nome, double tamanho,int idReserva) {
		super(especie, nome, tamanho);
	}

	
	public PlantaMedioPorte(String especie,
			String nome, double tamanho) {
		super(especie, nome, tamanho);
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
