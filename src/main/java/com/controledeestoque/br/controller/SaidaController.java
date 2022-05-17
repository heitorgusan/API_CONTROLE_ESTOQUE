package com.controledeestoque.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controledeestoque.br.model.SaidaModel;
import com.controledeestoque.br.service.SaidaService;

@RestController
@RequestMapping("/saida")
@CrossOrigin("*")
public class SaidaController {

	@Autowired
	SaidaService saidaService;
	
	@PostMapping
	public ResponseEntity<SaidaModel> post(@RequestBody SaidaModel saida){
		return ResponseEntity.status(HttpStatus.CREATED).body(saidaService.criarSaida(saida));
	}
}
