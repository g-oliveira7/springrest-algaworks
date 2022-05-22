package com.brgabrieldeoliveira.springrestalgaworks.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Cliente;
import com.brgabrieldeoliveira.springrestalgaworks.api.dtos.ApiMappers;
import com.brgabrieldeoliveira.springrestalgaworks.api.dtos.ClienteInputDto;
import com.brgabrieldeoliveira.springrestalgaworks.api.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ApiMappers apiMapper;

	@GetMapping
	public List<Cliente> listarTodos() {
		return clienteService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		return clienteService.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Cliente> salvar(@RequestBody @Valid ClienteInputDto clienteInputDto) {
		Cliente novoCliente = apiMapper.toEntity(clienteInputDto);
		
		return clienteService.salvar(novoCliente)
				.map(c -> ResponseEntity.status(HttpStatus.CREATED).body(c))
				.orElse(ResponseEntity.badRequest().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteInputDto dadosParaAtualizar) {
		Cliente clienteDados = apiMapper.toEntity(dadosParaAtualizar);
		
		return clienteService.atualizar(id, clienteDados)
				.map(c -> ResponseEntity.ok(c))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletar(@PathVariable Long id) {
		return clienteService.buscarPorId(id).map(c -> {
			clienteService.deletarPorId(c.getId());
			return ResponseEntity.noContent().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
