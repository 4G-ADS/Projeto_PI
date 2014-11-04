package com.fafica.projeto_pi.main;

import java.awt.Image;import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;

public class TesteCadastrar {

	public static void main(String[] args) {

		Fachada fachada = Fachada.getInstace();
				
		ArrayList <Pesquisador> listaPesquisadores = new ArrayList<Pesquisador>();
		Pesquisador p1 = new Pesquisador( 01, "joao", "123.123.123-12", 20, "Geologo");
		Pesquisador p2 = new Pesquisador( 02, "Paulo", "456.456.456-45", 20, "Biologo");
		Pesquisador p3 = new Pesquisador( 03, "Erico", "789.789.789-78", 20, "Biologo");
		listaPesquisadores.add(p1);
		listaPesquisadores.add(p2);
		listaPesquisadores.add(p3);
		
		ArrayList <Solo> listaSolos = new ArrayList<Solo>();
		Solo s1 = new Solo(01, "Arrenoso", 155, "Sem recursos");
		Solo s2 = new Solo(02, "Rochoso", 150, "Sem recursos");
		Solo s3 = new Solo(01, "Rochoso", 50, "Minerio de ferro");
		listaSolos.add(s1);
		listaSolos.add(s2);
		listaSolos.add(s3);		
		
		ArrayList <NascenteAgua> listaNascentes = new ArrayList<NascenteAgua>();
		NascenteAgua nA1 = new NascenteAgua(01, 22, 122, "Fonte Serra1", "Agua Doce");
		NascenteAgua nA2 = new NascenteAgua(02, 222, 121, "Fonte Serra1", "Agua Doce");
		NascenteAgua nA3 = new NascenteAgua(03, 2222, 1222, "Fonte Serra1", "Agua Doce");
		listaNascentes.add(nA1);
		listaNascentes.add(nA2);
		listaNascentes.add(nA3);
		
		ArrayList <PlantaPequenoPorte> listaPlantaPequenoPorte = new ArrayList<PlantaPequenoPorte>();
		ImageIcon importImagem = new ImageIcon("/Projeto_Pi/Imgens");
		Image imagem = importImagem.getImage();
		PlantaPequenoPorte pPP = new PlantaPequenoPorte("planta", "plantaPequena", 2.2);
		listaPlantaPequenoPorte.add(pPP);
		
		ArrayList <PlantaMedioPorte> listaPlantaMedioPorte = new ArrayList<PlantaMedioPorte>();
		PlantaMedioPorte pMP = new PlantaMedioPorte("planta", "PlantaMedia", 4.3);
		listaPlantaMedioPorte.add(pMP);
		
		ArrayList <PlantaGrandePorte> listaPlantaGrandePorte = new ArrayList<PlantaGrandePorte>();
		PlantaGrandePorte pGP = new PlantaGrandePorte( "planta", "PlantaGrande", 10.3);
		listaPlantaGrandePorte.add(pGP);
		
		Reserva reserva = new Reserva("Tropical", "Serra1", 35.5, 332, 232);
	
		reserva.setListaPlantaPequena(listaPlantaPequenoPorte);
		reserva.setListaPlantaMedia(listaPlantaMedioPorte);
		reserva.setListaPlantaGrande(listaPlantaGrandePorte);
		reserva.setSolos(listaSolos);
		reserva.setNascenteAgua(listaNascentes);
		reserva.setPesquisadores(listaPesquisadores);	 
		
		Instituicao instituicao = new Instituicao("Vale2", "mineradora", "123.123.123/12-12");
		
		
		try {
			fachada.cadastrarReservaCaracteristicas(reserva);
			
			instituicao.setIdReserva(reserva.getIdReserva());			
			fachada.cadastrarInstituicao(instituicao);
			
			p1.setIdReserva(reserva.getIdReserva());
			p2.setIdReserva(reserva.getIdReserva());
			p3.setIdReserva(reserva.getIdReserva());
			fachada.cadastrarPesquisadores(reserva);
			
			nA1.setIdReserva(reserva.getIdReserva());
			nA2.setIdReserva(reserva.getIdReserva());
			nA3.setIdReserva(reserva.getIdReserva());
			fachada.cadastrarNascente(reserva);
			
			s1.setIdReserva(reserva.getIdReserva());
			s2.setIdReserva(reserva.getIdReserva());
			s3.setIdReserva(reserva.getIdReserva());
			fachada.cadastrarSolo(reserva);
			
			pPP.setIdReserva(reserva.getIdReserva());
			fachada.cadastrarPlantaPequenoPorte(reserva);
			
			pMP.setIdReserva(reserva.getIdReserva());
			fachada.cadastrarPlantaMedioPorte(reserva);
			
			pGP.setIdReserva(reserva.getIdReserva());
			fachada.cadastrarPlantaGrandePorte(reserva);

			
			
			System.out.println("Teste concluido com sucesso");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Deu erro - Porra");
		}

	}

}
