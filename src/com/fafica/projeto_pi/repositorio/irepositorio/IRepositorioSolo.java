package com.fafica.projeto_pi.repositorio.irepositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Solo;

public interface IRepositorioSolo {

	public void cadastrarSolo(Solo solo);
	public Solo procurarSolo(int idSolo);
	public ArrayList<Solo> listarSolo();
	public void editarSolo(Solo Solo);
	public void removerSolo(int idSolo);
	public boolean existeSolo(int idSolo);
}
