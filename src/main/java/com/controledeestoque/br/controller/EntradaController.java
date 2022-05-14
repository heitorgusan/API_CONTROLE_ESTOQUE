package com.controledeestoque.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.controledeestoque.br.model.EntradaModel;
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
	
	@PostMapping
	public ResponseEntity<EntradaModel> post(@RequestBody EntradaModel entrada){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entradaService.cadastrarEntradaProduto(entrada));
	}
}