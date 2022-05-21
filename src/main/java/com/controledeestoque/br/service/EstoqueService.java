package com.controledeestoque.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledeestoque.br.model.EntradaModel;
import com.controledeestoque.br.model.EstoqueModel;
import com.controledeestoque.br.repository.EstoqueRepository;

@Service
public class EstoqueService {
	
	@Autowired
	EstoqueRepository estoqueRepository;
	public void criarEstoque(EntradaModel entrada) {
		EstoqueModel estoque = new EstoqueModel();
		List<EstoqueModel>buscaLote = estoqueRepository.findAllByloteProdutoContainingIgnoreCase(entrada.getLoteProduto());
		boolean isNovo = true;
		for(EstoqueModel estoqueItem : buscaLote) {
			
			if(isSameLoteAndPreco(estoqueItem, entrada.getLoteProduto(), entrada.getPrecoUnitario()) ){
				estoqueItem.setQuantidadeEstoqueLote(entrada.getQuantidade()+ estoqueItem.getQuantidadeEstoqueLote());
				estoqueItem.setValorTotalLote(estoqueItem.getValorTotalLote() + entrada.getValorTotal());
				estoqueRepository.save(estoqueItem);
				isNovo = false;
				break;
			}
		}
		if(isNovo) {
			estoque.setLoteProduto(entrada.getLoteProduto());
			estoque.setPrecoCustoUnitario(entrada.getPrecoUnitario());
			estoque.setProduto(entrada.getProduto());
			estoque.setQuantidadeEstoqueLote(entrada.getQuantidade());
			estoque.setPrecoCustoUnitario(entrada.getPrecoUnitario());
			estoqueRepository.save(estoque);
			System.out.println("ooi");
		}
	}
		
	
	private boolean isSameLoteAndPreco(EstoqueModel estoque, String lote, double precoCusto) {
		
		return estoque.getLoteProduto().equals(lote)&& precoCusto == estoque.getPrecoCustoUnitario();
	}
	
}
