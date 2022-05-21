package com.brgabrieldeoliveira.springrestalgaworks.api.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Cliente;
import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Entrega;
import com.brgabrieldeoliveira.springrestalgaworks.api.domain.enums.StatusEntrega;
import com.brgabrieldeoliveira.springrestalgaworks.api.exceptions.DomainException;
import com.brgabrieldeoliveira.springrestalgaworks.api.repositories.EntregaRepository;

@Service
public class EntregaService {

	@Autowired
	private EntregaRepository entregaRepository;

	@Autowired
	private ClienteService clienteService;

	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = clienteService.buscarPorId(entrega.getCliente().getId())
				.orElseThrow(() -> new DomainException("Cliente não encontrado"));
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		
		return entregaRepository.save(entrega);
	}
	
	public Optional<Entrega> buscarPorId(Long id) {
		return entregaRepository.findById(id);
	}
	
	public List<Entrega> listarTodos() {
		return entregaRepository.findAll();
	}
}
