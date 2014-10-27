package com.fafica.projeto_pi.main;

import java.util.ArrayList;

import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.ReservaCaracteristicas;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.modelos.Usuario;

public class TesteListar {

	public static void main(String[] args) {
		
		
		
		Fachada fachada = Fachada.getInstace();
		try{
		ArrayList<Instituicao> lista = fachada.listarInstituicao();
//		ArrayList<ReservaCaracteristicas> listaReservas = fachada.listarReservaCaracteristicas();
//		ArrayList<Pesquisador> listaPesquisadores = fachada.listarPesquisador();
//		ArrayList<Solo> listaSolo = fachada.listarSolo();
//		ArrayList<NascenteAgua> listaNascente = fachada.listarNascente();
//		ArrayList<Usuario> listaUsuarios = fachada.listarUsuario();
//		ArrayList<PlantaPequenoPorte> listaPlantaPequena = fachada.listarPlantaPequena();
//		ArrayList<PlantaMediaPorte> listaPlantaMedia = fachada.listarPlantaMedia();
//		ArrayList<PlantaGrandePorte> listaPlantaGrande = fachada.listarPlantaGrande();
		
		
			
//			for(Usuario usuario : listaUsuarios) {
//				System.out.println(usuario.toString());
//			}
			
		for (Instituicao instituicao : lista) {
			System.out.println(instituicao.toString());
		}
		
//		for (NascenteAgua nascenteAgua : listaNascente) {
//			System.out.println(nascenteAgua.toString());
//		}
//		
//		for (ReservaCaracteristicas reservas : listaReservas) {
//			System.out.println(reservas.toString());
//		}
//		
//		for (Pesquisador pesquisador : listaPesquisadores) {
//			System.out.println(pesquisador.toString());
//		}
//		for (Solo solo : listaSolo) {
//			System.out.println(solo.toString());
//		}
		}catch(Exception e){
			System.err.println("Deu Erro main");
			e.printStackTrace();
		}
		
		
	}

}

