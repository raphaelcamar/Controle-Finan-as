package br.com.fiap.testes;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.controle.financeiro.bo.UsuarioBO;

class TesteValidar {

	@BeforeAll
	//Ele será chamado antes de todos os métodos
	static void inicializar() {
		
	}
	
	@BeforeEach
	//Ele será chamado antes de cada teste
	static void paraCadaUm() {
		
	}
	UsuarioBO bo = new UsuarioBO();
	@Test
	@DisplayName("Nome válido")
	void validarNometest() {
		assertEquals(true, bo.validarNome("Rapha1el"));
	}
	@Test
	@DisplayName("CPF válido")
	void validarCpfTest() {
		assertEquals(true, bo.validarCPF("427.00qwe4.328-86"));
	}
	@Test
	@DisplayName("senha válida")
	void validarSenhaTest() {
		assertEquals(true, bo.validarSenha("y98eeww3hf3256afg"));
		
	}
	@Test
	@DisplayName("sobrenome válido")
	void validarSobrenomeTest() {
		assertEquals(true, bo.validarSobrenome("Santa"));
	}

}
