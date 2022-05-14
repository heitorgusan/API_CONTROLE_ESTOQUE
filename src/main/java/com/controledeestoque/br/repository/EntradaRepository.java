package com.controledeestoque.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.controledeestoque.br.model.EntradaModel;

public interface EntradaRepository extends JpaRepository<EntradaModel,Long> {

}
