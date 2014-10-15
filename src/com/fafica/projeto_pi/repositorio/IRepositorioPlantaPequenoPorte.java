package com.fafica.projeto_pi.repositorio;

public interface IRepositorioPlantaPequenoPorte {

	public void cadastrar(PlantaPequenoPorte plantapequena);
	public PlantaPequenoPorte procurar(int id);
	public void atualizar(PlantaPequenoPorte plantapequena);
	public void remover(int id);
	public boolean existe(int id);
}
