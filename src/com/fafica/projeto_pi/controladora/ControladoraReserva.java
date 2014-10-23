package com.fafica.projeto_pi.controladora;

import java.util.ArrayList;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.repositorio.RepositorioAgua;
import com.fafica.projeto_pi.repositorio.RepositorioPesquisador;
import com.fafica.projeto_pi.repositorio.RepositorioPlantaGrandePorte;
import com.fafica.projeto_pi.repositorio.RepositorioPlantaMedioPorte;
import com.fafica.projeto_pi.repositorio.RepositorioPlantaPequenoPorte;
import com.fafica.projeto_pi.repositorio.RepositorioReserva;
import com.fafica.projeto_pi.repositorio.RepositorioSolo;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioAgua;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPesquisador;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaGrandePorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaMedioPorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaPequenoPorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioReserva;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioSolo;

public class ControladoraReserva {

	IRepositorioReserva repositorioReserva;
	IRepositorioPesquisador repositorioPesquisador;
	IRepositorioSolo repositorioSolo;
	IRepositorioAgua repositorioAgua;
	IRepositorioPlantaGrandePorte repositorioPlantaGrandePorte;
	IRepositorioPlantaMedioPorte repositorioPlanataMedioPorte;
	IRepositorioPlantaPequenoPorte repositorioPlantaPequenaPorte;

	public ControladoraReserva() {
		this.repositorioReserva = new RepositorioReserva();
		this.repositorioPesquisador = new RepositorioPesquisador();
		this.repositorioSolo = new RepositorioSolo();
		this.repositorioAgua = new RepositorioAgua();
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorte();
		this.repositorioPlanataMedioPorte = new RepositorioPlantaMedioPorte();
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorte();
	}

	public void cadastrarReserva(Reserva reserva) {
		System.out.println("Passando pela controladora de reserva");
		// Aqui fazemos a chamada do repositorio no metodo cadastrar para
		// inserir no banco
		this.repositorioReserva.cadastrarReserva(reserva);

		// Aqui vamo ter um serie de laços por que temos varias listas
		// (listaPesquisadores,listaSolo,listaAgua e listaPlantas)
		// esse laços vão pegar cada item dessas listas enviar para seu
		// determinado repositorio

		// lista de pesquisadores
		for (Pesquisador pesquisador : reserva.getPesquisadores()) {
			this.repositorioPesquisador.cadastrarPesquisadores(pesquisador);
		}

		// lista de Plantas de pequeno porte
		for (PlantaPequenoPorte PlantaPequna : reserva.getListaPlantaPequena()) {
			this.repositorioPlantaPequenaPorte
					.cadastrarPlantaPequenoPorte(PlantaPequna);
		}

		// lista de plantas de medio porte
		for (PlantaMedioPorte plantaMedia : reserva.getListaPlantaMedia()) {
			this.repositorioPlanataMedioPorte
					.cadastrarPlantaMedioPorte(plantaMedia);
		}

		// lista de planta de grande porte
		for (PlantaGrandePorte plantaGrande : reserva.getListaPlantaGrande()) {
			this.repositorioPlantaGrandePorte
					.cadastrarPlantaGrandePorte(plantaGrande);
		}

		// lista de solos
		for (Solo solo : reserva.getSolos()) {
			this.repositorioSolo.cadastrarSolo(solo);
		}

		// lista de nascentes
		for (NascenteAgua agua : reserva.getNascenteAgua()) {
			this.repositorioAgua.cadastrarAgua(agua);
		}

	}

	public ArrayList<Reserva> listarReservas() {		
		System.out.println("Passando pelo listarReservas");
		return repositorioReserva.listarReserva();
	}

	public Reserva procurarReserva(int idReserva) {
		System.out.println("Passando pelo pelo procurarReserva");
		return this.repositorioReserva.procurarReserva(idReserva);
	}

	public void editarReserva(Reserva reserva) {
		System.out.println("Passando pelo editarReservas");
		this.repositorioReserva.editarReserva(reserva);
	}

	public void removerReserva(int idReserva) {
		System.out.println("Passando pelo removerReservas");
		this.repositorioReserva.removerReserva(idReserva);
	}

	public boolean existeReserva(int idReserva) {
		System.out.println("Passando pelo existeReserva");
		return this.repositorioReserva.existeReserva(idReserva);
	}
}
