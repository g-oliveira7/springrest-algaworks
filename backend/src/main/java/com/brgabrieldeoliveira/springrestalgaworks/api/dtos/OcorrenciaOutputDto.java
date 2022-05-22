package com.brgabrieldeoliveira.springrestalgaworks.api.dtos;

import java.io.Serializable;
import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OcorrenciaOutputDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String descricao;

	private OffsetDateTime dataRegistro;
	
}
