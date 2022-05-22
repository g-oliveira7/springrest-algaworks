package com.brgabrieldeoliveira.springrestalgaworks.api.dtos;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Cliente;
import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Entrega;
import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Ocorrencia;

@Component
public class ApiMappers {


	@Autowired
	private ModelMapper modelMapper;
	
	public EntregaOutputDto toOutputDto(Entrega entrega) {
		return modelMapper.map(entrega, EntregaOutputDto.class);
	}

	public OcorrenciaOutputDto toOutputDto(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaOutputDto.class);
	}
	
	public List<EntregaOutputDto> toOutputEntregaList(List<Entrega> entregas) {
		return entregas.stream()
				.map(x -> toOutputDto(x))
				.toList();
	}

	public List<OcorrenciaOutputDto> toOutputOcorrenciaList(List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream()
				.map(x -> toOutputDto(x))
				.toList();
	}

	public Entrega toEntity(EntregaInputDto entregaInputDto) {
		return modelMapper.map(entregaInputDto, Entrega.class);
	}

	public Cliente toEntity(ClienteInputDto clienteInputDto) {
		return modelMapper.map(clienteInputDto, Cliente.class);
	}

	
}
