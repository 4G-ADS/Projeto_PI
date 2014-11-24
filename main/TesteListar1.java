package com.fafica.projeto_pi.main;

import java.io.IOException;
import java.sql.SQLException;
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
	
		try {
			ArrayList<Instituicao> lista1 = fachada.listarInstituicao();
 			Reserva reserva = fachada.procurarReserva(15);			
			ArrayList<Administrador> listaAdministrador = fachada.listarAdministrador();
			
			
					
			for (Instituicao instituicao : lista1) {
			System.out.println(instituicao.toString());
		}

			for (Administrador administrador : listaAdministrador) {
			System.out.println(administrador.toString());	
			}
			
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

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}

}

