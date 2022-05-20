package com.controledeestoque.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledeestoque.br.model.EntradaModel;
import com.controledeestoque.br.model.SaidaModel;
import com.controledeestoque.br.repository.EntradaRepository;
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
	

	public SaidaModel criarSaida(SaidaModel saida) {
		
		EntradaModel entrada = entradaRepository.getById(saida.getEntrada().getId());
		
		saida.setValorTotal(calcValorTotalSaida(saida.getQuantidade(),entrada));
		
		produtoService.atualizarQuantidade(entrada.getProduto(), saida.getQuantidade(), false);
		produtoService.atualizarValorTotal(entrada.getProduto(), saida.getValorTotal(), false);
		
		return saidaRepository.save(saida);
	}

	private double calcValorTotalSaida(int quantidade, EntradaModel entrada) {
		return quantidade * entrada.getPrecoUnitario();
	}
}
