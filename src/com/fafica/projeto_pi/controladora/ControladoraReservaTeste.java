package com.fafica.projeto_pi.controladora;

import java.util.ArrayList;
import com.fafica.projeto_pi.modelos.Agua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Planta;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.repositorio.RepositorioAgua;
import com.fafica.projeto_pi.repositorio.RepositorioPesquisador;
import com.fafica.projeto_pi.repositorio.RepositorioPlantaGrandePorte;
import com.fafica.projeto_pi.repositorio.RepositorioPlantaMedioPorte;
import com.fafica.projeto_pi.repositorio.RepositorioPlantaPequenoPorte;
import com.fafica.projeto_pi.repositorio.RepositorioReserva;
import com.fafica.projeto_pi.repositorio.RepositorioSolo;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioAgua;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPesquisador;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaGrandePorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaMedioPorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioPlantaPequenoPorte;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioReserva;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioSolo;

public class ControladoraReservaTeste {
	
	IRepositorioReserva repositorioReserva;
	IRepositorioPesquisador repositorioPesquisador;
	IRepositorioSolo repositorioSolo;
	IRepositorioAgua repositorioAgua;
	IRepositorioPlantaGrandePorte repositorioPlantaGrandePorte;
	IRepositorioPlantaMedioPorte repositorioPlanataMedioPorte;
	IRepositorioPlantaPequenoPorte repositorioPlantaPequenaPorte;
	
	public ControladoraReservaTeste(){
		this.repositorioReserva = new RepositorioReserva();
		this.repositorioPesquisador = new RepositorioPesquisador();
		this.repositorioSolo = new RepositorioSolo();
		this.repositorioAgua = new RepositorioAgua();
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorte();
		this.repositorioPlanataMedioPorte = new RepositorioPlantaMedioPorte();
		this.repositorioPlantaPequenaPorte = new RepositorioPlantaPequenoPorte();
	}
	
	public void cadastrar(Reserva reserva){
		
		//Aqui fazemos a chamada do repositorio no metodo cadastrar para inserir no banco
		this.repositorioReserva.cadastrarReserva(reserva);
		
		//Aqui vamo ter um serie de laços por que temos varias listas (listaPesquisadores,listaSolo,listaAgua e listaPlantas)
		//esse laços vão pegar cada item dessas listas enviar para seu determinado repositorio 
		
		//lista de pesquisadores
		for (Pesquisador pesquisador : reserva.getPesquisadores()) {
			this.repositorioPesquisador.cadastrarPesquisadores(pesquisador);
		}
		
		for (Planta planta : reserva.getPlantas()) {
			
//			if(){
//				this.repositorioPlantaPequenaPorte.cadastrarPlantaPequenoPorte(plantapequena);
//			}else if(){
//				this.repositorioPlanataMedioPorte.cadastrarPlantaMedioPorte(plantamedia);
//			}else if(){
//				this.repositorioPlantaGrandePorte.cadastrarPlantaGrandePorte(plantagrande);
//			}
			
		}
		
		//lista de solos
		for (Solo solo : reserva.getSolos()) {
			this.repositorioSolo.cadastrarSolo(solo);
		}
		
		//lista de nascentes
		for (Agua agua : reserva.getAgua()) {
			this.repositorioAgua.cadastrarAgua(agua);
		}
				
	}
	
		public ArrayList<Reserva> listarReservas(){
		return repositorioReserva.listarReserva();
	}
		
		public Reserva procurarReserva(int idReserva){
			return this.repositorioReserva.procurarReserva(idReserva);
		}
	
		public void editarReserva(Reserva reserva){
			this.repositorioReserva.editarReserva(reserva);
		}
		
		public void removerReserva(int idReserva){
			this.repositorioReserva.removerReserva(idReserva);
		}
		
		public boolean existeReserva(int idReserva){
			return this.repositorioReserva.existeReserva(idReserva);
		}
}
