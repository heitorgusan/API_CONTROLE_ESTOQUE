package com.controledeestoque.br.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "tb_saida")
public class SaidaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_entrada")
	private EntradaModel entrada;
	
	@Positive
	private int quantidade;
	
	private double valorTotal;
	
	private Date dataSaida = new java.sql.Date(System.currentTimeMillis());
	
	
}
