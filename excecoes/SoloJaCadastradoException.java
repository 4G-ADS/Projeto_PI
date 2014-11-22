package com.fafica.projeto_pi.excecoes;

public class SoloJaCadastradoException extends Exception {
	public SoloJaCadastradoException(){
		super("Solo ja cadastrado");
	}

}
