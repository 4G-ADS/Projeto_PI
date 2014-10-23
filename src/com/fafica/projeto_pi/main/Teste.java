package com.fafica.projeto_pi.main;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.w3c.dom.ls.LSInput;

import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;

public class Teste {

	public static void main(String[] args) {

		Fachada fachada = Fachada.getInstace();
		
		ArrayList <Pesquisador> listaPesquisadores = new ArrayList<Pesquisador>();
		Pesquisador p1 = new Pesquisador(01, 01, "joao", "123.123.123-12", 20, "Geologo");
		Pesquisador p2 = new Pesquisador(01, 02, "Paulo", "456.456.456-45", 20, "Biologo");
		Pesquisador p3 = new Pesquisador(01, 03, "Ercoi", "789.789.789-78", 20, "Biologo");
		listaPesquisadores.add(p1);
		listaPesquisadores.add(p2);
		listaPesquisadores.add(p3);
		
		ArrayList <Solo> listaSolos = new ArrayList<Solo>();
		Solo s1 = new Solo(01, 01, "Arrenoso", 15.5, "Sem recursos");
		Solo s2 = new Solo(01, 02, "Rochoso", 15.0, "Sem recursos");
		Solo s3 = new Solo(01, 01, "Rochoso", 5.0, "Minerio de ferro");
		listaSolos.add(s1);
		listaSolos.add(s2);
		listaSolos.add(s3);		
		
		ArrayList <NascenteAgua> listaNascentes = new ArrayList<NascenteAgua>();
		NascenteAgua nA1 = new NascenteAgua(01, 01, 2222.12, 1212.22, "Fonte Serra1", "Agua Doce");
		NascenteAgua nA2 = new NascenteAgua(01, 02, 2222.12, 1212.22, "Fonte Serra1", "Agua Doce");
		NascenteAgua nA3 = new NascenteAgua(01, 03, 2222.12, 1212.22, "Fonte Serra1", "Agua Doce");
		listaNascentes.add(nA1);
		listaNascentes.add(nA2);
		listaNascentes.add(nA3);
		
		ArrayList <PlantaPequenoPorte> listaPlantaPequenoPorte = new ArrayList<PlantaPequenoPorte>();
		ImageIcon importImagem = new ImageIcon("/Projeto_Pi/Imgens");
		Image imagem = importImagem.getImage();
		PlantaPequenoPorte pPP = new PlantaPequenoPorte(01, 01, "", "plantaPequena", 2.2, imagem, 01);
		listaPlantaPequenoPorte.add(pPP);
		
		ArrayList <PlantaMedioPorte> listaPlantaMedioPorte = new ArrayList<PlantaMedioPorte>();
		PlantaMedioPorte pMP = new PlantaMedioPorte(01, 02, "", "PlantaMedia", 4.3, imagem, 01);
		listaPlantaMedioPorte.add(pMP);
		
		ArrayList <PlantaGrandePorte> listaPlantaGrandePorte = new ArrayList<PlantaGrandePorte>();
		PlantaGrandePorte pGP = new PlantaGrandePorte(01, 03, "", "PlantaGrande", 10.3, imagem, 01);
		listaPlantaGrandePorte.add(pGP);
		
		Reserva reserva = new Reserva(01, "Tropical", "Serra1", 35.5, 333322.12, 2323213.2,
				listaPlantaPequenoPorte, listaPlantaMedioPorte, listaPlantaGrandePorte,
				listaSolos, listaNascentes, listaPesquisadores);
		
		fachada.cadastrarReserva(reserva);

	}

}
