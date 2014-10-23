package com.fafica.projeto_pi.modelos;

import java.util.Date;

public class Usuario {

	private String nome;
	private int senha;
	private Date data;

	public Usuario(String nome, int senha, Date data) {
		this.nome = nome;
		this.senha = senha;
		this.data = data;
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
		return "Usuario [nome=" + nome + ", senha=" + senha + ", data=" + data
				+ "]";
	}

}
