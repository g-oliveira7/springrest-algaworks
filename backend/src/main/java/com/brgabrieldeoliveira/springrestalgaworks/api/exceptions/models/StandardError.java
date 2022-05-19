package com.brgabrieldeoliveira.springrestalgaworks.api.exceptions.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public abstract class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private final LocalDateTime dataHora;
	
	private final Integer status;
	
	private final String titulo;
	
	private final String caminho;
}
