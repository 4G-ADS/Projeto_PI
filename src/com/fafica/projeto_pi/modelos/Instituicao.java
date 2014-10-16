package com.fafica.projeto_pi.modelos;

public class Instituicao {
	
	private int idInstituicao;
	private String nome;
	private String tipo;
	private String cnpj;
	
	//construtor
	public Instituicao(int idInstituicao, String nome, String tipo, String cnpj) {
		super();
		this.idInstituicao = idInstituicao;
		this.nome = nome;
		this.tipo = tipo;
		this.cnpj = cnpj;
	}
	
	//gets e sets
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
		this.cnpj = cnpj;
	}
	
	//toString
	@Override
	public String toString() {
		return "Instituicao [idInstituicao=" + idInstituicao + ", nome=" + nome
				+ ", tipo=" + tipo + ", cnpj=" + cnpj + "]";
	}
	
	
	

}
