package com.controledeestoque.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledeestoque.br.model.EstoqueModel;
import com.controledeestoque.br.model.SaidaModel;
import com.controledeestoque.br.repository.EntradaRepository;
import com.controledeestoque.br.repository.EstoqueRepository;
import com.controledeestoque.br.repository.ProdutoRepository;
import com.controledeestoque.br.repository.SaidaRepository;

@Service
public class SaidaService {

	@Autowired
	EntradaService entradaService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	SaidaRepository saidaRepository;
	
	@Autowired
	EntradaRepository entradaRepository;
	@Autowired
	EstoqueService estoqueService;

	@Autowired
	EstoqueRepository estoqueRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public SaidaModel criarSaida(SaidaModel saida) {
		EstoqueModel estoque = estoqueRepository.getById(saida.getEstoque().getId());
		saida.setValorTotal(calcValorTotalSaida(saida.getQuantidade(),estoque));
		produtoService.atualizarQuantidade(estoque.getProduto(),saida.getQuantidade(),false);
		produtoService.atualizarValorTotal(estoque.getProduto(), saida.getValorTotal(), false);
		estoqueService.atualizarQuantidade(estoque, saida.getQuantidade(), false);
		estoqueService.atualizarValorTotal(estoque, saida.getValorTotal(), false);
		return saidaRepository.save(saida);
	}
	
	
	private double calcValorTotalSaida(int quantidade, EstoqueModel estoque) {
		return quantidade * estoque.getPrecoCustoUnitario();
	}
}