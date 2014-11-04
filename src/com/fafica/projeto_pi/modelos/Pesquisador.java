package com.fafica.projeto_pi.modelos;

public class Pesquisador {

	private int idPesquisador;
	private int idReserva;
	private String nome;
	private String cpf;
	private int idade;
	private String tipo;

	// construtor com campos
	public Pesquisador( String nome,String cpf, int idade, String tipo,int idReserva) {
		super();
		this.idReserva = idReserva;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.tipo = tipo;
	}

	public Pesquisador(int idPesquisador, String nome, String cpf, int idade,
			String tipo) {

		this.idPesquisador = idPesquisador;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.tipo = tipo;
	}

	public Pesquisador(String nome, String cpf, int idade, String tipo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.tipo = tipo;
	}

	// metodos gets e sets

	public int getIdPesquisador() {
		return idPesquisador;
	}

	public void setIdPesquisador(int idPesquisador) {
		this.idPesquisador = idPesquisador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	@Override
	public String toString() {
		return "Pesquisador [idPesquisador=" + idPesquisador + ", idReserva="
				+ idReserva + ", nome=" + nome + ", cpf=" + cpf + ", idade="
				+ idade + ", tipo=" + tipo + "]";
	}

}
