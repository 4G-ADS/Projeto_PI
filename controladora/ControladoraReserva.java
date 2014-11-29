package com.fafica.projeto_pi.controladora;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.excecoes.IdadeInvalidoException;
import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.excecoes.NascenteJaCadastradaException;
import com.fafica.projeto_pi.excecoes.PesquisadorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.PesquisadorNaoEncontradoException;
import com.fafica.projeto_pi.excecoes.PlantaJaCadastradaException;
import com.fafica.projeto_pi.excecoes.ReservaNaoEncontradaException;
import com.fafica.projeto_pi.excecoes.SoloJaCadastradoException;
import com.fafica.projeto_pi.excecoes.Validacao;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.repositorioBDR.RepositorioNascenteAguaBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPesquisadorBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaGrandePorteBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaMedioPorteBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPlantaPequenoPorteBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioReservaBDR;
import com.fafica.projeto_pi.repositorioBDR.RepositorioSoloBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioNascenteAgua;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPesquisador;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaGrandePorte;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaMedioPorte;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPlantaPequenoPorte;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioReserva;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioSolo;

public class ControladoraReserva {

	IRepositorioReserva repositorioReserva;
	IRepositorioNascenteAgua repositorioNascenteAgua;
	IRepositorioPesquisador repositorioPesquisador;
	IRepositorioSolo repositorioSolo; 
	IRepositorioPlantaPequenoPorte repositorioPlantaPequenoPorte;
	IRepositorioPlantaMedioPorte repositorioPlantaMedioPorte ;
	IRepositorioPlantaGrandePorte repositorioPlantaGrandePorte;
	
	public ControladoraReserva() throws Exception {
		this.repositorioReserva = new RepositorioReservaBDR();
		this.repositorioNascenteAgua = new RepositorioNascenteAguaBDR();
		this.repositorioPesquisador = new RepositorioPesquisadorBDR();
		this.repositorioSolo = new RepositorioSoloBDR();
		this.repositorioPlantaPequenoPorte = new RepositorioPlantaPequenoPorteBDR();
		this.repositorioPlantaMedioPorte = new RepositorioPlantaMedioPorteBDR();
		this.repositorioPlantaGrandePorte = new RepositorioPlantaGrandePorteBDR();
	}

	public void cadastrarReserva(
			Reserva reserva) throws SQLException, CampoObritarorioInvalidoException,
			AdministradorJaCadastradoException, IdadeInvalidoException, CPFInvalidoException,
			PlantaJaCadastradaException, PesquisadorJaCadastradoException,
			NascenteJaCadastradaException,
			SoloJaCadastradoException {
		System.out.println("Passando pela controladora de reserva");
		// Aqui fazemos a chamada do repositorio no metodo cadastrar para
		// inserir no banco
		
	
		if (reserva.getNome().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Nome � nulo ou inv�lido.");
		if (reserva.getClima().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Clima � nulo ou inv�lido.");
		if (reserva.getLatitude() == 0.0)	throw new CampoObritarorioInvalidoException("Campo Latitude � nulo ou inv�lido.");
		if (reserva.getLongitude() == 0.0)	throw new CampoObritarorioInvalidoException("Campo Longitude � nulo ou inv�lido.");
		this.repositorioReserva.cadastrarReserva(reserva);
		
		
		for (Pesquisador pesquisador : reserva.getPesquisadores()) {
			pesquisador.setIdReserva(reserva.getIdReserva());
			
			if (pesquisador.getNome().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Nome � nulo ou inv�lido.");
			if (pesquisador.getCpf().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo cpf � nulo ou inv�lido.");
			if (pesquisador.getProfissao().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo profissao � nulo ou inv�lido.");
			if (pesquisador.getIdade() == 0)	throw new CampoObritarorioInvalidoException("Campo idade � nulo ou inv�lido.");
			if (pesquisador.getIdade() < 18) throw new IdadeInvalidoException();
		//	if(!Validacao.validaCPF(pesquisador.getCpf())) throw new CPFInvalidoException(pesquisador.getCpf());
		//	if(this.repositorioPesquisador.existe(pesquisador) == true) throw new PesquisadorJaCadastradoException();
			
			this.repositorioPesquisador.cadastrarPesquisadores(pesquisador);
			
		}
	
		

		for (NascenteAgua nascente : reserva.getNascenteAgua()) {
			nascente.setIdReserva(reserva.getIdReserva());
			
			if (nascente.getNomeFonte().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Nome � nulo ou inv�lido.");
			if (nascente.getTipo().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Nome � nulo ou inv�lido.");
			if (nascente.getLatitude() == 0.0)	throw new CampoObritarorioInvalidoException("Campo Latitude � nulo ou inv�lido.");
			if (nascente.getLongitude() == 0.0)	throw new CampoObritarorioInvalidoException("Campo Longitude � nulo ou inv�lido.");
	
			
			this.repositorioNascenteAgua.cadastrarAgua(nascente);
		}
		
		

		for (Solo solo : reserva.getSolos()) {
			solo.setIdReserva(reserva.getIdReserva());
			
			if (solo.getTipo().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Tipo � nulo ou inv�lido.");
			if (solo.getResursos().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Tipo � nulo ou inv�lido.");
			if (solo.getTamanho() == 0.0)	throw new CampoObritarorioInvalidoException("Campo Tipo � nulo ou inv�lido.");

			
			this.repositorioSolo.cadastrarSolo(solo);
		}
		
		

		for (PlantaPequenoPorte plantaPequena : reserva.getListaPlantaPequena()) {
			plantaPequena.setIdReserva(reserva.getIdReserva());
			
			if (plantaPequena.getNome().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Tipo � nulo ou inv�lido.");
			if (plantaPequena.getEspecie().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Especie � nulo ou inv�lido.");
			if (plantaPequena.getTamanho() == 0.0)	throw new CampoObritarorioInvalidoException("Campo Tamanho � nulo ou inv�lido.");

			
			this.repositorioPlantaPequenoPorte.cadastrarPlantaPequenoPorte(plantaPequena);
		}
		

		for (PlantaMedioPorte plantaMedia : reserva.getListaPlantaMedia()) {
			plantaMedia.setIdReserva(reserva.getIdReserva());
			
			if (plantaMedia.getNome().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Tipo � nulo ou inv�lido.");
			if (plantaMedia.getEspecie().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Especie � nulo ou inv�lido.");
			if (plantaMedia.getTamanho() == 0.0)	throw new CampoObritarorioInvalidoException("Campo Tamanho � nulo ou inv�lido.");

			
			this.repositorioPlantaMedioPorte.cadastrarPlantaMedioPorte(plantaMedia);
		}
		
		

		for (PlantaGrandePorte plantaGrande : reserva.getListaPlantaGrande()) {
			plantaGrande.setIdReserva(reserva.getIdReserva());
			
			if (plantaGrande.getNome().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Tipo � nulo ou inv�lido.");
			if (plantaGrande.getEspecie().equals("") == true)	throw new CampoObritarorioInvalidoException("Campo Especie � nulo ou inv�lido.");
			if (plantaGrande.getTamanho() == 0.0)	throw new CampoObritarorioInvalidoException("Campo Tamanho � nulo ou inv�lido.");

			
			this.repositorioPlantaGrandePorte.cadastrarPlantaGrandePorte(plantaGrande);
			
		
		}
	
	}
	public ArrayList<Reserva> listarReserva()
			throws SQLException,ReservaNaoEncontradaException {
		System.out.println("Passando pela controladora listarReservas");
		return repositorioReserva.listarReserva();
	}

	public Reserva procurarReserva(int idReserva) throws SQLException,ReservaNaoEncontradaException,PesquisadorNaoEncontradoException{
		System.out.println("Passando pelo pelo procurarReserva");
		return this.repositorioReserva.procurarReserva(idReserva);
	}

	public void editarReserva(
			Reserva reserva) throws SQLException,ReservaNaoEncontradaException ,PesquisadorNaoEncontradoException{
		System.out.println("Passando pelo editarReservas");
		this.repositorioReserva.editarReserva(reserva);
	}

	public void removerReserva(int idReserva) throws SQLException,ReservaNaoEncontradaException ,PesquisadorNaoEncontradoException{
		System.out.println("Passando pelo removerReservas");
		this.repositorioReserva
				.removerReserva(idReserva);
	}

}
