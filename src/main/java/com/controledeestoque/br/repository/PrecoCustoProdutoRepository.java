package com.controledeestoque.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledeestoque.br.model.PrecoCustoProdutoModel;

public interface PrecoCustoProdutoRepository extends JpaRepository<PrecoCustoProdutoModel,Long> {

}
