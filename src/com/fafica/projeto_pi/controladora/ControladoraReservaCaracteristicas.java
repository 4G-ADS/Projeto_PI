package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Reserva;

import com.fafica.projeto_pi.repositorio.RepositorioReservaCaracteristicas;

import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioReserva;

public class ControladoraReservaCaracteristicas {

	IRepositorioReserva repositorioReserva;

	public ControladoraReservaCaracteristicas() throws Exception {
		this.repositorioReserva = new RepositorioReservaCaracteristicas();

	}

	public void cadastrarReservaCaracteristicas(
			Reserva reserva) throws SQLException {
		System.out.println("Passando pela controladora de reserva");
		// Aqui fazemos a chamada do repositorio no metodo cadastrar para
		// inserir no banco
		this.repositorioReserva
				.cadastrarReserva(reserva);

	}

	public ArrayList<Reserva> listarReservaCaracteristicas()
			throws SQLException {
		System.out.println("Passando pelo listarReservas");
		return repositorioReserva.listarReserva();
	}

	public Reserva procurarReservaCaracteristicas(int idReserva) throws SQLException{
		System.out.println("Passando pelo pelo procurarReserva");
		return this.repositorioReserva.procurarReserva(idReserva);
	}

	public void editarReservaCaracteristicas(
			Reserva reserva) throws SQLException {
		System.out.println("Passando pelo editarReservas");
		this.repositorioReserva.editarReserva(reserva);
	}

	public void removerReservaCaracteristicas(int idReserva) throws SQLException {
		System.out.println("Passando pelo removerReservas");
		this.repositorioReserva
				.removerReserva(idReserva);
	}

	public boolean existeReservaCaracteristicas(int idReserva) {
		System.out.println("Passando pelo existeReserva");
		return this.repositorioReserva
				.existeReserva(idReserva);
	}
}
