package com.controledeestoque.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.controledeestoque.br.model.EntradaModel;
import com.controledeestoque.br.repository.EntradaRepository;
import com.controledeestoque.br.repository.ProdutoRepository;
import com.controledeestoque.br.service.EntradaService;

@RestController
@RequestMapping("/entrada")
@CrossOrigin("*")
public class EntradaController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EntradaService entradaService;
	
	@Autowired
	EntradaRepository entradaRepository;
	
	@GetMapping
	public ResponseEntity<List<EntradaModel>>get(){
		
		return ResponseEntity.ok(entradaRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<EntradaModel> post(@RequestBody EntradaModel entrada){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entradaService.cadastrarEntrada(entrada));
	}
	
	/*
	 * Criar um método de service com atualizarEntradaProduto
	@PutMapping()
	public ResponseEntity<EntradaModel>put(@RequestBody EntradaModel entrada){
		return ResponseEntity.status(HttpStatus.OK).body(entradaService.atualizarEntradaProduto(entrada));
	}
	*/
}