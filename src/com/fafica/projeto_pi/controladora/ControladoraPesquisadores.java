package com.fafica.projeto_pi.controladora;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorio.RepositorioPesquisador;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPesquisador;

public class ControladoraPesquisadores {
	
	IRepositorioPesquisador repositorioPesquisadores;
	
	public ControladoraPesquisadores(){
		this.repositorioPesquisadores =  new RepositorioPesquisador();
	}
	
	
	public void cadastrarPesquisadores(Reserva reserva){
		System.out.println("Panssando pelo cadastrarPesquisador em controladoraPesquisador");
		System.out.println("");
		for (Pesquisador pesquisador : reserva.getPesquisadores()) {
			
			this.repositorioPesquisadores.cadastrarPesquisadores(pesquisador);
		}
					
	}

	public ArrayList<Pesquisador> listaPesquisador(){
		System.out.println("Panssando pelo listarPesquisador em controladoraPesquisador");
		return this.repositorioPesquisadores.listarPesquisadores();
	}
	
	public Pesquisador procurarPesquisador(int idPesquisador){
		System.out.println("Panssando pelo procurarPesquisador em controladoraPesquisador");
		return this.repositorioPesquisadores.procurarPesquisadores(idPesquisador);
	}
	
	public void editarPesquisador(Pesquisador pesquisador){
		System.out.println("Panssando pelo editarPesquisador em controladoraPesquisador");
		this.repositorioPesquisadores.editarPesquisadores(pesquisador);
	}
	
	public void removerPesquisador(int idPesquisador){
		System.out.println("Panssando pelo removerPesquisador em controladoraPesquisador");
		this.repositorioPesquisadores.removerPesquisadores(idPesquisador);
	}
	
	public boolean exitePesquisador(int idPesquisador){
		System.out.println("Panssando pelo exitePesquisador em controladoraPesquisador");
		return this.repositorioPesquisadores.existePesquisadores(idPesquisador);
	}
}
