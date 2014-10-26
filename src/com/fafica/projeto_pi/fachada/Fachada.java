package com.fafica.projeto_pi.fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.controladora.ControladoraInstituicao;
import com.fafica.projeto_pi.controladora.ControladoraReserva;
import com.fafica.projeto_pi.controladora.ControladoraUsuario;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Usuario;

public class Fachada {

	private static Fachada instance = null;
	private ControladoraReserva controladoraReserva;
	private ControladoraInstituicao controladoraInstituicao;
	private ControladoraUsuario  controladoraUsuario;

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

	public ArrayList<Reserva> listarReservas() throws Exception {
		System.out.println("Passando pela Fachada listarReserva");
		this.controladoraReserva = new ControladoraReserva();
		return this.controladoraReserva.listarReservas();

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

	public void procurarReserva(int idReserva) throws Exception {
		System.out.println("Passando pela Fachada procurarReserva");
		this.controladoraReserva = new ControladoraReserva();
		this.controladoraReserva.procurarReserva(idReserva);
	}

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

	public void procurarInstituicao(int idInstituicao) throws Exception,SQLException {
		System.out.println("Passando pela Fachada procurarInstituicao");
		this.controladoraInstituicao = new ControladoraInstituicao();
		this.controladoraInstituicao.procurarInstituicao(idInstituicao);
	}

	
	public void cadastrarUsuario(Usuario usuario) throws Exception {
		System.out.println("Passando pela Fachada cadastrarInstituicao");
		this.controladoraUsuario = new ControladoraUsuario();
		this.controladoraUsuario.cadastrarUsuario(usuario);
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
