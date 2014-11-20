package com.fafica.projeto_pi.repoditoioIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.repoditoioIO.irepositorioIO.IRepositorioPesquisadorIO;

public class RepositorioPesquisadorIO implements IRepositorioPesquisadorIO{

	private void salvar(ArrayList<Pesquisador> listaPesquisador) throws IOException{
		
		FileWriter arquivo = new FileWriter("arquivoInstituicao.txt");
		BufferedWriter escritor = new BufferedWriter(arquivo);
	
		
			for (Pesquisador pesquisador : listaPesquisador) {
				String gravar = pesquisador.getIdPesquisador() + "-" +
						pesquisador.getNome() + "-" + 						
						pesquisador.getCpf() + "-" +
						pesquisador.getIdade() + "-" +
						pesquisador.getProfissao();
		
		escritor.write(gravar);
		escritor.newLine();
			}	

		escritor.close();
		arquivo.close();
			
	}
	
	private ArrayList<Pesquisador>rescuperar() throws IOException{
		
		ArrayList<Pesquisador> listaPesquisador = new ArrayList<Pesquisador>();
		FileReader arquivo = new FileReader("arquivoInsttuicao.txt");
		BufferedReader leitor = new BufferedReader(arquivo);
		
		while(leitor.ready()){
			
			String [] recebe = leitor.readLine().split("-");
			
			Pesquisador pesquisador = new Pesquisador(recebe[0], recebe[1],Integer.parseInt(recebe[3]), recebe[4]);
			
			listaPesquisador.add(pesquisador);
			
			
		}
		
		leitor.close();
		arquivo.close();
		
		return listaPesquisador;
	}
	
	
	
	@Override
	public void cadastrarPesquisadores(Pesquisador pesquisador)
			throws  IOException {
		ArrayList<Pesquisador> listaProvisoria = new ArrayList<Pesquisador>();
		listaProvisoria.add(pesquisador);
		salvar(listaProvisoria);		
	}

	@Override
	public ArrayList<Pesquisador> listarPesquisadores() throws  IOException {
		ArrayList<Pesquisador> listaProvisoria = rescuperar();
		return listaProvisoria;
	}


	@Override
	public Pesquisador procurarPesquisadores(int idPesquisador)
			throws  IOException {
	ArrayList<Pesquisador> listaProvisoria = rescuperar();
	Pesquisador pesquisador = null;
	for (Pesquisador pesquisadorProvisorio : listaProvisoria) {
		if(pesquisadorProvisorio.getIdPesquisador() == idPesquisador){
			pesquisador = pesquisadorProvisorio;
			break;
		}
	}
		return pesquisador;
	}

	@Override
	public void editarPesquisadores(Pesquisador pesquisador)
			throws  IOException {

		ArrayList<Pesquisador> listaProvisoria = rescuperar();
		for (Pesquisador pesquisadorProvisorio : listaProvisoria) {
			if(pesquisadorProvisorio.getIdPesquisador() == pesquisador.getIdPesquisador()){
				pesquisador = pesquisadorProvisorio;
				salvar(listaProvisoria);
				break;
			}
		}
		
		
	}

	@Override
	public void removerPesquisadores(int idPesquisador) throws  IOException {

		ArrayList<Pesquisador> listaProvisoria = rescuperar();
		for (Pesquisador pesquisadorProvisorio : listaProvisoria) {
			if(pesquisadorProvisorio.getIdPesquisador() == idPesquisador){
				listaProvisoria.remove(pesquisadorProvisorio);
				salvar(listaProvisoria);
				break;
			}
		}
		
		
		
		
	}


}
