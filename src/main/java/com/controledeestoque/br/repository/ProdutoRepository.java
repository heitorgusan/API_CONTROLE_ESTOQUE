package com.controledeestoque.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledeestoque.br.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
}
