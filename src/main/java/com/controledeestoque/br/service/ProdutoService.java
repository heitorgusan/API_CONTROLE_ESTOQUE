package com.controledeestoque.br.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledeestoque.br.model.ProdutoModel;
import com.controledeestoque.br.repository.ProdutoRepository;

@Service
public class ProdutoService {

	
	@Autowired
	ProdutoRepository produtoRepository;
	public ProdutoModel atualizarProduto(ProdutoModel produto){
		produto.setUltimaAlteracao(LocalDateTime.now());
		
		
		return produtoRepository.save(produto);
	}
	
	public void atualizarQuantidade(ProdutoModel produto, int quantidade,boolean adcionar) {
		ProdutoModel produtoAtualizado = produtoRepository.getById(produto.getId());
		if(adcionar) {
			produtoAtualizado.setQuantidade(produtoAtualizado.getQuantidade() + quantidade);
			
		}else {
			produtoAtualizado.setQuantidade(produtoAtualizado.getQuantidade() - quantidade);
		}
		produtoRepository.save(produtoAtualizado);
		
	}
	
	public void atualizarValorTotal(ProdutoModel produto, double valorTotal, boolean adcionar) {
		ProdutoModel produtoAtualizado = produtoRepository.getById(produto.getId());
		if(adcionar) {
			
			produtoAtualizado.setValorTotal(produtoAtualizado.getValorTotal() + valorTotal);
		}else {
			produtoAtualizado.setValorTotal(produtoAtualizado.getValorTotal()  - valorTotal);
			
		}
		produtoRepository.save(produtoAtualizado);
	}
	
}