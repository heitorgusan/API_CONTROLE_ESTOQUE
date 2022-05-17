package com.controledeestoque.br.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "tb_saida")
public class SaidaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private ProdutoModel produto;
	
	@NotNull
	private String loteProduto;
	
	@NotNull
	@Positive
	private int quantidade;
	
	private double totalSaida;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataSaida = new java.sql.Date(System.currentTimeMillis());

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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getTotalSaida() {
		return totalSaida;
	}

	public void setTotalSaida(double totalSaida) {
		this.totalSaida = totalSaida;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
}