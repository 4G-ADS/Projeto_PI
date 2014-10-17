package com.fafica.projeto_pi.repositorio;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioReserva;

public class RepositorioReserva implements IRepositorioReserva{

	@Override
	public void cadastrarReserva(Reserva reserva) {
		System.out.println("Chegando ao repositorio cadastrarReserva");
		
	}

	@Override
	public Reserva procurarReserva(int id) {
		System.out.println("Chegando ao repositorio procurarReserva");
		return null;
	}

	@Override
	public ArrayList<Reserva> listarReserva() {
		System.out.println("Chegando ao repositorio listarReserva");
		return null;
		
	}

	@Override
	public void editarReserva(Reserva reserva) {
		System.out.println("Chegando ao repositorio atualizarReserva");
		
	}

	@Override
	public void removerReserva(int id) {
		System.out.println("Chegando ao repositorio removerReserva");
		
	}

	@Override
	public boolean existeReserva(int id) {
		System.out.println("Chegando ao repositorio existeReserva");
		return false;
	}

}
