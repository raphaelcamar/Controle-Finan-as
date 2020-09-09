package br.com.controle.financeiro.bo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.controle.financeiro.bean.Usuario;
import br.com.controle.financeiro.bo.UsuarioBO;

public class UsuarioBOAbs {

	public UsuarioBOAbs(Usuario usuario, UsuarioBO bo, EntityManager em) {
		super();
		limparLista();
		this.usuario = usuario;
		this.bo = bo;
		this.em = em;
		erroNome();
		erroSobrenome();
		erroSenha();
		erroCPF();
		erroEmail();
		erroEmailEx();
		erroCpfEx();
	}

	private List<String> lista = new ArrayList<String>();
	private Usuario usuario;
	private UsuarioBO bo;
	private EntityManager em;

	public void erroNome() {
		if (bo.validarNome(usuario.getNome()) == false) {
			lista.add("O nome deverá ser válido!");
		}
	}

	public void erroSobrenome() {
		if (bo.validarSobrenome(usuario.getSobrenome()) == false) {
			lista.add("O sobrenome deverá ser válido");
		}
	}

	public void erroSenha() {
		if (bo.validarSenha(usuario.getSenha()) == false) {
			lista.add("A senha deverá ser válida");
		}
	}

	public void erroCPF() {
		if (bo.validarCPF(usuario.getCpf()) == false) {
			lista.add("O CPF deverá ser válido");
		}
	}

	public void erroEmail() {
		if (bo.validarEmail(usuario.getEmail()) == false) {
			lista.add("O E-mail deverá ser válido!");
		}
	}

	public void erroEmailEx() {
		if(bo.validarEmailEx(usuario.getEmail(), em).isEmpty() == false) {
			lista.add("O email já está em uso!");
		}
	}

	public void erroCpfEx() {
		if (bo.validarUserEx(usuario.getCpf(), em).isEmpty() == false) {
			lista.add("O CPF já está em uso!");
		}
	}

	public List<String> retornaLista() {
		return lista;
	}

	public void limparLista() {
		lista.clear();
	}

}
