package com.fafica.projeto_pi.modelos;


public class PlantaPequenoPorte extends Planta {

	private int idPlantaPequenaPorte;

	
	
	public PlantaPequenoPorte(int idPlantaPequenaPorte,String especie, String nome,
			double tamanho) {
		super(especie, nome, tamanho);
		this.idPlantaPequenaPorte = idPlantaPequenaPorte;
	}

	public PlantaPequenoPorte(String especie, String nome, double tamanho,int idReserva) {
		super(idReserva,especie, nome, tamanho);

	}
	
	public PlantaPequenoPorte(String especie, String nome, double tamanho) {
		super(especie, nome, tamanho);

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
