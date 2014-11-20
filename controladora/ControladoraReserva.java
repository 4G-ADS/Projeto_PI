package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.repositorioBDR.RepositorioNascenteAguaBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPesquisadorBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaGrandePorteBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaMedioPorteBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaPequenoPorteBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioReservaBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioSoloBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioNascenteAgua;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPesquisador;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaGrandePorte;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaMedioPorte;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaPequenoPorte;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioReserva;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioSolo;

public class ControladoraReserva {

	IRepositorioReserva repositorioReserva;
	IRepositorioNascenteAgua repositorioNascenteAgua;
	IRepositorioPesquisador repositorioPesquisador;
	IRepositorioSolo repositorioSolo; 
	IRepositorioPlantaPequenoPorte repositorioPlantaPequenoPorte;
	IRepositorioPlantaMedioPorte repositorioPlantaMedioPorte ;
	IRepositorioPlantaGrandePorte repositorioPlantaGrandePorte;
	
	public ControladoraReserva() throws Exception {
		this.repositorioReserva = new RepositorioReservaBDR();
		this.repositorioNascenteAgua = new RepositorioNascenteAguaBDR();
		this.repositorioPesquisador = new RepositorioPesquisadorBDR();
		this.repositorioSolo = new RepositorioSoloBDR();
		this.repositorioPlantaPequenoPorte = new RepositorioPlantaPequenoPorteBDR();
		this.repositorioPlantaMedioPorte = new RepositorioPlantaMedioPorteBDR();
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorteBDR();
	}

	public void cadastrarReserva(
			Reserva reserva) throws SQLException {
		System.out.println("Passando pela controladora de reserva");
		// Aqui fazemos a chamada do repositorio no metodo cadastrar para
		// inserir no banco
		this.repositorioReserva.cadastrarReserva(reserva);
		
		
		for (Pesquisador pesquisador : reserva.getPesquisadores()) {
			pesquisador.setIdReserva(reserva.getIdReserva());
			this.repositorioPesquisador.cadastrarPesquisadores(pesquisador);
			
		}

		for (NascenteAgua nascente : reserva.getNascenteAgua()) {
			nascente.setIdReserva(reserva.getIdReserva());
			this.repositorioNascenteAgua.cadastrarAgua(nascente);
		}
		
		for (Solo solo : reserva.getSolos()) {
			solo.setIdReserva(reserva.getIdReserva());
			this.repositorioSolo.cadastrarSolo(solo);
		}
		
		for (PlantaPequenoPorte plantaPequena : reserva.getListaPlantaPequena()) {
			plantaPequena.setIdReserva(reserva.getIdReserva());
			this.repositorioPlantaPequenoPorte.cadastrarPlantaPequenoPorte(plantaPequena);
		}
		
		for (PlantaMedioPorte plantaMedia : reserva.getListaPlantaMedia()) {
			plantaMedia.setIdReserva(reserva.getIdReserva());
			this.repositorioPlantaMedioPorte.cadastrarPlantaMedioPorte(plantaMedia);
		}
		
		for (PlantaGrandePorte plantaGrande : reserva.getListaPlantaGrande()) {
			plantaGrande.setIdReserva(reserva.getIdReserva());
			this.repositorioPlantaGrandePorte.cadastrarPlantaGrandePorte(plantaGrande);
			
		}
	}

	public ArrayList<Reserva> listarReserva()
			throws SQLException {
		System.out.println("Passando pela controladora listarReservas");
		return repositorioReserva.listarReserva();
	}

	public Reserva procurarReserva(int idReserva) throws SQLException{
		System.out.println("Passando pelo pelo procurarReserva");
		return this.repositorioReserva.procurarReserva(idReserva);
	}

	public void editarReserva(
			Reserva reserva) throws SQLException {
		System.out.println("Passando pelo editarReservas");
		this.repositorioReserva.editarReserva(reserva);
	}

	public void removerReserva(int idReserva) throws SQLException {
		System.out.println("Passando pelo removerReservas");
		this.repositorioReserva
				.removerReserva(idReserva);
	}

}
