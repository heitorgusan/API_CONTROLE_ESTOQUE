package com.controledeestoque.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledeestoque.br.model.EstoqueModel;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, Long>{

	public List<EstoqueModel> findAllByloteProdutoContainingIgnoreCase(String loteProduto);
}
