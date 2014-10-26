package com.fafica.projeto_pi.main;

import java.util.ArrayList;

import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Instituicao;

public class TesteListar {

	public static void main(String[] args) {
		
		
		
		Fachada fachada = Fachada.getInstace();
		try{
		ArrayList<Instituicao> lista = fachada.listarInstituicao();
		
		for (Instituicao instituicao : lista) {
			System.out.println(instituicao.toString());
		}
		
		}catch(Exception e){
			System.err.println("Deu Erro main");
			e.printStackTrace();
		}
		
		
	}

}

