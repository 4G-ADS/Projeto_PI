package com.fafica.projeto_pi.controladora;

import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Agua;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.repositorio.RepositorioAgua;
import com.fafica.projeto_pi.repositorio.irepositorio.IRepositorioAgua;

public class ControladoraAgua {

	private IRepositorioAgua reposirtorioAgua;
	
	public ControladoraAgua (){
		this.reposirtorioAgua = new RepositorioAgua();
	}
	
	
	/*Metodo cadastrar ele vai receber uma reserva pois dentro da reserva tem uma lista de
	 * nascentes de agua, ele vai usar um laço para enviar cada uma das nascentes para o 
	 * metodo cadastrarAgua que esta no repositorioAgua
	 */	
	public void cadastrarAgua(Reserva reserva){
		System.out.println("Panssando pelo cadastrarAgua em controladoraAgua");
		for (Agua agua : reserva.getAgua()) {
			this.reposirtorioAgua.cadastrarAgua(agua);
		}
	}
	
	/*Metodo que vai listar as nascentes 
	 * de uma determinada reserva
	 */	
	public ArrayList<Agua> listarAgua(){
		System.out.println("Panssando pelo listarAgua em controladoraAgua");
		return this.reposirtorioAgua.listaAgua();
				
	}
	
	/*Metodo que vai fazer um procurar no banco por uma 
	 * determinada nascente
	 * recebe um tipo inteiro
	 */	
	public Agua procurarAgua(int idAgua){
		System.out.println("Panssando pelo procurarAgua em controladoraAgua");
		this.reposirtorioAgua.procurarAgua(idAgua);
		return null;
	}	
	
	/*Metodo que vai editar uma nascente que ja exite no 
	 * banco redebe um tipo Agua
	 */
	public void editarAgua(Agua agua){
		System.out.println("Panssando pelo editarAgua em controladoraAgua");
		this.reposirtorioAgua.editarAgua(agua);
	}
	
	/*Metodo que vai remover uma nascente que ja existe no banco
	 * recebe um idAgua do tipo inteiro
	 */
	public void removerAgua(int idAgua){
		System.out.println("Panssando pelo removerAgua em controladoraAgua");
		this.reposirtorioAgua.removerAgua(idAgua);
	}
	
	/*Metodo que vai veirficar se ja existe alguma nascente e vai auxiliar 
	 * outros metodos
	 * recebe um tipo inteiro
	 */	
	public boolean existirAgua(int idAgua){
		System.out.println("Panssando pelo existirAgua em controladoraAgua");
		this.reposirtorioAgua.existeAgua(idAgua);
		return false;
	}
}
