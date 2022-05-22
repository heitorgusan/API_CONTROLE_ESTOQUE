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
			
			if(isSameLoteAndPreco(estoqueItem, entrada.getLoteProduto(), entrada.getPrecoUnitario(),entrada.getProduto().getId()) ){
				estoqueItem.setQuantidadeEstoqueLote(entrada.getQuantidade()+ estoqueItem.getQuantidadeEstoqueLote());
				estoqueItem.setValorTotalLote(estoqueItem.getValorTotalLote() + entrada.getValorTotal());
				estoqueRepository.save(estoqueItem);
				isNovo = false;
				break;
			}
		}
		if(isNovo) {
			criarNovoEstoque(estoque,entrada);
		}
	}
		
	
	private boolean isSameLoteAndPreco(EstoqueModel estoque, String lote, double precoCusto,long idProduto) {
		
		return estoque.getLoteProduto().equals(lote) && precoCusto == estoque.getPrecoCustoUnitario() && idProduto == estoque.getProduto().getId();
	}
	private void criarNovoEstoque(EstoqueModel estoque, EntradaModel entrada){
		estoque.setLoteProduto(entrada.getLoteProduto());
		estoque.setPrecoCustoUnitario(entrada.getPrecoUnitario());
		estoque.setProduto(entrada.getProduto());
		estoque.setQuantidadeEstoqueLote(entrada.getQuantidade());
		estoque.setPrecoCustoUnitario(entrada.getPrecoUnitario());
		estoque.setValorTotalLote(estoque.getValorTotalLote() + entrada.getValorTotal());
		estoqueRepository.save(estoque);
	}
	
	public EstoqueModel buscarEstoque(EntradaModel entrada) {
		String loteProduto = entrada.getLoteProduto();
		double precoPago = entrada.getPrecoUnitario();
		long idProduto = entrada.getProduto().getId();
		
		List<EstoqueModel> estoqueLotes = estoqueRepository.findAllByloteProdutoContainingIgnoreCase(loteProduto);
		
		for(EstoqueModel estoqueItem : estoqueLotes) {
			
			if(isSameLoteAndPreco(estoqueItem, loteProduto, precoPago, idProduto)) {
				return estoqueItem;
			}	
		}
		return null;
			
	}
	
	public void atualizarQuantidade(EstoqueModel estoque, int quantidade, boolean adcionar) {
		EstoqueModel estoqueAtualizado = estoqueRepository.getById(estoque.getId());
		if(adcionar) {
			
			estoqueAtualizado.setQuantidadeEstoqueLote(estoqueAtualizado.getQuantidadeEstoqueLote() + quantidade);
		}else {
			estoqueAtualizado.setQuantidadeEstoqueLote(estoqueAtualizado.getQuantidadeEstoqueLote()  - quantidade);
			
		}
		estoqueRepository.save(estoqueAtualizado);
	}
	
	public void atualizarValorTotal(EstoqueModel estoque, double valorTotal, boolean adcionar) {
		EstoqueModel estoqueAtualizado = estoqueRepository.getById(estoque.getId());
		if(adcionar) {
			
			estoqueAtualizado.setValorTotalLote(estoqueAtualizado.getValorTotalLote() + valorTotal);
		}else {
			estoqueAtualizado.setValorTotalLote(estoqueAtualizado.getValorTotalLote()  - valorTotal);
			
		}
		estoqueRepository.save(estoqueAtualizado);
	}
}
