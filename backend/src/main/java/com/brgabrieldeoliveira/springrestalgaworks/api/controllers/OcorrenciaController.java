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
import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Ocorrencia;
import com.brgabrieldeoliveira.springrestalgaworks.api.dtos.ApiMappers;
import com.brgabrieldeoliveira.springrestalgaworks.api.dtos.OcorrenciaInputDto;
import com.brgabrieldeoliveira.springrestalgaworks.api.dtos.OcorrenciaOutputDto;
import com.brgabrieldeoliveira.springrestalgaworks.api.services.ExisteEntregaIdService;
import com.brgabrieldeoliveira.springrestalgaworks.api.services.OcorrenciaService;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	@Autowired
	private OcorrenciaService ocorrenciaService;

	@Autowired
	private ExisteEntregaIdService entregaIdService;
	
	@Autowired
	private ApiMappers apiMapper;
	
	@GetMapping
	public ResponseEntity<List<OcorrenciaOutputDto>> listarOcorrencias(@PathVariable Long entregaId) {
		Entrega entrega = entregaIdService.entregaId(entregaId);
		List<OcorrenciaOutputDto> ocorrencias = apiMapper.toOutputOcorrenciaList(entrega.getOcorrencias());
		return ResponseEntity.ok(ocorrencias);
	}
	
	@PostMapping
	public ResponseEntity<OcorrenciaOutputDto> registrarOcorrencia(
			@PathVariable Long entregaId, 
			@RequestBody @Valid OcorrenciaInputDto ocorrenciaInputDto) {
		
		Ocorrencia ocorrencia = ocorrenciaService.registrar(entregaId, ocorrenciaInputDto.getDescricao());
		OcorrenciaOutputDto ocorrenciaOutputDto = apiMapper.toOutputDto(ocorrencia);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ocorrenciaOutputDto);
	}
	
}
