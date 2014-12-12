package com.fafica.projeto_pi.controladora;

import java.sql.SQLException;
import java.util.ArrayList;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.excecoes.PesquisadorNaoEncontradoException;
import com.fafica.projeto_pi.excecoes.ReservaNaoEncontradaException;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorioBDR.RepositorioReservaBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioReserva;

public class ControladoraReserva {

	IRepositorioReserva repositorioReserva;

	public ControladoraReserva() throws Exception {
		this.repositorioReserva = new RepositorioReservaBDR();

	}

	public void cadastrarReserva(Reserva reserva) throws SQLException,
			CampoObritarorioInvalidoException {
		System.out.println("Passando pela controladora de reserva");
		// Aqui fazemos a chamada do repositorio no metodo cadastrar para
		// inserir no banco

		if (reserva.getIdReserva() == 0) {

			this.repositorioReserva.cadastrarReserva(reserva);

		}

	}

	public ArrayList<Reserva> listarReserva() throws SQLException,
			ReservaNaoEncontradaException {
		System.out.println("Passando pela controladora listarReservas");
		return repositorioReserva.listarReserva();
	}

	public Reserva procurarReserva(int idReserva) throws SQLException,
			ReservaNaoEncontradaException, PesquisadorNaoEncontradoException {
		System.out.println("Passando pelo pelo procurarReserva");
		return this.repositorioReserva.procurarReserva(idReserva);
	}

	public void editarReserva(Reserva reserva) throws SQLException,
			ReservaNaoEncontradaException, PesquisadorNaoEncontradoException {
		System.out.println("Passando pelo editarReservas");
		this.repositorioReserva.editarReserva(reserva);
	}

	public void removerReserva(int idReserva) throws SQLException,
			ReservaNaoEncontradaException, PesquisadorNaoEncontradoException {
		System.out.println("Passando pelo removerReservas");
		this.repositorioReserva.removerReserva(idReserva);
	}

}
