package com.brgabrieldeoliveira.springrestalgaworks.api.exceptions.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class StandardValidationError extends StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private @Getter List<ValidationError> erros = new ArrayList<>();

	public StandardValidationError(LocalDateTime dataHora, Integer status, String titulo, String caminho) {
		super(dataHora, status, titulo, caminho);
	}
	
}
