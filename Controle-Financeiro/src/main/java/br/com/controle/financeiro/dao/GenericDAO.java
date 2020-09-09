package br.com.controle.financeiro.dao;

public interface GenericDAO<E, K> {
	
	void cadastrar(E entidade);
	
	void atualizar(E entidade);
	
	void deletarPorPk(K chave);
	
	E pesquisarPorPk(K chave);
	
	void commit();

}
