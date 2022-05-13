package com.controledeestoque.br.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_precoCustoProduto")
public class PrecoCustoProdutoModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	ProdutoModel idProduto;
	
	@OneToMany
	@JoinColumn(name = "id_entrada")
	List<EntradaModel> idEntrada;
	
	@Column(nullable = false)
	private double precoUnitario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProdutoModel getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(ProdutoModel idProduto) {
		this.idProduto = idProduto;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public List<EntradaModel> getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(List<EntradaModel> idEntrada) {
		this.idEntrada = idEntrada;
	}
	
	
	
}