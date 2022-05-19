package com.brgabrieldeoliveira.springrestalgaworks.api.exceptions.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardSimpleError extends StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private final String mensagem;

	public StandardSimpleError(LocalDateTime dataHora, Integer status, String titulo, String caminho, String mensagem) {
		super(dataHora, status, titulo, caminho);
		this.mensagem = mensagem;
	}
	
}
