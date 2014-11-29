package com.fafica.projeto_pi.modelos;

public class Instituicao {

	private int idInstituicao;
	private int idReserva;
	private String nome;
	private String tipo;
	private String cnpj;

	// construtor
	public Instituicao(String nome,String tipo, String cnpj,int idreserva ) {
		this.nome = nome;
		this.tipo = tipo;
		this.cnpj = cnpj;
		this.idReserva = idreserva;
	}

	public Instituicao(int idInstituicao, String nome, String tipo, String cnpj) {
		this.idInstituicao = idInstituicao;
		this.nome = nome;
		this.tipo = tipo;
		this.cnpj = cnpj;
	}

	public Instituicao(String nome, String tipo, String cnpj) {
		this.nome = nome;
		this.tipo = tipo;
		this.cnpj = cnpj;
	}

	// gets e sets
	public int getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(int idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj.replaceAll("\\.|\\.|\\/|\\-|\\","");
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	// toString
	@Override
	public String toString() {
		return "Instituicao [IdReserva=" + idReserva+ "idInstituicao="
				+ idInstituicao + ", nome=" + nome + ", tipo=" + tipo
				+ ", cnpj=" + cnpj + "]";
	}

}
