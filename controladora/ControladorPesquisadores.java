package com.fafica.projeto_pi.controladora;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.conexao.Database;
import com.fafica.projeto_pi.excecoes.PesquisadorNaoEncontradoException;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.repoditoioIO.RepositorioPesquisadorIO;
import com.fafica.projeto_pi.repoditoioIO.irepositorioIO.IRepositorioPesquisadorIO;
import com.fafica.projeto_pi.repositorioBDR.RepositorioPesquisadorBDR;
import com.fafica.projeto_pi.repositorioBDR.irepositorioBDR.IRepositorioPesquisador;
import com.fafica.projeto_pi.repositorioCollections.RepositorioPesquisadorMap;
import com.fafica.projeto_pi.repositorioCollections.RepositorioPesquisadorSet;
import com.fafica.projeto_pi.repositorioCollections.irepositorioCollections.IRepositorioPesquisadorMap;
import com.fafica.projeto_pi.repositorioCollections.irepositorioCollections.IRepositorioPesquisadorSet;

public class ControladorPesquisadores {

	IRepositorioPesquisador repositorioPesquisador;
	IRepositorioPesquisadorIO repositorioPesquisadorIO;
	IRepositorioPesquisadorMap repositorioPesquisadorMAP;
	IRepositorioPesquisadorSet repositorioPesquisadorSET;
	
	private int banco = Database.TIPOBANCO;

	public ControladorPesquisadores() throws Exception {
		if(banco == 1){
		this.repositorioPesquisador = new RepositorioPesquisadorBDR();
		}else if(banco == 2){
		this.repositorioPesquisadorIO = new RepositorioPesquisadorIO();
		}else if(banco == 3){
		this.repositorioPesquisadorMAP = new RepositorioPesquisadorMap();
		}else if(banco == 4){
		this.repositorioPesquisadorSET = new RepositorioPesquisadorSet();
		}
	}
	
	public ArrayList<Pesquisador> listarPesquisadores() throws SQLException, IOException {
		System.out.println("Passando pela controladora listarPesquisadores");
		ArrayList<Pesquisador> lista = null; 
		if(banco == 1){
			lista = this.repositorioPesquisador.listarPesquisadores();
			}else if(banco == 2){
			lista = this.repositorioPesquisadorIO.listarPesquisadores();
			}else if(banco == 3){
			lista = this.repositorioPesquisadorMAP.listarPesquisadores();
			}else if(banco == 4){
			lista = this.repositorioPesquisadorSET.listarPesquisadores();
			}
		return lista;
	}

	public ArrayList<Pesquisador> listarPesquisadores(int idReserva) throws SQLException {
		System.out.println("Passando pela controladora listarPesquisadores");
		return this.repositorioPesquisador.listarPesquisadores(idReserva);
	}
	
	public Pesquisador procurarPesquisador(int idPesquisador)throws SQLException, IOException,PesquisadorNaoEncontradoException {
		System.out.println("Passando pela controladora procurarPesquisador");
		Pesquisador pesquisador = null;
		if(banco == 1){
			pesquisador = this.repositorioPesquisador.procurarPesquisadores(idPesquisador);
			}else if(banco == 2){
			pesquisador = this.repositorioPesquisadorIO.procurarPesquisadores(idPesquisador);
			}else if(banco == 3){
			pesquisador = this.repositorioPesquisadorMAP.procurarPesquisadores(idPesquisador);
			}else if(banco == 4){
			pesquisador = this.repositorioPesquisadorSET.procurarPesquisadores(idPesquisador);
			}
		return pesquisador;
		
	}

	public void editarPesquisador(Pesquisador pesquisador) throws SQLException, IOException,PesquisadorNaoEncontradoException{
		System.out.println("Passando pela controladora editarPesquisador");
		
		if(banco == 1){
			this.repositorioPesquisador.editarPesquisadores(pesquisador);
			}else if(banco == 2){
			this.repositorioPesquisadorIO.editarPesquisadores(pesquisador);
			}else if(banco == 3){
			this.repositorioPesquisadorMAP.editarPesquisadores(pesquisador);
			}else if(banco == 4){
			this.repositorioPesquisadorSET.editarPesquisadores(pesquisador);
			}
	}

	public void removerPesquisadores(int idPesquisador) throws SQLException, IOException ,PesquisadorNaoEncontradoException{
		System.out.println("Passando pela controladora removerPesquisador");
		if(banco == 1){
			this.repositorioPesquisador.removerPesquisadores(idPesquisador);
			}else if(banco == 2){
			this.repositorioPesquisadorIO.removerPesquisadores(idPesquisador);
			}else if(banco == 3){
			this.repositorioPesquisadorMAP.removerPesquisadores(idPesquisador);
			}else if(banco == 4){
			this.repositorioPesquisadorSET.removerPesquisadores(idPesquisador);
			}
	}

}
