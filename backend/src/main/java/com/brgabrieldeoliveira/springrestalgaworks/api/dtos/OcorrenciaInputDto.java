package com.brgabrieldeoliveira.springrestalgaworks.api.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaInputDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descricao;
	
}
