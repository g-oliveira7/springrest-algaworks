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
import com.brgabrieldeoliveira.springrestalgaworks.api.dtos.ApiMappers;
import com.brgabrieldeoliveira.springrestalgaworks.api.dtos.EntregaInputDto;
import com.brgabrieldeoliveira.springrestalgaworks.api.dtos.EntregaOutputDto;
import com.brgabrieldeoliveira.springrestalgaworks.api.services.EntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	@Autowired
	private EntregaService entregaService;
	
	@Autowired
	private ApiMappers apiMapper;

	@GetMapping
	public ResponseEntity<List<EntregaOutputDto>> listarTodos() { 
		List<Entrega> lista = entregaService.listarTodos();
		return ResponseEntity.ok(apiMapper.toOutputEntregaList(lista));
	}
	
	@PostMapping
	public ResponseEntity<EntregaOutputDto> solicitar(@RequestBody @Valid EntregaInputDto entregaInputDto) {
		Entrega entrega = apiMapper.toEntity(entregaInputDto);
		entrega  = entregaService.solicitar(entrega);
		EntregaOutputDto entregaSolicitada = apiMapper.toOutputDto(entrega);
		return ResponseEntity.status(HttpStatus.CREATED).body(entregaSolicitada);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntregaOutputDto> buscarPorId(@PathVariable Long id) {
		return entregaService.buscarPorId(id)
				.map(e -> ResponseEntity.ok(apiMapper.toOutputDto(e)))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
