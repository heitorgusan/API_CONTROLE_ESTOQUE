package com.controledeestoque.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledeestoque.br.model.EstoqueProdutoDetalhadoModel;

public interface EstoqueProdutoDetalhadoRepository extends JpaRepository<EstoqueProdutoDetalhadoModel, Long>{

	public List<EstoqueProdutoDetalhadoModel> findAllByloteProdutoContainingIgnoreCase(String loteProduto);
}
