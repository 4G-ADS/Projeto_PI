package com.fafica.projeto_pi.controladora;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.repositorio.RepositorioSolo;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioSolo;

public class ControladoraSolos {
	
	private IRepositorioSolo repositorioSolo;
	
	public ControladoraSolos(){
		
		this.repositorioSolo = new RepositorioSolo();
	}

	public void cadastrarSolo(Reserva reserva){
		System.out.println("Panssando pelo cadastrarSolo em controladoraSolo");
		for (Solo solo : reserva.getSolos()) {
			this.repositorioSolo.cadastrarSolo(solo);
		}
	}

	public ArrayList<Solo> listarSolos(){
		System.out.println("Panssando pelo listarSolo em controladoraSolo");
		return this.repositorioSolo.listarSolo();
	}
	
	public Solo editarSolos(Solo solo){
		System.out.println("Panssando pelo editarSolo em controladoraSolo");
		this.repositorioSolo.editarSolo(solo);
		return solo;
	}
	
	public void procurarSolos(int idSolo){
		System.out.println("Panssando pelo procurarSolo em controladoraSolo");
		this.repositorioSolo.procurarSolo(idSolo);
		
	}
	
	public void removerSolo(int idSolo){
		System.out.println("Panssando pelo removerSolo em controladoraSolo");
		this.repositorioSolo.removerSolo(idSolo);
	}
	
	
	public boolean existiSolo(int idSolo){
		System.out.println("Panssando pelo existiSolo em controladoraSolo");
		return this.repositorioSolo.existeSolo(idSolo);
	}
	
}
