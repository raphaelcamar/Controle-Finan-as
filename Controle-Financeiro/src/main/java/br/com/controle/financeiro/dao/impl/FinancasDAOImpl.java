package br.com.controle.financeiro.dao.impl;

import javax.persistence.EntityManager;

import br.com.controle.financeiro.bean.Financas;
import br.com.controle.financeiro.dao.FinancasDAO;

public class FinancasDAOImpl extends GenericDAOImpl<Financas, Integer> implements FinancasDAO{

	public FinancasDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	
}
