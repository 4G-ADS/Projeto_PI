package com.fafica.projeto_pi.main;

import java.util.ArrayList;

import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Administrador;
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


				
		ArrayList <Pesquisador> pesquisadores = new ArrayList<Pesquisador>();
		Pesquisador p1 = new Pesquisador( 01, "joao", "123.123.123-12", 20, "Geologo");
		Pesquisador p2 = new Pesquisador( 02, "Paulo", "456.456.456-45", 20, "Biologo");
		Pesquisador p3 = new Pesquisador( 03, "Erico", "789.789.789-78", 20, "Biologo");
		pesquisadores.add(p1);
		pesquisadores.add(p2);
		pesquisadores.add(p3);
		
		ArrayList <Solo> solos = new ArrayList<Solo>();
		Solo s1 = new Solo(01, "Arrenoso", 155, "Sem recursos");
		Solo s2 = new Solo(02, "Rochoso", 150, "Sem recursos");
		Solo s3 = new Solo(01, "Rochoso", 50, "Minerio de ferro");
		solos.add(s1);
		solos.add(s2);
		solos.add(s3);		
		
		ArrayList <NascenteAgua> nascenteAgua = new ArrayList<NascenteAgua>();
		NascenteAgua nA1 = new NascenteAgua(01, 22, 122, "Fonte Serra1", "Agua Doce");
		NascenteAgua nA2 = new NascenteAgua(02, 222, 121, "Fonte Serra1", "Agua Doce");
		NascenteAgua nA3 = new NascenteAgua(03, 2222, 1222, "Fonte Serra1", "Agua Doce");
		nascenteAgua.add(nA1);
		nascenteAgua.add(nA2);
		nascenteAgua.add(nA3);
		
		ArrayList <PlantaPequenoPorte> listaPlantaPequena = new ArrayList<PlantaPequenoPorte>();
		PlantaPequenoPorte pPP = new PlantaPequenoPorte("planta", "plantaPequena", 2.2);
		listaPlantaPequena.add(pPP);
		
		ArrayList <PlantaMedioPorte> listaPlantaMedia = new ArrayList<PlantaMedioPorte>();
		PlantaMedioPorte pMP = new PlantaMedioPorte("planta", "PlantaMedia", 4.3);
		listaPlantaMedia.add(pMP);
		
		ArrayList <PlantaGrandePorte> listaPlantaGrande = new ArrayList<PlantaGrandePorte>();
		PlantaGrandePorte pGP = new PlantaGrandePorte( "planta", "PlantaGrande", 10.3);
		listaPlantaGrande.add(pGP);
		
		Reserva reserva = new Reserva("", "", 0, 0, 0, 
				listaPlantaPequena, listaPlantaMedia, listaPlantaGrande, solos, nascenteAgua, pesquisadores);	 
		
		Instituicao instituicao = new Instituicao("Vale2", "mineradora", "123.123.123/12-12");
		
		Administrador adm = new Administrador("joao", "joao","123.123.123-12",1223);
		
		try {
			Fachada.getInstace().cadastrarReserva(reserva);
			
			instituicao.setIdReserva(reserva.getIdReserva());			
			Fachada.getInstace().cadastrarInstituicao(instituicao);			
			
			Fachada.getInstace().cadastrarAdministrardor(adm);
			
//			ArrayList<Administrador> lista = Fachada.getInstace().listarAdministrador();
//			for (Administrador admin : lista) {
//				System.out.println(admin.toString());
//			}
			System.out.println("Teste concluido com sucesso");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Deu erro - Porra");
		}

	}

}
