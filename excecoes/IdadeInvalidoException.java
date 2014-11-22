package com.fafica.projeto_pi.excecoes;

public class IdadeInvalidoException extends Exception {
	public IdadeInvalidoException() {
		super("Voc� precisa ter 18 anos ou mais.");
	}
}
