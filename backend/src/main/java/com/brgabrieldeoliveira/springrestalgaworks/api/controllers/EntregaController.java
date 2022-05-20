package com.brgabrieldeoliveira.springrestalgaworks.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@PostMapping
	public ResponseEntity<Entrega> solicitar(@RequestBody @Valid Entrega entrega) {
		Entrega entregaSolicitada = entregaService.solicitar(entrega);
		return ResponseEntity.status(HttpStatus.CREATED).body(entregaSolicitada);
	}
	
}
