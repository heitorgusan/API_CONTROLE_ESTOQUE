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
	ProdutoService produtoService;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EstoqueProdutoDetalhadoService estoqueProdutoDetalhadoService;
	public EntradaModel cadastrarEntradaProduto(EntradaModel entrada) {
		
		ProdutoModel produto = produtoRepository.getById(entrada.getProduto().getId());
		
		//Atualizar Produto
		produtoService.atualizarProdutoComEntrada(produto, entrada);
		
		//Criar Tabela Estoque
		estoqueProdutoDetalhadoService.criarTabelaEstoque(entrada);
		
		//AtualizarEntrada
		addNomeMaisTotalEntrada(produto.getNome(), entrada);
		
		return entradaRepository.save(entrada);
	}
	
	
	private void addNomeMaisTotalEntrada(String nomeProduto, EntradaModel entrada) {
		entrada.setNomeProduto(nomeProduto);
		entrada.setTotal(entrada.getQuantidade() * entrada.getPrecoUnitario());
	}
	
	
}