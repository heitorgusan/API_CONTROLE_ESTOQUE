package com.controledeestoque.br.model;

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
@Table(name = "tb_estoque")
public class EstoqueModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private ProdutoModel produto;
	
	@NotNull
	private String loteProduto;
	
	@NotNull
	@PositiveOrZero
	private double precoCustoUnitario;
	
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


	public String getLoteProduto() {
		return loteProduto;
	}

	public void setLoteProduto(String loteProduto) {
		this.loteProduto = loteProduto;
	}

	

	public double getPrecoCustoUnitario() {
		return precoCustoUnitario;
	}

	public void setPrecoCustoUnitario(double precoCustoUnitario) {
		this.precoCustoUnitario = precoCustoUnitario;
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