package com.controledeestoque.br.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.controledeestoque.br.model.EntradaModel;
import com.controledeestoque.br.model.EstoqueProdutoDetalhadoModel;
import com.controledeestoque.br.repository.EstoqueProdutoDetalhadoRepository;

public class EstoqueProdutoDetalhadoService {

	@Autowired
	EstoqueProdutoDetalhadoRepository estoqueProduto;
	public void criarTabelaEstoque(EntradaModel entrada){
		
		String lote = entrada.getLoteProduto();
		EstoqueProdutoDetalhadoModel estoque = new EstoqueProdutoDetalhadoModel();
		if(estoque.getLoteProduto() == lote) {
			
		}
		
		
	}
}
