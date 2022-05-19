package com.brgabrieldeoliveira.springrestalgaworks.api.exceptions.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationError implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nomeCampo;
	
	private String mensagem;
}
