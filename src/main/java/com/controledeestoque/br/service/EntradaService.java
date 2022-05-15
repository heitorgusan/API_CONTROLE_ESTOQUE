package com.controledeestoque.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.controledeestoque.br.model.EntradaModel;
import com.controledeestoque.br.model.ProdutoModel;
import com.controledeestoque.br.repository.EntradaRepository;
import com.controledeestoque.br.repository.EstoqueProdutoDetalhadoRepository;
import com.controledeestoque.br.repository.ProdutoRepository;

@Service
public class EntradaService {

	@Autowired
	EntradaRepository entradaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EstoqueProdutoDetalhadoService estoqueProdutoDetalhadoService;
	public EntradaModel cadastrarEntradaProduto(EntradaModel entrada) {
		ProdutoModel produto = produtoRepository.getById(entrada.getProduto().getId());
		entrada.setNomeProduto(produto.getNome());
		entrada.setTotal(entrada.getQuantidade() * entrada.getPrecoUnitario());
		addEstoqueProduto(produto, entrada.getQuantidade());
		estoqueProdutoDetalhadoService.criarTabelaEstoque(entrada);
		return entradaRepository.save(entrada);
	}
	
	private void addEstoqueProduto(ProdutoModel produto, int quantidade ){
		produto.setQuantidadeAtual(produto.getQuantidadeAtual()+quantidade);
		produtoRepository.save(produto);
	}
	
}