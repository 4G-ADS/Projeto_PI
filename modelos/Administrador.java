package com.fafica.projeto_pi.modelos;

public class Administrador {

	private int id;
	private String nome;
	private String login;
	private String cpf;
	private int senha;	

	public Administrador(int id,String nome, String login, String cpf, int senha) {
		
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.cpf = cpf;
		this.senha = senha;

	}
	public Administrador(String nome, String login, String cpf, int senha) {
		
		this.nome = nome;
		this.login = login;
		this.cpf = cpf;
		this.senha = senha;

	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf.replaceAll("\\.|\\-|\\ ", "");
	}


	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nome=" + nome + ", login="
				+ login + ", cpf=" + cpf + ", senha=" + senha + "]";
	}


}
