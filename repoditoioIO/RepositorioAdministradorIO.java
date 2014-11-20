package com.fafica.projeto_pi.repoditoioIO;

import java.io.BufferedReader;import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.repoditoioIO.irepositorioIO.IRepositorioAdminstradorIO;


public class RepositorioAdministradorIO implements IRepositorioAdminstradorIO{

	private void salvar(ArrayList<Administrador> listaProvisoria ) throws IOException{
		
		FileWriter arquivo = new FileWriter("arquivoAdministrardor.txt");
		BufferedWriter escritor = new BufferedWriter(arquivo);
	
		for (Administrador administrador : listaProvisoria) {
			String gravar = administrador.getId() + "-" +
					administrador.getNome() + "-" + 
					administrador.getLogin() + "-" +	
					administrador.getCpf() + "-" +
					administrador.getSenha();
	
	escritor.write(gravar);
	escritor.newLine();
		}
					

		escritor.close();
		arquivo.close();
			
	}
	
	private ArrayList<Administrador> rescuperar() throws IOException{
		
		ArrayList<Administrador> listaAdministrador = new ArrayList<Administrador>();
		FileReader arquivo = new FileReader("arquivoAdministrardor.txt");
		BufferedReader leitor = new BufferedReader(arquivo);
		
		while(leitor.ready()){
			
			String [] recebe = leitor.readLine().split("-");
			
			Administrador administrador = new Administrador(Integer.parseInt(recebe[0]),recebe[1], recebe[2],
					Integer.parseInt(recebe[3]), Integer.parseInt(recebe[4]));
			
			listaAdministrador.add(administrador);
			
			
		}
		
		leitor.close();
		arquivo.close();
		
		return listaAdministrador;
	}
	
	@Override
	public void cadastrarAdministrador(Administrador administrador)
			throws IOException {
		ArrayList<Administrador> listaProvisoria = new ArrayList<Administrador>();
		listaProvisoria.add(administrador);
		salvar(listaProvisoria);		
	}

	@Override
	public void editarAdministrador(Administrador administrador) throws IOException {
		ArrayList<Administrador> listaProvisoria = rescuperar();
		
		for (Administrador adm : listaProvisoria) {
			if(administrador.getCpf() == adm.getCpf()){
				adm = administrador;
				salvar(listaProvisoria);
			}
		}		
		
	}

	@Override
	public void removerAdministrador(int idAdministrador) throws IOException {
		ArrayList<Administrador> listaProvisoria = rescuperar();
		
		for (Administrador adm : listaProvisoria) {
			if(adm.getId() == idAdministrador ){
				listaProvisoria.remove(adm);
				salvar(listaProvisoria);
			}
		}		
		
	
		
	}

	@Override
	public Administrador procurarAdministrador(int idAdministrador) throws IOException {
		ArrayList<Administrador> listaProvisoria = rescuperar();
		Administrador administrador = null;
		
		for (Administrador adm : listaProvisoria) {
			if(adm.getId() == idAdministrador ){
			administrador = adm;
			break;
			}
		}
		
		return administrador;
	}

	@Override
	public ArrayList<Administrador> listarAdministrador() throws IOException {
		ArrayList<Administrador> listaProvisoria = rescuperar();
		return listaProvisoria;
	}

}
