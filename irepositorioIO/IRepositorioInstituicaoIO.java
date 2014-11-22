package com.fafica.projeto_pi.repoditoioIO.irepositorioIO;

import java.io.IOException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.Instituicao;

public interface IRepositorioInstituicaoIO {

		public void cadastrarInstituicao(Instituicao instituicao) throws IOException;
		public ArrayList<Instituicao> listarInstituicao() throws IOException;
		public Instituicao procurarInstituicao(int idInstituicao) throws IOException;
		public void editarInstituicao(Instituicao instituicao) throws IOException;
		public void removerInstituicao(int idInstituicao) throws IOException;
		
		
}
