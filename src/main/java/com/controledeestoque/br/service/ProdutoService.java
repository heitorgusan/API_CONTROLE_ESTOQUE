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
	
	
	
}