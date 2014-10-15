package com.fafica.projeto_pi.repositorio;

public interface IRepositorioPlantaMedioPorte {

	public void cadastrar(PlantaMedioPorte plantamedia);
	public PlantaMedioPorte procurar(int id);
	public void atualizar(PlantaMedioPorte plantamedia);
	public void remover(int id);
	public boolean existe(int id);
}
