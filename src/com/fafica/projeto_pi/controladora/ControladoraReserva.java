package com.fafica.projeto_pi.controladora;

import java.util.ArrayList;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorio.RepositorioReserva;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioReserva;

public class ControladoraReserva {

	private IRepositorioReserva repositorioReserva;
	
	public ControladoraReserva(){
		this.repositorioReserva = new RepositorioReserva();
	}
	
	public void cadastrarReserva(Reserva reserva){
		System.out.println("Panssando pelo cadastrarReserva em controladoraReserva");
		this.repositorioReserva.cadastrarReserva(reserva);
	}
	
	public ArrayList<Reserva> listarReservas(){
		System.out.println("Panssando pelo listarReserva em controladoraReserva");
		return repositorioReserva.listarReserva();
	}
	
	public Reserva procurarReserva(int idReserva){
		System.out.println("Panssando pelo procurarReserva em controladoraReserva");
		return this.repositorioReserva.procurarReserva(idReserva);
	}
	
	public void editarReserva(int idReserva){
		System.out.println("Panssando pelo editarReserva em controladoraReserva");
		this.repositorioReserva.removerReserva(idReserva);
	}
	
	public void removerReserva(int idReserva){
		System.out.println("Panssando pelo removerReserva em controladoraReserva");
		this.repositorioReserva.removerReserva(idReserva);
	}
	
	public boolean existeReseva(int idReserva){
		return this.repositorioReserva.existeReserva(idReserva);
	}
	
}
