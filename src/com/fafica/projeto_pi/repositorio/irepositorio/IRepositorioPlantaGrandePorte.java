package com.fafica.projeto_pi.repositorio.irepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.PlantaGrandePorte;

public interface IRepositorioPlantaGrandePorte {

	public void cadastrarPlantaGrandePorte(PlantaGrandePorte plantagrande) throws SQLException;
	public PlantaGrandePorte procurarPlantaGrandePorte(int idPlantaGrande) throws SQLException;
	public ArrayList<PlantaGrandePorte> listarPlantaGrandePorte() throws SQLException;
	public ArrayList<PlantaGrandePorte> listarPlantaGrandePorte(int idReserva) throws SQLException;
	public void removerPlantaGrandePorte(int idPlantaGrande) throws SQLException;
	public boolean existePlantaGrandePorte(int idPlantaGrande);
}
