package br.com.controle.financeiro.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CON_FIN_USUARIO")
public class Usuario {
	
	@Id
	@Column(name="CD_USUARIO")
	@SequenceGenerator(allocationSize = 1, name = "usuario_sq_fin",sequenceName = "usuario_sq_fin")
	@GeneratedValue(generator = "usuario_sq_fin", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="NOME", nullable = false, length = 70)
	private String nome;
	
	@Column(name="SOBRENOME", nullable = false, length = 150)
	private String sobrenome;
	
	@Column(name="senha", nullable = false)
	private String senha;
	
	@Column(name="CPF", nullable= false)
	private String cpf;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(mappedBy = "usuario")
	private List<Financas> financas;

	public Usuario(String nome, String sobrenome, String email, String cpf, String senha) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
	}

	public Usuario() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
