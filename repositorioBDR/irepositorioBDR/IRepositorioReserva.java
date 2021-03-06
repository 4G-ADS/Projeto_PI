package com.fafica.projeto_pi.repositorioBDR.irepositorioBDR;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.ReservaNaoEncontradaException;
import com.fafica.projeto_pi.modelos.Reserva;

public interface IRepositorioReserva {

	public void cadastrarReserva(Reserva reserva) throws SQLException;
	public Reserva procurarReserva(int idReserva) throws SQLException,ReservaNaoEncontradaException;
	public ArrayList<Reserva> listarReserva() throws SQLException, ReservaNaoEncontradaException;
	public void editarReserva(Reserva reserva) throws SQLException, ReservaNaoEncontradaException;
	public void removerReserva(int idReserva) throws SQLException, ReservaNaoEncontradaException;
}
