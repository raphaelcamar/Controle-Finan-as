package br.com.controle.financeiro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.controle.financeiro.bean.Usuario;
import br.com.controle.financeiro.dao.UsuarioDAO;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager em) {
		super(em);
	}
	
	//fazer querys com JPQL
	public List<Usuario> retornaCPF(String cpf) {
		List<Usuario> u = new ArrayList<>();
		u = em.createQuery("from Usuario u where u.cpf =: cpf", Usuario.class)
				.setParameter("cpf", cpf)
				.getResultList();
		return u;
	}
	
	public List<Usuario> retornaEmail(String email) {
		List<Usuario> u = new ArrayList<>();
		  u = em.createQuery("from Usuario u where u.email =: email", Usuario.class)
				.setParameter("email", email)
				.getResultList();
		  
		 return u;
	}
	
	public List<Usuario> retornaLogin(String cpf, String senha) throws NoResultException{
		List<Usuario> u = new ArrayList<>();
		u = em.createQuery("from Usuario u where u.cpf = :cpf and u.senha=:senha", Usuario.class)
		.setParameter("cpf", cpf)
		.setParameter("senha", senha)
		.getResultList();
	return u;
		
	}
}
