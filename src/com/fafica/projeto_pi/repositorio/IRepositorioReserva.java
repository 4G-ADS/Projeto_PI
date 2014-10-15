package com.fafica.projeto_pi.repositorio;

public interface IRepositorioReserva {

	public void cadastrar(Reserva reserva);
	public Reserva procurar(int id);
	public void atualizar(Reserva reserva);
	public void remover(int id);
	public boolean existe(int id);
}
