package br.com.controle.financeiro.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CON_FIN_FINANCAS")
public class Financas {

	@Id
	@Column(name="CD_USUARIO")
	@SequenceGenerator(allocationSize = 1, name = "financa_sq_fin",sequenceName = "financa_sq_fin")
	@GeneratedValue(generator = "financa_sq_fin", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable = false, length = 50)
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;
	
	@Column(nullable = false)
	private double valor;
	
	@Column(nullable = false, length = 30)
	private String metodoPagamento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	public Financas() {
		super();
	}

	public Financas(String descricao, Date data, double valor, String metodoPagamento, Usuario usuario) {
		super();
		this.usuario = usuario;
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
		this.metodoPagamento = metodoPagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
