package br.com.controle.financeiro.controller;

public interface CRUD {

	public void cadastrar(Object o);
	
	public Object verificar(String senha, String cpf);
	
	public void deletar();
	
	public void atualizar();
}
