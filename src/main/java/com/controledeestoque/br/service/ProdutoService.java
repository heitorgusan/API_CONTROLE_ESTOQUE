package com.controledeestoque.br.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledeestoque.br.model.EntradaModel;
import com.controledeestoque.br.model.ProdutoModel;
import com.controledeestoque.br.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	public ProdutoModel atualizarProduto(ProdutoModel produto){
		ProdutoModel produtoAtual = produtoRepository.getById(produto.getId());
		
		if(!produto.getNome().isEmpty()) {
			
			produtoAtual.setNome(produto.getNome());
		}
		if(produto.getQuantidadeMinima()>= 0) {
			produtoAtual.setQuantidadeMinima(produto.getQuantidadeMinima());
		}
		
		if(produto.getQuantidadeMaxima()>0) {
			produtoAtual.setQuantidadeMaxima(produto.getQuantidadeMaxima());
		}
		produtoAtual.setUltimaAlteracao(LocalDateTime.now());
		return produtoRepository.save(produtoAtual);
	}
	
	public void addEstoqueProduto(ProdutoModel produto, int quantidade ){
		produto.setQuantidadeAtual(produto.getQuantidadeAtual()+quantidade);
		produtoRepository.save(produto);
	}
	
	public void somarTotalProduto(ProdutoModel produto, double valorTotal) {
		produto.setValorTotalEstoque(produto.getValorTotalEstoque()+ valorTotal);
	}
	
	public void atualizarProdutoComEntrada(ProdutoModel produto, EntradaModel entrada) {
		addEstoqueProduto(produto, entrada.getQuantidade());
		somarTotalProduto(produto, entrada.getTotal());
	}
}