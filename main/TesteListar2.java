package com.fafica.projeto_pi.main;

import java.util.ArrayList;

import javax.swing.plaf.metal.MetalBorders.PaletteBorder;

import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Solo;

public class TesteListar2 {

	public static void main(String[] args) {
	Fachada fachada = Fachada.getInstace();
		
		try {
//			ArrayList<Instituicao> lista = fachada.listarInstituicao(1);
//			ArrayList<NascenteAgua> listaAgua = fachada.listarNascente(4);
//			ArrayList<Pesquisador> listaPesquisador = fachada.listarPesquisador(4);
//			ArrayList<Solo> listaSolos = fachada.listarSolo(4);
//			ArrayList<PlantaGrandePorte> listaPlantasGrandes = fachada.listarPlantaGrande(4);
//			ArrayList<PlantaMedioPorte> listaPlantasMedio = fachada.listarPlantaMedia(4);
			ArrayList<PlantaPequenoPorte> listaPlantasPequena = fachada.listarPlantaPequena(15);
//			ArrayList<Administrador> listaAdm = fachada.listarAdministrador();
			
//			for (Administrador administrador : listaAdm) {
//				System.out.println(administrador.toString());
//			}
//			
//			for (Instituicao instituicao : lista) {
//				System.out.println(instituicao.toString());
//			}
//			
//			for (NascenteAgua nascenteAgua : listaAgua) {
//				System.out.println(nascenteAgua.toString());
//			}
//			
//			for (Pesquisador pesquisador : listaPesquisador) {
//				System.out.println(pesquisador.toString());
//			}
//			
//			for (Solo solo : listaSolos) {
//				System.out.println(solo.toString());
//			}
			
			for (PlantaPequenoPorte planta : listaPlantasPequena) {
			System.out.println(planta.getIdPlantaPequenaPorte());
		}		
		
//			for (PlantaGrandePorte plantaGrandePorte : listaPlantasGrandes) {
//				System.out.println(plantaGrandePorte.toString());
//			}
//			
//			for (PlantaMedioPorte plantaMedioPorte : listaPlantasMedio) {
//				System.out.println(plantaMedioPorte.toString());
//			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}

	}

}
