package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.SoloNaoEncontradorException;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.repositorioBDR.RepositorioSoloBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioSolo;

public class ControladorSolo {

	IRepositorioSolo repositorioSolo;

	public ControladorSolo() throws Exception {
		this.repositorioSolo = new RepositorioSoloBDR();

	}
	public void CadastrarSolo(Solo solo) throws SQLException{
		this.repositorioSolo.cadastrarSolo(solo);
	}

	public ArrayList<Solo> listarSolo() throws SQLException {
		System.out.println("Passando pela controladora listarSolo");
		return this.repositorioSolo.listarSolo();
	}

	public ArrayList<Solo> listarSolo(int idReserva) throws SQLException {
		System.out.println("Passando pela controladora listarSolo");
		return this.repositorioSolo.listarSolo(idReserva);
	}
	
	public Solo procurarSolo(int idSolo)throws SQLException,SoloNaoEncontradorException {
		System.out.println("Passando pela controladora procurarSolo");
		return this.repositorioSolo.procurarSolo(idSolo);
	}

	public void editarSolo(Solo solo)throws SQLException,SoloNaoEncontradorException  {
		System.out.println("Passando pela controladora editarSolo");
		this.repositorioSolo.editarSolo(solo);
	}

	public void removerSolo(int idSolo) throws SQLException ,SoloNaoEncontradorException {
		System.out.println("Passando pela controladora removerSolo");
		this.repositorioSolo.removerSolo(idSolo);
	}



}
