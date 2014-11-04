package com.fafica.projeto_pi.repositorio.irepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Reserva;

public interface IRepositorioReserva {

	public void cadastrarReserva(Reserva reserva) throws SQLException;
	public Reserva procurarReserva(int idReserva) throws SQLException;
	public ArrayList<Reserva> listarReserva() throws SQLException;
	public void editarReserva(Reserva reserva) throws SQLException;
	public void removerReserva(int idReserva) throws SQLException;
	public boolean existeReserva(int idReserva);
}
