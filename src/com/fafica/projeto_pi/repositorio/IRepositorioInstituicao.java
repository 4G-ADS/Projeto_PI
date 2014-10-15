package com.fafica.projeto_pi.repositorio;

public interface IRepositorioInstituicao {

		public void cadastrar(IRepositorioInstituicao instituicao);
		public IRepositorioInstituicao procurar(int id);
		public void atualizar(IRepositorioInstituicao instituicao);
		public void remover(int id);
		public boolean existe(int id);
	
}
