package com.brgabrieldeoliveira.springrestalgaworks.api.dtos;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Cliente;
import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Entrega;

@Component
public class ApiMappers {


	@Autowired
	private ModelMapper modelMapper;
	
	public EntregaOutputDto toOutputDto(Entrega entrega) {
		return modelMapper.map(entrega, EntregaOutputDto.class);
	}
	
	public List<EntregaOutputDto> toOutputDtoList(List<Entrega> entregas) {
		return entregas.stream()
				.map(x -> modelMapper.map(x, EntregaOutputDto.class))
				.collect(Collectors.toList());
	}

	public Entrega toEntity(EntregaInputDto entregaInputDto) {
		return modelMapper.map(entregaInputDto, Entrega.class);
	}

	public Cliente toEntity(ClienteInputDto clienteInputDto) {
		return modelMapper.map(clienteInputDto, Cliente.class);
	}
	
}
