package com.fafica.projeto_pi.fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.controladora.ControladorReservaNascente;
import com.fafica.projeto_pi.controladora.ControladorReservaPesquisadores;
import com.fafica.projeto_pi.controladora.ControladorReservaPlantas;
import com.fafica.projeto_pi.controladora.ControladorReservaSolo;
import com.fafica.projeto_pi.controladora.ControladoraInstituicao;
import com.fafica.projeto_pi.controladora.ControladoraReservaCaracteristicas;
import com.fafica.projeto_pi.controladora.ControladoraUsuario;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.modelos.Usuario;
import com.fafica.projeto_pi.repositorio.RepositorioPlantaPequenoPorte;

public class Fachada {

	private static Fachada instance = null;
	private ControladoraReservaCaracteristicas controladoraReservaCaracteristicas;
	private ControladoraInstituicao controladoraInstituicao;
	private ControladoraUsuario  controladoraUsuario;
	private ControladorReservaPesquisadores controladoraPesquisadores;
	private ControladorReservaSolo controladoraSolos;
	private ControladorReservaNascente controladoraNascente;
	private ControladorReservaPlantas controladoraPlantas;

	private Fachada() {
	}

	public static Fachada getInstace() {

		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	public void cadastrarReservaCaracteristicas(Reserva reserva) throws Exception {
		System.out.println("Passando pela Fachada cadastrarReserva");
		this.controladoraReservaCaracteristicas = new ControladoraReservaCaracteristicas();
		this.controladoraReservaCaracteristicas.cadastrarReservaCaracteristicas(reserva);
	}

	public ArrayList<Reserva> listarReservaCaracteristicas() throws Exception {
		System.out.println("Passando pela Fachada listarReserva");
		this.controladoraReservaCaracteristicas = new ControladoraReservaCaracteristicas();
		return this.controladoraReservaCaracteristicas.listarReservaCaracteristicas();

	}

	public void editarReservaCaracteristicas(Reserva reserva) throws Exception {
		System.out.println("Passando pela Fachada editarReserva");
		this.controladoraReservaCaracteristicas = new ControladoraReservaCaracteristicas();
		this.controladoraReservaCaracteristicas.editarReservaCaracteristicas(reserva);
	}

	public void removerReservaCaracteristicas(int idReserva) throws Exception {
		System.out.println("Passando pela Fachada removerReserva");
		this.controladoraReservaCaracteristicas = new ControladoraReservaCaracteristicas();
		this.controladoraReservaCaracteristicas.removerReservaCaracteristicas(idReserva);
	}

	public Reserva procurarReservaCaracteristicas(int idReserva) throws Exception {
		System.out.println("Passando pela Fachada procurarReserva");
		this.controladoraReservaCaracteristicas = new ControladoraReservaCaracteristicas();
		return this.controladoraReservaCaracteristicas.procurarReservaCaracteristicas(idReserva);
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	
	public ArrayList<Instituicao> listarInstituicao(int idReserva) throws Exception {
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

	public Instituicao procurarInstituicao(int idInstituicao) throws Exception,SQLException {
		System.out.println("Passando pela Fachada procurarInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		return this.controladoraInstituicao.procurarInstituicao(idInstituicao);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void cadastrarPesquisadores(Reserva reserva) throws Exception {
		System.out.println("Passando pela Fachada cadastrarPesquisadores");
		this.controladoraPesquisadores = new ControladorReservaPesquisadores();
		this.controladoraPesquisadores.cadastrarPesquisadores(reserva);
	}

	public ArrayList<Pesquisador> listarPesquisador() throws Exception {
		System.out.println("Passando pela Fachada listarPesquisador");
		this.controladoraPesquisadores = new ControladorReservaPesquisadores();
		return this.controladoraPesquisadores.listarPesquisadores();

	}
	
	public ArrayList<Pesquisador> listarPesquisador(int idReserva) throws Exception {
		System.out.println("Passando pela Fachada listarPesquisador");
		this.controladoraPesquisadores = new ControladorReservaPesquisadores();
		return this.controladoraPesquisadores.listarPesquisadores(idReserva);

	}

	public void editarPesquisador(Pesquisador pesquisador) throws Exception {
		System.out.println("Passando pela Fachada editarPesquisador");
		this.controladoraPesquisadores = new ControladorReservaPesquisadores();
		this.controladoraPesquisadores.editarPesquisador(pesquisador);
	}

	public void removerPesquisador(int idPesquisador) throws Exception {
		System.out.println("Passando pela Fachada removerPesquisador");
		this.controladoraPesquisadores= new ControladorReservaPesquisadores();
		this.controladoraPesquisadores.removerPesquisadores(idPesquisador);
	}

	public Pesquisador procurarPesquisador(int idPesquisador) throws Exception,SQLException {
		System.out.println("Passando pela Fachada procurarPesquisador");
		this.controladoraPesquisadores = new ControladorReservaPesquisadores();
		return this.controladoraPesquisadores.procurarPesquisador(idPesquisador);
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public void cadastrarSolo(Reserva reserva) throws Exception {
		System.out.println("Passando pela Fachada cadastrarSolo");
		this.controladoraSolos = new ControladorReservaSolo();
		this.controladoraSolos.cadastrarSolo(reserva);
	}

	public ArrayList<Solo> listarSolo() throws Exception {
		System.out.println("Passando pela Fachada listarSolo");
		this.controladoraSolos = new ControladorReservaSolo();
		return this.controladoraSolos.listarSolo();

	}
	
	public ArrayList<Solo> listarSolo(int idReserva) throws Exception {
		System.out.println("Passando pela Fachada listarSolo");
		this.controladoraSolos = new ControladorReservaSolo();
		return this.controladoraSolos.listarSolo(idReserva);

	}

	public void editarSolo(Solo solo) throws Exception {
		System.out.println("Passando pela Fachada editarSolo");
		this.controladoraSolos = new ControladorReservaSolo();
		this.controladoraSolos.editarSolo(solo);
	}

	public void removerSolo(int idSolo) throws Exception {
		System.out.println("Passando pela Fachada removerSolo");
		this.controladoraSolos = new ControladorReservaSolo();
		this.controladoraSolos.removerSolo(idSolo);
	}

	public Solo procurarSolo(int idSolo) throws Exception,SQLException {
		System.out.println("Passando pela Fachada procurarSolo");
		this.controladoraSolos = new ControladorReservaSolo();
		return this.controladoraSolos.procurarSolo(idSolo);
	}	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void cadastrarNascente(Reserva reserva) throws Exception {
		System.out.println("Passando pela Fachada cadastrarNascenteAgua");
		this.controladoraNascente = new ControladorReservaNascente();
		this.controladoraNascente.cadastrarNascente(reserva);
	}

	public ArrayList<NascenteAgua> listarNascente() throws Exception {
		System.out.println("Passando pela Fachada listarNascenteAgua");
		this.controladoraNascente = new ControladorReservaNascente();
		return this.controladoraNascente.listarNascentes();

	}
	
	public ArrayList<NascenteAgua> listarNascente(int idReserva) throws Exception {
		System.out.println("Passando pela Fachada listarNascenteAgua");
		this.controladoraNascente = new ControladorReservaNascente();
		return this.controladoraNascente.listarNascentes(idReserva);

	}

	public void editarNascente(NascenteAgua nascente) throws Exception {
		System.out.println("Passando pela Fachada editarNascenteAgua");
		this.controladoraNascente = new ControladorReservaNascente();
		this.controladoraNascente.editarNascente(nascente);
	}

	public void removerNascente(int idNascente) throws Exception {
		System.out.println("Passando pela Fachada removerNascenteAgua");
		this.controladoraNascente= new ControladorReservaNascente();
		this.controladoraNascente.removerNascente(idNascente);;
	}

	public NascenteAgua procurarNascente(int idNascente) throws Exception,SQLException {
		System.out.println("Passando pela Fachada procurarNascenteAgua");
		this.controladoraNascente = new ControladorReservaNascente();
		return this.controladoraNascente.procurarNascente(idNascente);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void cadastrarPlantaPequenoPorte(Reserva reserva) throws Exception {
		System.out.println("Passando pela Fachada cadastrarcadastrarPlantaPequenoPorte");
		this.controladoraPlantas = new ControladorReservaPlantas();
		this.controladoraPlantas.cadastrarPlantaPequenoPorte(reserva);
	}
	
	public ArrayList<PlantaPequenoPorte> listarPlantaPequena() throws Exception{
		System.out.println("Pasando pela Fachada lsitarPlantaPequenoPorte");
		this.controladoraPlantas = new ControladorReservaPlantas();
		return this.controladoraPlantas.listarPlantaPequena();
	}

	public ArrayList<PlantaPequenoPorte> listarPlantaPequena(int idReserva) throws Exception{
		System.out.println("Pasando pela Fachada listarPlantaPequenoPorte");
		this.controladoraPlantas = new ControladorReservaPlantas();
		return this.controladoraPlantas.listarPlantaPequena(idReserva);
	}
	
	public void removerPlantaPequenoPorte(int idPlantaPequena) throws Exception{
		System.out.println("Passando pela Fachada removerPlantaPequenoPorte");
		this.controladoraPlantas = new ControladorReservaPlantas();
		this.controladoraPlantas.removerPlantaPequenoPorte(idPlantaPequena);
		
	}
	
	public PlantaPequenoPorte procurarPlantaPequena(int idPlantaPequena) throws Exception{
		System.out.println("Passando pela fachada procurarPlantaPequena");
		this.controladoraPlantas = new ControladorReservaPlantas();
		return controladoraPlantas.procurarPlantaPequena(idPlantaPequena);
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	public void cadastrarPlantaMedioPorte(Reserva reserva) throws Exception {
		System.out.println("Passando pela Fachada cadastrarPlantaMedioPorte");
		this.controladoraPlantas = new ControladorReservaPlantas();
		this.controladoraPlantas.cadastrarPlantaMedioPorte(reserva);
	}

	public ArrayList<PlantaMedioPorte> listarPlantaMedia() throws Exception{
		System.out.println("Pasando pela Fachada lsitarPlantaMedioPorte");
		this.controladoraPlantas = new ControladorReservaPlantas();
		return this.controladoraPlantas.listarPlantaMedia();
	}	
	
	public ArrayList<PlantaMedioPorte> listarPlantaMedia(int idReserva) throws Exception{
		System.out.println("Pasando pela Fachada lsitarPlantaMedioPorte");
		this.controladoraPlantas = new ControladorReservaPlantas();
		return this.controladoraPlantas.listarPlantaMedia(idReserva);
	}	
	
	public void removerPlantaMedioPorte(int idPlantaMedia) throws Exception{
		System.out.println("Passando pela Fachada removerPlantaMedioPorte");
		this.controladoraPlantas = new ControladorReservaPlantas();
		this.controladoraPlantas.removerPlantaMedioPorte(idPlantaMedia);
		
	}
	
	public PlantaMedioPorte procurarPlantaMedia(int idPlantaMedia) throws Exception{
		System.out.println("Passando pela fachada procurarPlantaPequena");
		this.controladoraPlantas = new ControladorReservaPlantas();
		return controladoraPlantas.procurarPlantaMedia(idPlantaMedia);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void cadastrarPlantaGrandePorte(Reserva reserva) throws Exception {
		System.out.println("Passando pela Fachada cadastrarPlantaGrandePorte");
		this.controladoraPlantas = new ControladorReservaPlantas();
		this.controladoraPlantas.cadastrarPlantaGrandePorte(reserva);
	}
	
	public ArrayList<PlantaGrandePorte> listarPlantaGrande() throws Exception{
		System.out.println("Pasando pela Fachada lsitarPlantaGrandePorte");
		this.controladoraPlantas = new ControladorReservaPlantas();
		return this.controladoraPlantas.listarPlantaGrande();
	}
	
	public ArrayList<PlantaGrandePorte> listarPlantaGrande(int idReserva) throws Exception{
		System.out.println("Pasando pela Fachada lsitarPlantaGrandePorte");
		this.controladoraPlantas = new ControladorReservaPlantas();
		return this.controladoraPlantas.listarPlantaGrande(idReserva);
	}
	
	public void removerPlantaGrandePorte(int idPlantaGrande) throws Exception{
		System.out.println("Passando pela Fachada removerPlantaGrandePorte");
		this.controladoraPlantas = new ControladorReservaPlantas();
		this.controladoraPlantas.removerPlantaGrandePorte(idPlantaGrande);
		
	}
	
	public PlantaGrandePorte procurarPlantaGrande(int idPlantaGrande) throws Exception{
		System.out.println("Passando pela fachada procurarPlantaGramde");
		this.controladoraPlantas = new ControladorReservaPlantas();
		return controladoraPlantas.procurarPlantaGrande(idPlantaGrande);
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void cadastrarUsuario(Usuario usuario) throws Exception {
		System.out.println("Passando pela Fachada cadastrarInstituicao");
		this.controladoraUsuario = new ControladoraUsuario();
		this.controladoraUsuario.cadastrarUsuario(usuario);
	}
	
	public ArrayList<Usuario> listarUsuario() throws Exception{
		System.out.println("Passando pela Fachada listarUsuario");
		this.controladoraUsuario = new ControladoraUsuario();
		return this.controladoraUsuario.listarUsuarios();
	}


	public void editarUsuario(Usuario usuario) throws Exception {
		System.out.println("Passando pela Fachada editarInstituicao");
		this.controladoraUsuario = new ControladoraUsuario();
		this.controladoraUsuario.editarUsuario(usuario);
	}

	public void removerUsuario(int idUsuario) throws Exception {
		System.out.println("Passando pela Fachada removerInstituicao");
		this.controladoraUsuario = new ControladoraUsuario();
		this.controladoraUsuario.removerUsuario(idUsuario);
	}

	public void procurarUsuario(int idUsuario) throws Exception {
		System.out.println("Passando pela Fachada procurarInstituicao");
		this.controladoraUsuario = new ControladoraUsuario();
		this.controladoraUsuario.procurarUsuario(idUsuario);
	}
	
	
}
