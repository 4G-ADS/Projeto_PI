package com.fafica.projeto_pi.fachada;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.controladora.ControladorNascente;
import com.fafica.projeto_pi.controladora.ControladorPesquisadores;
import com.fafica.projeto_pi.controladora.ControladorPlantaGrandePorte;
import com.fafica.projeto_pi.controladora.ControladorPlantaMedioPorte;
import com.fafica.projeto_pi.controladora.ControladorPlantaPequenoPorte;
import com.fafica.projeto_pi.controladora.ControladorSolo;
import com.fafica.projeto_pi.controladora.ControladoraInstituicao;
import com.fafica.projeto_pi.controladora.ControladoraReserva;
import com.fafica.projeto_pi.controladora.ControladorAdministrador;
import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.AdministradorNaoEncontradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.excecoes.IdadeInvalidoException;
import com.fafica.projeto_pi.excecoes.InstituicacaoNaoEncontrada;
import com.fafica.projeto_pi.excecoes.NascenteJaCadastradaException;
import com.fafica.projeto_pi.excecoes.NascenteNaoEncontradaException;
import com.fafica.projeto_pi.excecoes.PesquisadorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.PesquisadorNaoEncontradoException;
import com.fafica.projeto_pi.excecoes.PlantaJaCadastradaException;
import com.fafica.projeto_pi.excecoes.PlantaNaoEncontradaException;
import com.fafica.projeto_pi.excecoes.ReservaNaoEncontradaException;
import com.fafica.projeto_pi.excecoes.SoloJaCadastradoException;
import com.fafica.projeto_pi.excecoes.SoloNaoEncontradorException;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
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
	private ControladorPlantaMedioPorte controladorPlantaMedioPorte;
	private ControladorPlantaGrandePorte controladoraPlantaGrandePorte;
	
	private Fachada() {
	}

	public static Fachada getInstace() {

		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	public void cadastrarReserva(Reserva reserva) throws SQLException, CampoObritarorioInvalidoException,
	AdministradorJaCadastradoException, IdadeInvalidoException, CPFInvalidoException, PlantaJaCadastradaException, 
	PesquisadorJaCadastradoException, NascenteJaCadastradaException, SoloJaCadastradoException ,Exception{
		System.out.println("Passando pela Fachada cadastrarReserva");
		this.controladoraReserva = new ControladoraReserva();
		this.controladoraReserva.cadastrarReserva(reserva);

	}

	public ArrayList<Reserva> listarReserva() throws SQLException, ReservaNaoEncontradaException ,Exception {
		System.out.println("Passando pela Fachada listarReserva");
		this.controladoraReserva = new ControladoraReserva();
		return this.controladoraReserva.listarReserva();

	}

	public void editarReserva(Reserva reserva) throws SQLException, ReservaNaoEncontradaException, PesquisadorNaoEncontradoException,Exception {
		System.out.println("Passando pela Fachada editarReserva");
		this.controladoraReserva = new ControladoraReserva();
		this.controladoraReserva.editarReserva(reserva);
	}

	public void removerReserva(int idReserva) throws SQLException, ReservaNaoEncontradaException, PesquisadorNaoEncontradoException,Exception {
		System.out.println("Passando pela Fachada removerReserva");
		this.controladoraReserva = new ControladoraReserva();
		this.controladoraReserva.removerReserva(idReserva);
	}

	public Reserva procurarReserva(int idReserva) throws SQLException, ReservaNaoEncontradaException, PesquisadorNaoEncontradoException,Exception {
		System.out.println("Passando pela Fachada procurarReserva");
		this.controladoraReserva = new ControladoraReserva();
		return this.controladoraReserva.procurarReserva(idReserva);
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void cadastrarInstituicao(Instituicao instituicao) throws SQLException, IOException, CampoObritarorioInvalidoException,
	CPFInvalidoException, AdministradorJaCadastradoException,Exception  {
		System.out.println("Passando pela Fachada cadastrarInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		this.controladoraInstituicao.cadastrarInstituicao(instituicao);
	}

	public ArrayList<Instituicao> listarInstituicao() throws SQLException, IOException ,Exception {
		System.out.println("Passando pela Fachada listarInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		return this.controladoraInstituicao.listarInstituicao();

	}

	public ArrayList<Instituicao> listarInstituicao(int idReserva) throws SQLException,Exception
			{
		System.out.println("Passando pela Fachada listarInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		return this.controladoraInstituicao.listarInstituicao(idReserva);

	}

	public void editarInstituicao(Instituicao instituicao) throws SQLException, IOException, InstituicacaoNaoEncontrada,Exception {
		System.out.println("Passando pela Fachada editarInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		this.controladoraInstituicao.editarInstituicao(instituicao);
	}

	public void removerInsituicao(int idInstituicao) throws SQLException, IOException, InstituicacaoNaoEncontrada ,Exception {
		System.out.println("Passando pela Fachada removerInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		this.controladoraInstituicao.removerInstituicao(idInstituicao);
	}

	public Instituicao procurarInstituicao(int idInstituicao) throws SQLException, InstituicacaoNaoEncontrada ,Exception
		 {
		System.out.println("Passando pela Fachada procurarInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		return this.controladoraInstituicao.procurarInstituicao(idInstituicao);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void cadastrarAdministrardor(Administrador administrador) throws SQLException, IOException, AdministradorJaCadastradoException,
	CampoObritarorioInvalidoException, CPFInvalidoException,Exception
			 {
		System.out.println("Passando pela Fachada cadastrarInstituicao");
		System.out.println(administrador);
		this.controladorAdministrador = new ControladorAdministrador();
		this.controladorAdministrador.cadastrarAdministrardor(administrador);
	}

	public ArrayList<Administrador> listarAdministrador() throws SQLException, IOException,Exception   {
		System.out.println("Passando pela Fachada listarUsuario");
		this.controladorAdministrador = new ControladorAdministrador();
		return this.controladorAdministrador.listarAdministrardor();
	}

	public void editarAdministrador(Administrador administrador) throws SQLException, IOException, AdministradorNaoEncontradoException,Exception
			 {
		System.out.println("Passando pela Fachada editarInstituicao");
		this.controladorAdministrador = new ControladorAdministrador();
		this.controladorAdministrador.editarAdministrardor(administrador);
	}

	public void removerAdministradoro(int idAdministrardor) throws SQLException, IOException, AdministradorNaoEncontradoException,Exception  {
		System.out.println("Passando pela Fachada removerInstituicao");
		this.controladorAdministrador = new ControladorAdministrador();
		this.controladorAdministrador.removerAdministrardor(idAdministrardor);
	}

	public Administrador procurarAdministrador(int idAdministrardor) throws SQLException, IOException, AdministradorNaoEncontradoException,Exception {
		System.out.println("Passando pela Fachada procurarInstituicao");
		this.controladorAdministrador = new ControladorAdministrador();
		return this.controladorAdministrador.procurarAdministrardor(idAdministrardor);
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void cadastrarPesquisador(Pesquisador pesquisador) throws SQLException ,Exception{
		this.controladoraPesquisadores = new ControladorPesquisadores();
		this.controladoraPesquisadores.cadastrarPesquisador(pesquisador);
	}
	
	
	public ArrayList<Pesquisador> listarPesquisador() throws SQLException, IOException ,Exception {
		System.out.println("Passando pela Fachada listarPesquisador");
		this.controladoraPesquisadores = new ControladorPesquisadores();
		return this.controladoraPesquisadores.listarPesquisadores();

	}

	public ArrayList<Pesquisador> listarPesquisador(int idReserva) throws Exception
			 {
		System.out.println("Passando pela Fachada listarPesquisador");
		this.controladoraPesquisadores = new ControladorPesquisadores();
		return this.controladoraPesquisadores.listarPesquisadores(idReserva);

	}

	public void editarPesquisador(Pesquisador pesquisador) throws SQLException, IOException, PesquisadorNaoEncontradoException,Exception  {
		System.out.println("Passando pela Fachada editarPesquisador");
		this.controladoraPesquisadores = new ControladorPesquisadores();
		this.controladoraPesquisadores.editarPesquisador(pesquisador);
	}

	public void removerPesquisador(int idPesquisador) throws SQLException, IOException, PesquisadorNaoEncontradoException ,Exception{
		System.out.println("Passando pela Fachada removerPesquisador");
		this.controladoraPesquisadores = new ControladorPesquisadores();
		this.controladoraPesquisadores.removerPesquisadores(idPesquisador);
	}

	public Pesquisador procurarPesquisador(int idPesquisador) throws SQLException, IOException, PesquisadorNaoEncontradoException,Exception {
		System.out.println("Passando pela Fachada procurarPesquisador");
		this.controladoraPesquisadores = new ControladorPesquisadores();
		return this.controladoraPesquisadores
				.procurarPesquisador(idPesquisador);
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void cadastrarSolo(Solo solo) throws SQLException,Exception{
		this.controladoraSolos = new ControladorSolo();
		this.controladoraSolos.CadastrarSolo(solo);
	}
	
	public ArrayList<Solo> listarSolo() throws SQLException,Exception {
		System.out.println("Passando pela Fachada listarSolo");
		this.controladoraSolos = new ControladorSolo();
		return this.controladoraSolos.listarSolo();

	}

	public ArrayList<Solo> listarSolo(int idReserva) throws SQLException ,Exception{
		System.out.println("Passando pela Fachada listarSolo");
		this.controladoraSolos = new ControladorSolo();
		return this.controladoraSolos.listarSolo(idReserva);

	}

	public void editarSolo(Solo solo) throws SQLException, SoloNaoEncontradorException,Exception {
		System.out.println("Passando pela Fachada editarSolo");
		this.controladoraSolos = new ControladorSolo();
		this.controladoraSolos.editarSolo(solo);
	}

	public void removerSolo(int idSolo) throws SQLException, SoloNaoEncontradorException,Exception{
		System.out.println("Passando pela Fachada removerSolo");
		this.controladoraSolos = new ControladorSolo();
		this.controladoraSolos.removerSolo(idSolo);
	}

	public Solo procurarSolo(int idSolo) throws SQLException, SoloNaoEncontradorException,Exception  {
		System.out.println("Passando pela Fachada procurarSolo");
		this.controladoraSolos = new ControladorSolo();
		return this.controladoraSolos.procurarSolo(idSolo);
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void cadastrarNascente(NascenteAgua agua) throws SQLException,Exception{
		this.controladoraNascente = new ControladorNascente();
		this.controladoraNascente.cadastrarNascente(agua);
	}
	
	
	public ArrayList<NascenteAgua> listarNascente() throws SQLException,Exception {
		System.out.println("Passando pela Fachada listarNascenteAgua");
		this.controladoraNascente = new ControladorNascente();
		return this.controladoraNascente.listarNascentes();

	}

	public ArrayList<NascenteAgua> listarNascente(int idReserva) throws SQLException,Exception
			 {
		System.out.println("Passando pela Fachada listarNascenteAgua");
		this.controladoraNascente = new ControladorNascente();
		return this.controladoraNascente.listarNascentes(idReserva);

	}

	public void editarNascente(NascenteAgua nascente) throws SQLException, NascenteNaoEncontradaException,Exception {
		System.out.println("Passando pela Fachada editarNascenteAgua");
		this.controladoraNascente = new ControladorNascente();
		this.controladoraNascente.editarNascente(nascente);
	}

	public void removerNascente(int idNascente) throws SQLException, NascenteNaoEncontradaException ,Exception{
		System.out.println("Passando pela Fachada removerNascenteAgua");
		this.controladoraNascente = new ControladorNascente();
		this.controladoraNascente.removerNascente(idNascente);
		;
	}

	public NascenteAgua procurarNascente(int idNascente) throws SQLException, NascenteNaoEncontradaException , Exception{
		System.out.println("Passando pela Fachada procurarNascenteAgua");
		this.controladoraNascente = new ControladorNascente();
		return this.controladoraNascente.procurarNascente(idNascente);
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void CadastrarPlantaPequena(PlantaPequenoPorte planta) throws SQLException,Exception{
		this.controladoraPlantaPequenoPorte = new ControladorPlantaPequenoPorte();
		this.controladoraPlantaPequenoPorte.cadastrarPlantaPequenoPorte(planta);
	}
	public ArrayList<PlantaPequenoPorte> listarPlantaPequena() throws SQLException, Exception   {
		System.out.println("Pasando pela Fachada lsitarPlantaPequenoPorte");
		this.controladoraPlantaPequenoPorte = new ControladorPlantaPequenoPorte();
		return this.controladoraPlantaPequenoPorte.listarPlantaPequena();
	}

	public ArrayList<PlantaPequenoPorte> listarPlantaPequena(int idReserva) throws SQLException, Exception
		 {
		System.out.println("Pasando pela Fachada listarPlantaPequenoPorte");
		this.controladoraPlantaPequenoPorte = new ControladorPlantaPequenoPorte();
		return this.controladoraPlantaPequenoPorte
				.listarPlantaPequena(idReserva);
	}

	public void removerPlantaPequenoPorte(int idPlantaPequena) throws SQLException, PlantaNaoEncontradaException, Exception {
		System.out.println("Passando pela Fachada removerPlantaPequenoPorte");
		this.controladoraPlantaPequenoPorte = new ControladorPlantaPequenoPorte();
		this.controladoraPlantaPequenoPorte
				.removerPlantaPequenoPorte(idPlantaPequena);

	}

	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public void cadastrarPlantaMedia(PlantaMedioPorte planta) throws SQLException,Exception{
		this.controladorPlantaMedioPorte = new ControladorPlantaMedioPorte();
		this.controladorPlantaMedioPorte.cadastrarPlantaMedia(planta);
	}
	public ArrayList<PlantaMedioPorte> listarPlantaMedia() throws SQLException, Exception {
		System.out.println("Pasando pela Fachada lsitarPlantaMedioPorte");
		this.controladorPlantaMedioPorte = new ControladorPlantaMedioPorte();
		return this.controladorPlantaMedioPorte.listarPlantaMedia();
	}	
	
	public ArrayList<PlantaMedioPorte> listarPlantaMedia(int idReserva) throws SQLException, Exception {
		System.out.println("Pasando pela Fachada lsitarPlantaMedioPorte");
		this.controladorPlantaMedioPorte = new ControladorPlantaMedioPorte();
		return this.controladorPlantaMedioPorte.listarPlantaMedia(idReserva);
	}	
	
	public void removerPlantaMedioPorte(int idPlantaMedia) throws SQLException, PlantaNaoEncontradaException, Exception {
		System.out.println("Passando pela Fachada removerPlantaMedioPorte");
		this.controladorPlantaMedioPorte = new ControladorPlantaMedioPorte();
		this.controladorPlantaMedioPorte.removerPlantaMedioPorte(idPlantaMedia);
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void CadastrarPlantaGrande(PlantaGrandePorte planta) throws SQLException,Exception{
		this.controladoraPlantaGrandePorte = new ControladorPlantaGrandePorte();
		this.controladoraPlantaGrandePorte.cadastrarPlantaGrande(planta);
	}
	
	public ArrayList<PlantaGrandePorte> listarPlantaGrande() throws SQLException, Exception {
		System.out.println("Pasando pela Fachada lsitarPlantaGrandePorte");
		this.controladoraPlantaGrandePorte = new ControladorPlantaGrandePorte();
		return this.controladoraPlantaGrandePorte.listarPlantaGrande();
	}
	
	public ArrayList<PlantaGrandePorte> listarPlantaGrande(int idReserva) throws SQLException, Exception {
		System.out.println("Pasando pela Fachada lsitarPlantaGrandePorte");
		this.controladoraPlantaGrandePorte = new ControladorPlantaGrandePorte();
		return this.controladoraPlantaGrandePorte.listarPlantaGrande(idReserva);
	}
	
	public void removerPlantaGrandePorte(int idPlantaGrande) throws SQLException, PlantaNaoEncontradaException, Exception {
		System.out.println("Passando pela Fachada removerPlantaGrandePorte");
		this.controladoraPlantaGrandePorte = new ControladorPlantaGrandePorte();
		this.controladoraPlantaGrandePorte.removerPlantaGrandePorte(idPlantaGrande);
		
	}
	
}
