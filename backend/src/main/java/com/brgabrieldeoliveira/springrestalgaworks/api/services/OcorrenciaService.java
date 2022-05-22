package com.brgabrieldeoliveira.springrestalgaworks.api.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Entrega;
import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Ocorrencia;

@Service
public class OcorrenciaService {

	@Autowired
	private ExisteEntregaIdService entregaIdService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = entregaIdService.entregaId(entregaId);
		
		return entrega.addOcorrencia(descricao);
	}
}
