package com.controledeestoque.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledeestoque.br.model.EntradaModel;
import com.controledeestoque.br.model.ProdutoModel;
import com.controledeestoque.br.repository.EntradaRepository;
import com.controledeestoque.br.repository.ProdutoRepository;

@Service
public class EntradaService {
	
	@Autowired
	EntradaRepository entradaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	EstoqueService estoqueService;
	public EntradaModel cadastrarEntrada(EntradaModel entrada) {
		
		entrada.setNomeProduto(findNomeProduto(entrada.getProduto()));
		entrada.setValorTotal(calcularValorTotal(entrada.getQuantidade(),entrada.getPrecoUnitario()));
		produtoService.atualizarQuantidade(entrada.getProduto(), entrada.getQuantidade(),true);
		produtoService.atualizarValorTotal(entrada.getProduto(), entrada.getValorTotal(),true);
		estoqueService.criarEstoque(entrada);
		return entradaRepository.save(entrada);
	}
	private String findNomeProduto(ProdutoModel produto) {
		return produtoRepository.getById(produto.getId()).getNome();
	}
	private double calcularValorTotal(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}
	
	
}