package com.fafica.projeto_pi.repositorio.irepositorio;

import com.fafica.projeto_pi.modelos.Reserva;

public interface IRepositorioReserva {

	public void cadastrarReserva(Reserva reserva);
	public Reserva procurarReserva(int id);
	public void listarReserva();
	public void editarReserva(Reserva reserva);
	public void removerReserva(int id);
	public boolean existeReserva(int id);
}
