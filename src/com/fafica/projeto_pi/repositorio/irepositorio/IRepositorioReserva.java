package com.fafica.projeto_pi.repositorio.irepositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Reserva;

public interface IRepositorioReserva {

	public void cadastrarReserva(Reserva reserva);
	public Reserva procurarReserva(int idReserva);
	public ArrayList<Reserva> listarReserva();
	public void editarReserva(Reserva reserva);
	public void removerReserva(int idReserva);
	public boolean existeReserva(int idReserva);
}
