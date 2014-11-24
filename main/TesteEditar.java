package com.fafica.projeto_pi.main;

import java.sql.SQLException;

import com.fafica.projeto_pi.excecoes.PesquisadorNaoEncontradoException;
import com.fafica.projeto_pi.excecoes.ReservaNaoEncontradaException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;

public class TesteEditar {

	public static void main(String[] args) {
		
		Fachada fachada = Fachada.getInstace();
		
		Instituicao instituicao = new Instituicao(2, "Moura", "Industria", "321.321.321/12-12");
		NascenteAgua agua = new NascenteAgua(2, 123, 321, "caca", "salgada");
		Pesquisador pesquisador = new Pesquisador(3, "viado", "123.123.123-12", 0, "Boiola");
		Solo solo = new Solo(3, "Arrenoso", 50, "");
		Reserva reserva = new Reserva(16, "Quente", "inferno", 666, 666, 666);
		Administrador administrador = new Administrador("joao200", "joao200joao", "104.845.104-60", 123);

			
			try {
				fachada.editarReserva(reserva);
				fachada.editarInstituicao(instituicao);
				fachada.editarNascente(agua);
				fachada.editarPesquisador(pesquisador);
				fachada.editarSolo(solo);
				fachada.editarAdministrador(administrador);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ReservaNaoEncontradaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PesquisadorNaoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

	}

}
