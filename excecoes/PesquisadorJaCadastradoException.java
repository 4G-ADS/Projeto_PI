package com.fafica.projeto_pi.excecoes;

public class PesquisadorJaCadastradoException extends Exception{
	public PesquisadorJaCadastradoException(){
        super ("Pesquisador já cadastrado!");
    }
}
