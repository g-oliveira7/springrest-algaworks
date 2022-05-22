package com.brgabrieldeoliveira.springrestalgaworks.api.exceptions;

public class EntidadeNaoEncontradaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String message) {
		super(message);
	}
	
}
