package com.fafica.projeto_pi.modelos;

import java.util.Date;

public class Usuario {
	private int idReserva;
	private int idUsuario;
	private String nome;
	private int senha;
	private Date data;

	public Usuario(int idReserva, int idUsuario, String nome, int senha,
			Date data) {
		this.idReserva = idReserva;
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.senha = senha;
		this.data = data;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Usuario [idReserva=" + idReserva + ", idUsuario=" + idUsuario
				+ ", nome=" + nome + ", senha=" + senha + ", data=" + data
				+ "]";
	}

}
