package com.controledeestoque.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledeestoque.br.model.EntradaModel;
import com.controledeestoque.br.model.PrecoCustoProdutoModel;
import com.controledeestoque.br.model.ProdutoModel;
import com.controledeestoque.br.repository.EntradaRepository;
import com.controledeestoque.br.repository.PrecoCustoProdutoRepository;
import com.controledeestoque.br.repository.ProdutoRepository;

@Service
public class EntradaService {

	@Autowired
	EntradaRepository entradaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	PrecoCustoProdutoRepository precoCustoProdutoRepository;
	public EntradaModel cadastrarEntradaProduto(EntradaModel entrada) {
		ProdutoModel produto = produtoRepository.getById(entrada.getProduto().getId());
		entrada.setNomeProduto(produto.getNome());
		entrada.setTotal(entrada.getQuantidade() * entrada.getPrecoUnitario());
		salvarHistoricoPrecoCusto(produto,entrada);
		addEstoqueProduto(produto,entrada.getQuantidade());
		return entradaRepository.save(entrada);
	}
	
	private void salvarHistoricoPrecoCusto(ProdutoModel produto, EntradaModel entrada) {
		
		PrecoCustoProdutoModel precoCustoProduto = new PrecoCustoProdutoModel();
		
		precoCustoProduto.setProduto(produto);
		precoCustoProduto.setPrecoUnitario(entrada.getPrecoUnitario());
		precoCustoProduto.setEntrada(entrada);
		
		precoCustoProdutoRepository.save(precoCustoProduto);
		
	}
	
	private void addEstoqueProduto(ProdutoModel produto, int quantidadeEntrada) {
		produto.setQuantidadeAtual(produto.getQuantidadeAtual() + quantidadeEntrada);
		produtoRepository.save(produto);
	}
}