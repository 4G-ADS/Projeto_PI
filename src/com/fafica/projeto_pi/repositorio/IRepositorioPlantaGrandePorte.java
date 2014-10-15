package com.fafica.projeto_pi.repositorio;

public interface IRepositorioPlantaGrandePorte {

	public void cadastrar(PlantaGrandePorte plantagrande);
	public PlantaGrandePorte procurar(int id);
	public void atualizar(PlantaGrandePorte plantagrande);
	public void remover(int id);
	public boolean existe(int id);
}
