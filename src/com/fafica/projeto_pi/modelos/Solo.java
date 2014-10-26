package com.fafica.projeto_pi.modelos;

public class Solo {
	
	private int idSolo;
	private String tipo;
	private double tamanho;
	private String resursos;
	
	public Solo(int idSolo, String tipo, double tamanho,
			String resursos) {
		
		this.idSolo = idSolo;
		this.tipo = tipo;
		this.tamanho = tamanho;
		this.resursos = resursos;
	}


	public int getIdSolo() {
		return idSolo;
	}

	public void setIdSolo(int idSolo) {
		this.idSolo = idSolo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public String getResursos() {
		return resursos;
	}

	public void setResursos(String resursos) {
		this.resursos = resursos;
	}

	@Override
	public String toString() {
		return "Solo [idSolo=" + idSolo	+ ", tipo=" + tipo + ", tamanho=" + tamanho
				+ ", resursos="	+ resursos + "]";
	}		

}
