package com.brgabrieldeoliveira.springrestalgaworks.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Entrega;
import com.brgabrieldeoliveira.springrestalgaworks.api.exceptions.EntidadeNaoEncontradaException;

@Service
public class ExisteEntregaIdService {

	@Autowired
	private EntregaService entregaService;
	
	public Entrega entregaId(Long id) {
		return entregaService.buscarPorId(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
}
