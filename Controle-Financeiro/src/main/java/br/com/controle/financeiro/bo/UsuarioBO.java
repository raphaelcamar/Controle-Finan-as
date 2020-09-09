package br.com.controle.financeiro.bo;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;

import br.com.controle.financeiro.bean.Usuario;
import br.com.controle.financeiro.dao.impl.UsuarioDAOImpl;

public class UsuarioBO {

	public boolean validarNome(String nome) {
		for (int i = 0; i < nome.length(); i++) {
			if (Character.isSpaceChar((nome.charAt(i)))) {
				return false;
			}
		}
		if(nome.length() > 69) {
			return false;
		}
		String expression = "^[[ ]|\\p{L}*]+$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(nome);
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}

	public boolean validarSobrenome(String sobrenome) {
		
		if(sobrenome.length() > 149) {
			return false;
		}
	
		String expression = "^[[ ]|\\p{L}*]+$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(sobrenome);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public boolean validarSenha(String senha) {
	
		if (senha.length() > 20 || senha.length() < 6) {
			return false;
			
		}
		if (senha == null || senha.isEmpty()) {
			return false;
			
		}
		for (int i = 0; i < senha.length(); i++) {
			if (Character.isSpaceChar((senha.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	public boolean validarCPF(String cpf) {
		String expression = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(cpf);
		if (matcher.matches()) {
			return true;
		}		
	
		return false;
	}

	public boolean validarLogin(String senha, String cpf, EntityManager em) {

		List<Usuario> u  = new UsuarioDAOImpl(em).retornaLogin(cpf, senha);
		if(u.isEmpty()) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public boolean validarEmail(String email) {
		String expression = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return true;
		}		
		return false;
	}

	public List<Usuario> validarUserEx(String cpf, EntityManager em) {
		
		List<Usuario> isTrue = new UsuarioDAOImpl(em).retornaCPF(cpf);
		return isTrue;
	}

	public List<Usuario> validarEmailEx(String email, EntityManager em) {
		
		List<Usuario> isTrue = new UsuarioDAOImpl(em).retornaEmail(email);
		
		return isTrue;
	}
}