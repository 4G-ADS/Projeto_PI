package com.fafica.projeto_pi.repoditoioIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.repoditoioIO.irepositorioIO.IRepositorioInstituicaoIO;


public class RepositorioInstituicaoIO implements IRepositorioInstituicaoIO{

	private void salvar(ArrayList<Instituicao> listaInstituicao) throws IOException{
		
		FileWriter arquivo = new FileWriter("arquivoInstituicao.txt");
		BufferedWriter escritor = new BufferedWriter(arquivo);
	
		
			for (Instituicao instituicao : listaInstituicao) {
				String gravar = instituicao.getIdInstituicao() + "-" +
						instituicao.getNome() + "-" + 
						instituicao.getCnpj() + "-" +	
						instituicao.getTipo();
		
		escritor.write(gravar);
		escritor.newLine();
			}	

		escritor.close();
		arquivo.close();
			
	}
	
	private ArrayList<Instituicao>rescuperar() throws IOException{
		
		ArrayList<Instituicao> listaInstituicao = new ArrayList<Instituicao>();
		FileReader arquivo = new FileReader("arquivoInsttuicao.txt");
		BufferedReader leitor = new BufferedReader(arquivo);
		
		while(leitor.ready()){
			
			String [] recebe = leitor.readLine().split("-");
			
			Instituicao instituicao = new Instituicao(recebe[0], recebe[1], recebe[3]);
			
			listaInstituicao.add(instituicao);
			
			
		}
		
		leitor.close();
		arquivo.close();
		
		return listaInstituicao;
	}
	
	
	@Override
	public void cadastrarInstituicao(Instituicao instituicao)
			throws  IOException {
		ArrayList<Instituicao> listaProvisoria = new ArrayList<Instituicao>();
		listaProvisoria.add(instituicao);
		salvar(listaProvisoria);
		
	}

	@Override
	public ArrayList<Instituicao> listarInstituicao() throws  IOException {
		ArrayList<Instituicao> listaProvisoria= rescuperar();
		return listaProvisoria;
	}

	@Override
	public Instituicao procurarInstituicao(int idInstituicao)
			throws IOException {
		ArrayList<Instituicao> listaProvisoria= rescuperar();
		Instituicao instituicao = null;
		for (Instituicao instituicaoProvisoria : listaProvisoria) {
			if(instituicaoProvisoria.getIdInstituicao() == idInstituicao){
				instituicao = instituicaoProvisoria;
				break;
			}
		}

		return instituicao;
	}

	@Override
	public void editarInstituicao(Instituicao instituicao) throws IOException {
		ArrayList<Instituicao> listaProvisoria= rescuperar();
		for (Instituicao instituicaoProvisoria : listaProvisoria) {
			if(instituicaoProvisoria.getIdInstituicao() == instituicao.getIdInstituicao()){
				instituicaoProvisoria = instituicao;
				salvar(listaProvisoria);
				break;
			}
		}
		
	}

	@Override
	public void removerInstituicao(int idInstituicao) throws  IOException {
		ArrayList<Instituicao> listaProvisoria= rescuperar();
		for (Instituicao instituicaoProvisoria : listaProvisoria) {
			if(instituicaoProvisoria.getIdInstituicao() == idInstituicao){
				listaProvisoria.remove(instituicaoProvisoria);
				salvar(listaProvisoria);
				break;
			}
		}
		
	
		
	}

}
