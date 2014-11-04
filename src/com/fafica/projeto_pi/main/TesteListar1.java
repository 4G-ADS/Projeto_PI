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
import com.fafica.projeto_pi.modelos.Usuario;

public class TesteListar1 {

	public static void main(String[] args) {
		
		
		
		Fachada fachada = Fachada.getInstace();
		try{
// ok->	ArrayList<Instituicao> lista1 = fachada.listarInstituicao();
// ok->	ArrayList<Reserva> listaReservas = fachada.listarReservaCaracteristicas();
// ok->	ArrayList<Pesquisador> listaPesquisadores = fachada.listarPesquisador();
// ok->	ArrayList<Solo> listaSolo = fachada.listarSolo();
// ok->	ArrayList<NascenteAgua> listaNascente = fachada.listarNascente();
// ok->	ArrayList<PlantaPequenoPorte> listaPlantaPequena = fachada.listarPlantaPequena();
// ok->	ArrayList<PlantaMedioPorte> listaPlantaMedia = fachada.listarPlantaMedia();
// ok->	ArrayList<PlantaGrandePorte> listaPlantaGrande = fachada.listarPlantaGrande();
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
//		for (Pesquisador pesquisador : listaPesquisadores) {
//		System.out.println(pesquisador.toString());
//	}	
//		for (Solo solo : listaSolo) {
//		System.out.println(solo.toString());
//	}		
//		for (NascenteAgua nascenteAgua : listaNascente) {
//		System.out.println(nascenteAgua.toString());
//	}
//		for (PlantaPequenoPorte plantaPequenoPorte : listaPlantaPequena) {
//		System.out.println(plantaPequenoPorte.toString());
//	}
//		for (PlantaMedioPorte plantaMedioPorte : listaPlantaMedia) {
//		System.out.println(plantaMedioPorte.toString());
//	}
//		for (PlantaGrandePorte plantaGrandePorte : listaPlantaGrande) {
//		System.out.println(plantaGrandePorte.toString());
//	}
		
//			for(Usuario usuario : listaUsuarios) {
//				System.out.println(usuario.toString());
//			}		
//		

//		

//		


		}catch(Exception e){
			System.err.println("Deu Erro main");
			e.printStackTrace();
		}
		
		
	}

}

