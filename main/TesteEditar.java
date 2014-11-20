package com.fafica.projeto_pi.main;

import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;

public class TesteEditar {

	public static void main(String[] args) {
		
		Fachada fachada = Fachada.getInstace();
		
//ok->	Instituicao instituicao = new Instituicao(2, "Moura", "Industria", "321.321.321/12-12");
//ok->	NascenteAgua agua = new NascenteAgua(2, 123, 321, "caca", "salgada");
//ok->	Pesquisador pesquisador = new Pesquisador(3, "viado", "123.123.123-12", 0, "Boiola");
//ok->	Solo solo = new Solo(3, "Arrenoso", 50, "");
///		Reserva reserva = new Reserva(2, "Quente", "inferno", 666, 666, 666);
		try {
//			fachada.editarInstituicao(instituicao);
//			fachada.editarNascente(agua);
//			fachada.editarPesquisador(pesquisador);
//			fachada.editarSolo(solo);
//			fachada.editarReservaCaracteristicas(reserva);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
