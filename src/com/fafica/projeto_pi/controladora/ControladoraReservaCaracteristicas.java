package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.ReservaCaracteristicas;
import com.fafica.projeto_pi.modelos.ReservaRecursos;

import com.fafica.projeto_pi.repositorio.RepositorioReservaCaracteristicas;

import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioReservaCaracteristicas;

public class ControladoraReservaCaracteristicas {

	IRepositorioReservaCaracteristicas repositorioReservaCaracteristicas;

	public ControladoraReservaCaracteristicas() throws Exception {
		this.repositorioReservaCaracteristicas = new RepositorioReservaCaracteristicas();

	}

	public void cadastrarReservaCaracteristicas(
			ReservaCaracteristicas reservaCaracteristicas) throws SQLException {
		System.out.println("Passando pela controladora de reserva");
		// Aqui fazemos a chamada do repositorio no metodo cadastrar para
		// inserir no banco
		this.repositorioReservaCaracteristicas
				.cadastrarReservaCaracteristicas(reservaCaracteristicas);

	}

	public ArrayList<ReservaCaracteristicas> listarReservaCaracteristicas()
			throws SQLException {
		System.out.println("Passando pelo listarReservas");
		return repositorioReservaCaracteristicas.listarReservaCaracteristicas();
	}

	public ReservaRecursos procurarReservaCaracteristicas(int idReserva) {
		System.out.println("Passando pelo pelo procurarReserva");
		return this.repositorioReservaCaracteristicas
				.procurarReservaCaracteristicas(idReserva);
	}

	public void editarReservaCaracteristicas(
			ReservaCaracteristicas reservaCaracteristicas) {
		System.out.println("Passando pelo editarReservas");
		this.repositorioReservaCaracteristicas
				.editarReservaCaracteristicas(reservaCaracteristicas);
	}

	public void removerReservaCaracteristicas(int idReserva) {
		System.out.println("Passando pelo removerReservas");
		this.repositorioReservaCaracteristicas
				.removerReservaCaracteristicas(idReserva);
	}

	public boolean existeReservaCaracteristicas(int idReserva) {
		System.out.println("Passando pelo existeReserva");
		return this.repositorioReservaCaracteristicas
				.existeReservaCaracteristicas(idReserva);
	}
}
