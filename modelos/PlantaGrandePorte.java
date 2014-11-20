package com.fafica.projeto_pi.modelos;


public class PlantaGrandePorte extends Planta{

	private int idPantaGrandePorte;
	public PlantaGrandePorte(int idPantaGrandePorte,String especie, String nome,
			double tamanho) {
		super(especie, nome, tamanho);
		this.idPantaGrandePorte = idPantaGrandePorte;

	}
	

	public PlantaGrandePorte(String especie,String nome, double tamanho,int idReserva) {
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
