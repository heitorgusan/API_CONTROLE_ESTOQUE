package com.controledeestoque.br.model;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class ProdutoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 3 , max = 100)
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Size(min = 3 , max = 100)
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private double valorTotalEstoque;
	
	@PositiveOrZero
	@Column(nullable = false)
	private int quantidadeAtual;
	
	@NotNull
	@PositiveOrZero
	@Column(nullable = false)
	private int quantidadeMinima;
	
	@NotNull
	@Positive
	@Column(nullable = false)
	private int quantidadeMaxima;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date criadoEm = new java.sql.Date(System.currentTimeMillis());
	
	private LocalDateTime ultimaAlteracao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeAtual() {
		return quantidadeAtual;
	}

	public void setQuantidadeAtual(int quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}

	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	public int getQuantidadeMaxima() {
		return quantidadeMaxima;
	}

	public void setQuantidadeMaxima(int quantidadeMaxima) {
		this.quantidadeMaxima = quantidadeMaxima;
	}

	public Date getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public LocalDateTime getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(LocalDateTime ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public double getValorTotalEstoque() {
		return valorTotalEstoque;
	}

	public void setValorTotalEstoque(double valorTotalEstoque) {
		this.valorTotalEstoque = valorTotalEstoque;
	}
	
}