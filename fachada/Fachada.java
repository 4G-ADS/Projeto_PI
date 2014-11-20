package com.fafica.projeto_pi.fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.controladora.ControladorNascente;
import com.fafica.projeto_pi.controladora.ControladorPesquisadores;
import com.fafica.projeto_pi.controladora.ControladorPlantaPequenoPorte;
import com.fafica.projeto_pi.controladora.ControladorSolo;
import com.fafica.projeto_pi.controladora.ControladoraInstituicao;
import com.fafica.projeto_pi.controladora.ControladoraReserva;
import com.fafica.projeto_pi.controladora.ControladorAdministrador;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.modelos.Solo;

public class Fachada {

	private static Fachada instance = null;
	private ControladoraReserva controladoraReserva;
	private ControladoraInstituicao controladoraInstituicao;
	private ControladorAdministrador controladorAdministrador;
	private ControladorPesquisadores controladoraPesquisadores;
	private ControladorSolo controladoraSolos;
	private ControladorNascente controladoraNascente;
	private ControladorPlantaPequenoPorte controladoraPlantaPequenoPorte;
	
	private Fachada() {
	}

	public static Fachada getInstace() {

		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	public void cadastrarReserva(Reserva reserva) throws Exception {
		System.out.println("Passando pela Fachada cadastrarReserva");
		this.controladoraReserva = new ControladoraReserva();
		this.controladoraReserva.cadastrarReserva(reserva);

	}

	public ArrayList<Reserva> listarReserva() throws Exception {
		System.out.println("Passando pela Fachada listarReserva");
		this.controladoraReserva = new ControladoraReserva();
		return this.controladoraReserva.listarReserva();

	}

	public void editarReserva(Reserva reserva) throws Exception {
		System.out.println("Passando pela Fachada editarReserva");
		this.controladoraReserva = new ControladoraReserva();
		this.controladoraReserva.editarReserva(reserva);
	}

	public void removerReserva(int idReserva) throws Exception {
		System.out.println("Passando pela Fachada removerReserva");
		this.controladoraReserva = new ControladoraReserva();
		this.controladoraReserva.removerReserva(idReserva);
	}

	public Reserva procurarReserva(int idReserva) throws Exception {
		System.out.println("Passando pela Fachada procurarReserva");
		this.controladoraReserva = new ControladoraReserva();
		return this.controladoraReserva.procurarReserva(idReserva);
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void cadastrarInstituicao(Instituicao instituicao) throws Exception {
		System.out.println("Passando pela Fachada cadastrarInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		this.controladoraInstituicao.cadastrarInstituicao(instituicao);
	}

	public ArrayList<Instituicao> listarInstituicao() throws Exception {
		System.out.println("Passando pela Fachada listarInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		return this.controladoraInstituicao.listarInstituicao();

	}

	public ArrayList<Instituicao> listarInstituicao(int idReserva)
			throws Exception {
		System.out.println("Passando pela Fachada listarInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		return this.controladoraInstituicao.listarInstituicao(idReserva);

	}

	public void editarInstituicao(Instituicao instituicao) throws Exception {
		System.out.println("Passando pela Fachada editarInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		this.controladoraInstituicao.editarInstituicao(instituicao);
	}

	public void removerInsituicao(int idInstituicao) throws Exception {
		System.out.println("Passando pela Fachada removerInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		this.controladoraInstituicao.removerInstituicao(idInstituicao);
	}

	public Instituicao procurarInstituicao(int idInstituicao) throws Exception,
			SQLException {
		System.out.println("Passando pela Fachada procurarInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		return this.controladoraInstituicao.procurarInstituicao(idInstituicao);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void cadastrarAdministrardor(Administrador administrador)
			throws Exception {
		System.out.println("Passando pela Fachada cadastrarInstituicao");
		System.out.println(administrador);
		this.controladorAdministrador = new ControladorAdministrador();
		this.controladorAdministrador.cadastrarAdministrardor(administrador);
	}

	public ArrayList<Administrador> listarAdministrador() throws Exception {
		System.out.println("Passando pela Fachada listarUsuario");
		this.controladorAdministrador = new ControladorAdministrador();
		return this.controladorAdministrador.listarAdministrardor();
	}

	public void editarAdministrador(Administrador administrador)
			throws Exception {
		System.out.println("Passando pela Fachada editarInstituicao");
		this.controladorAdministrador = new ControladorAdministrador();
		this.controladorAdministrador.editarAdministrardor(administrador);
	}

	public void removerAdministradoro(int idAdministrardor) throws Exception {
		System.out.println("Passando pela Fachada removerInstituicao");
		this.controladorAdministrador = new ControladorAdministrador();
		this.controladorAdministrador.removerAdministrardor(idAdministrardor);
	}

	public void procurarAdministrador(int idAdministrardor) throws Exception {
		System.out.println("Passando pela Fachada procurarInstituicao");
		this.controladorAdministrador = new ControladorAdministrador();
		this.controladorAdministrador.procurarAdministrardor(idAdministrardor);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<Pesquisador> listarPesquisador() throws Exception {
		System.out.println("Passando pela Fachada listarPesquisador");
		this.controladoraPesquisadores = new ControladorPesquisadores();
		return this.controladoraPesquisadores.listarPesquisadores();

	}

	public ArrayList<Pesquisador> listarPesquisador(int idReserva)
			throws Exception {
		System.out.println("Passando pela Fachada listarPesquisador");
		this.controladoraPesquisadores = new ControladorPesquisadores();
		return this.controladoraPesquisadores.listarPesquisadores(idReserva);

	}

	public void editarPesquisador(Pesquisador pesquisador) throws Exception {
		System.out.println("Passando pela Fachada editarPesquisador");
		this.controladoraPesquisadores = new ControladorPesquisadores();
		this.controladoraPesquisadores.editarPesquisador(pesquisador);
	}

	public void removerPesquisador(int idPesquisador) throws Exception {
		System.out.println("Passando pela Fachada removerPesquisador");
		this.controladoraPesquisadores = new ControladorPesquisadores();
		this.controladoraPesquisadores.removerPesquisadores(idPesquisador);
	}

	public Pesquisador procurarPesquisador(int idPesquisador) throws Exception,
			SQLException {
		System.out.println("Passando pela Fachada procurarPesquisador");
		this.controladoraPesquisadores = new ControladorPesquisadores();
		return this.controladoraPesquisadores
				.procurarPesquisador(idPesquisador);
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<Solo> listarSolo() throws Exception {
		System.out.println("Passando pela Fachada listarSolo");
		this.controladoraSolos = new ControladorSolo();
		return this.controladoraSolos.listarSolo();

	}

	public ArrayList<Solo> listarSolo(int idReserva) throws Exception {
		System.out.println("Passando pela Fachada listarSolo");
		this.controladoraSolos = new ControladorSolo();
		return this.controladoraSolos.listarSolo(idReserva);

	}

	public void editarSolo(Solo solo) throws Exception {
		System.out.println("Passando pela Fachada editarSolo");
		this.controladoraSolos = new ControladorSolo();
		this.controladoraSolos.editarSolo(solo);
	}

	public void removerSolo(int idSolo) throws Exception {
		System.out.println("Passando pela Fachada removerSolo");
		this.controladoraSolos = new ControladorSolo();
		this.controladoraSolos.removerSolo(idSolo);
	}

	public Solo procurarSolo(int idSolo) throws Exception, SQLException {
		System.out.println("Passando pela Fachada procurarSolo");
		this.controladoraSolos = new ControladorSolo();
		return this.controladoraSolos.procurarSolo(idSolo);
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<NascenteAgua> listarNascente() throws Exception {
		System.out.println("Passando pela Fachada listarNascenteAgua");
		this.controladoraNascente = new ControladorNascente();
		return this.controladoraNascente.listarNascentes();

	}

	public ArrayList<NascenteAgua> listarNascente(int idReserva)
			throws Exception {
		System.out.println("Passando pela Fachada listarNascenteAgua");
		this.controladoraNascente = new ControladorNascente();
		return this.controladoraNascente.listarNascentes(idReserva);

	}

	public void editarNascente(NascenteAgua nascente) throws Exception {
		System.out.println("Passando pela Fachada editarNascenteAgua");
		this.controladoraNascente = new ControladorNascente();
		this.controladoraNascente.editarNascente(nascente);
	}

	public void removerNascente(int idNascente) throws Exception {
		System.out.println("Passando pela Fachada removerNascenteAgua");
		this.controladoraNascente = new ControladorNascente();
		this.controladoraNascente.removerNascente(idNascente);
		;
	}

	public NascenteAgua procurarNascente(int idNascente) throws Exception,
			SQLException {
		System.out.println("Passando pela Fachada procurarNascenteAgua");
		this.controladoraNascente = new ControladorNascente();
		return this.controladoraNascente.procurarNascente(idNascente);
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<PlantaPequenoPorte> listarPlantaPequena() throws Exception {
		System.out.println("Pasando pela Fachada lsitarPlantaPequenoPorte");
		this.controladoraPlantaPequenoPorte = new ControladorPlantaPequenoPorte();
		return this.controladoraPlantaPequenoPorte.listarPlantaPequena();
	}

	public ArrayList<PlantaPequenoPorte> listarPlantaPequena(int idReserva)
			throws Exception {
		System.out.println("Pasando pela Fachada listarPlantaPequenoPorte");
		this.controladoraPlantaPequenoPorte = new ControladorPlantaPequenoPorte();
		return this.controladoraPlantaPequenoPorte
				.listarPlantaPequena(idReserva);
	}

	public void removerPlantaPequenoPorte(int idPlantaPequena) throws Exception {
		System.out.println("Passando pela Fachada removerPlantaPequenoPorte");
		this.controladoraPlantaPequenoPorte = new ControladorPlantaPequenoPorte();
		this.controladoraPlantaPequenoPorte
				.removerPlantaPequenoPorte(idPlantaPequena);

	}

	public PlantaPequenoPorte procurarPlantaPequena(int idPlantaPequena)
			throws Exception {
		System.out.println("Passando pela fachada procurarPlantaPequena");
		this.controladoraPlantaPequenoPorte = new ControladorPlantaPequenoPorte();
		return controladoraPlantaPequenoPorte
				.procurarPlantaPequena(idPlantaPequena);
	}
	
	//
//	public ArrayList<PlantaMedioPorte> listarPlantaMedia() throws Exception{
//		System.out.println("Pasando pela Fachada lsitarPlantaMedioPorte");
//		this.controladoraPlantas = new ControladorPlantaPequenoPorte();
//		return this.controladoraPlantas.listarPlantaMedia();
//	}	
//	
//	public ArrayList<PlantaMedioPorte> listarPlantaMedia(int idReserva) throws Exception{
//		System.out.println("Pasando pela Fachada lsitarPlantaMedioPorte");
//		this.controladoraPlantas = new ControladorPlantaPequenoPorte();
//		return this.controladoraPlantas.listarPlantaMedia(idReserva);
//	}	
//	
//	public void removerPlantaMedioPorte(int idPlantaMedia) throws Exception{
//		System.out.println("Passando pela Fachada removerPlantaMedioPorte");
//		this.controladoraPlantas = new ControladorPlantaPequenoPorte();
//		this.controladoraPlantas.removerPlantaMedioPorte(idPlantaMedia);
//		
//	}
//	
//	public PlantaMedioPorte procurarPlantaMedia(int idPlantaMedia) throws Exception{
//		System.out.println("Passando pela fachada procurarPlantaPequena");
//		this.controladoraPlantas = new ControladorPlantaPequenoPorte();
//		return controladoraPlantas.procurarPlantaMedia(idPlantaMedia);
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
//	public void cadastrarPlantaGrandePorte(Reserva reserva) throws Exception {
//		System.out.println("Passando pela Fachada cadastrarPlantaGrandePorte");
//		this.controladoraPlantas = new ControladorPlantaPequenoPorte();
//		this.controladoraPlantas.cadastrarPlantaGrandePorte(reserva);
//	}
//	
//	public ArrayList<PlantaGrandePorte> listarPlantaGrande() throws Exception{
//		System.out.println("Pasando pela Fachada lsitarPlantaGrandePorte");
//		this.controladoraPlantas = new ControladorPlantaPequenoPorte();
//		return this.controladoraPlantas.listarPlantaGrande();
//	}
//	
//	public ArrayList<PlantaGrandePorte> listarPlantaGrande(int idReserva) throws Exception{
//		System.out.println("Pasando pela Fachada lsitarPlantaGrandePorte");
//		this.controladoraPlantas = new ControladorPlantaPequenoPorte();
//		return this.controladoraPlantas.listarPlantaGrande(idReserva);
//	}
//	
//	public void removerPlantaGrandePorte(int idPlantaGrande) throws Exception{
//		System.out.println("Passando pela Fachada removerPlantaGrandePorte");
//		this.controladoraPlantas = new ControladorPlantaPequenoPorte();
//		this.controladoraPlantas.removerPlantaGrandePorte(idPlantaGrande);
//		
//	}
//	
//	public PlantaGrandePorte procurarPlantaGrande(int idPlantaGrande) throws Exception{
//		System.out.println("Passando pela fachada procurarPlantaGramde");
//		this.controladoraPlantas = new ControladorPlantaPequenoPorte();
//		return controladoraPlantas.procurarPlantaGrande(idPlantaGrande);
//	}
	

}
