package com.fafica.projeto_pi.excecoes;

public class AdministradorJaCadastradoException extends Exception{
	public AdministradorJaCadastradoException(){
        super ("Usuário já cadastrado!");
    }

}
