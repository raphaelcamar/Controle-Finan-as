package br.com.controle.financeiro.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.controle.financeiro.dao.GenericDAO;

public class GenericDAOImpl<E,K> implements GenericDAO<E, K> {
	
	protected EntityManager em;
	private Class<E> clazz;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void cadastrar(E entidade) {
		em.persist(entidade);
		
	}


	public void atualizar(E entidade) {
		em.merge(entidade);
	}


	public void deletarPorPk(K chave) {
		E entidade = pesquisarPorPk(chave);
		em.remove(entidade);
		
	}

	public E pesquisarPorPk(K chave) {
		E entidade = em.find(clazz, chave);
		return entidade;
	}


	public void commit() {
		em.getTransaction().begin();
		em.getTransaction().commit();
	}
}
