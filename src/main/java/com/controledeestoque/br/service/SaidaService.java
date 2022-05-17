package com.controledeestoque.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledeestoque.br.model.SaidaModel;
import com.controledeestoque.br.repository.SaidaRepository;

@Service
public class SaidaService {
	
	@Autowired
	SaidaRepository saidaRepository;
	public SaidaModel criarSaida(SaidaModel saida) {
		
		return saidaRepository.save(saida);
	}
}
