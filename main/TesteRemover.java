package com.fafica.projeto_pi.main;

import com.fafica.projeto_pi.fachada.Fachada;

public class TesteRemover {

	public static void main(String[] args) {
	
		Fachada fachada = Fachada.getInstace();
		
		try {
	//ok->		fachada.removerInsituicao(1);
	//ok->		fachada.removerNascente(1);
	//ok->		fachada.removerPesquisador(1);
	//ok->		fachada.removerSolo(2);
	//??		fachada.removerReservaCaracteristicas(1);
	//ok->		fachada.removerPlantaPequenoPorte(1);
	//ok->		fachada.removerPlantaMedioPorte(1);
	//ok->		fachada.removerPlantaGrandePorte(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
