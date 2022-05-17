package com.controledeestoque.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledeestoque.br.model.SaidaModel;

public interface SaidaRepository extends JpaRepository<SaidaModel,Long> {
	
}
