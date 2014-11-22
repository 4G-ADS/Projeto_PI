package com.fafica.projeto_pi.main;

import java.util.ArrayList;

import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.modelos.Administrador;

public class TesteListar1 {

	public static void main(String[] args) {
		
		
		
		Fachada fachada = Fachada.getInstace();
		try{
// ok->	ArrayList<Instituicao> lista1 = fachada.listarInstituicao();
// ok->	ArrayList<Reserva> listaReservas = fachada.listarReserva();

		Reserva reserva = fachada.procurarReserva(14);	
			
//	falta	ArrayList<Usuario> listaUsuarios = fachada.listarUsuario();
//		
//		
//				
//		for (Instituicao instituicao : lista1) {
//		System.out.println(instituicao.toString());
//	}
//		for (Reserva reservas : listaReservas) {
//		System.out.println(reservas.toString());
//	}		
		for (Pesquisador pesquisador : reserva.getPesquisadores()) {
		System.out.println(pesquisador.toString());
	}	
		for (Solo solo : reserva.getSolos()) {
		System.out.println(solo.toString());
	}		
		for (NascenteAgua nascenteAgua : reserva.getNascenteAgua()) {
		System.out.println(nascenteAgua.toString());
	}
		for (PlantaPequenoPorte plantaPequenoPorte : reserva.getListaPlantaPequena()) {
		System.out.println(plantaPequenoPorte.toString());
	}
		for (PlantaMedioPorte plantaMedioPorte : reserva.getListaPlantaMedia()) {
		System.out.println(plantaMedioPorte.toString());
	}
		for (PlantaGrandePorte plantaGrandePorte : reserva.getListaPlantaGrande()) {
		System.out.println(plantaGrandePorte.toString());
	}
		
//			for(Usuario usuario : listaUsuarios) {
//				System.out.println(usuario.toString());
//			}		


		}catch(Exception e){
			System.err.println("Deu Erro main");
			e.printStackTrace();
		}
		
		
	}

}

