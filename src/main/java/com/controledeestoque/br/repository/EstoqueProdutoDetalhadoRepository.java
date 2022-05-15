package com.controledeestoque.br.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledeestoque.br.model.EstoqueProdutoDetalhadoModel;

public interface EstoqueProdutoDetalhadoRepository extends JpaRepository<EstoqueProdutoDetalhadoModel, Long>{

	public Optional<EstoqueProdutoDetalhadoModel>findByLoteProduto(String loteProduto);
}
