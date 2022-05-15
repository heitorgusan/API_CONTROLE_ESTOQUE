package com.controledeestoque.br.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "tb_estoqueProdutoDetalhado")
public class EstoqueProdutoDetalhadoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private ProdutoModel produto;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_entrada")
	private EntradaModel entrada;
	
	@NotNull
	private String loteProduto;
	
	@NotNull
	@PositiveOrZero
	private double precoCustoLote;
	
	@NotNull
	@PositiveOrZero
	private int quantidadeEstoqueLote;
	
	@NotNull
	private double valorTotalLote;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProdutoModel getProduto() {
		return produto;
	}

	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}

	public EntradaModel getEntrada() {
		return entrada;
	}

	public void setEntrada(EntradaModel entrada) {
		this.entrada = entrada;
	}

	public String getLoteProduto() {
		return loteProduto;
	}

	public void setLoteProduto(String loteProduto) {
		this.loteProduto = loteProduto;
	}

	public double getPrecoCustoLote() {
		return precoCustoLote;
	}

	public void setPrecoCustoLote(double precoCustoLote) {
		this.precoCustoLote = precoCustoLote;
	}

	public int getQuantidadeEstoqueLote() {
		return quantidadeEstoqueLote;
	}

	public void setQuantidadeEstoqueLote(int quantidadeEstoqueLote) {
		this.quantidadeEstoqueLote = quantidadeEstoqueLote;
	}

	public double getValorTotalLote() {
		return valorTotalLote;
	}

	public void setValorTotalLote(double valorTotalLote) {
		this.valorTotalLote = valorTotalLote;
	}
}