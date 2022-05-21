package com.brgabrieldeoliveira.springrestalgaworks.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Entrega;
import com.brgabrieldeoliveira.springrestalgaworks.api.services.EntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	@Autowired
	private EntregaService entregaService;

	@GetMapping
	public ResponseEntity<List<Entrega>> listarTodos() { 
		List<Entrega> lista = entregaService.listarTodos();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	public ResponseEntity<Entrega> solicitar(@RequestBody @Valid Entrega entrega) {
		Entrega entregaSolicitada = entregaService.solicitar(entrega);
		return ResponseEntity.status(HttpStatus.CREATED).body(entregaSolicitada);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Entrega> buscarPorId(@PathVariable Long id) {
		return entregaService.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
}
