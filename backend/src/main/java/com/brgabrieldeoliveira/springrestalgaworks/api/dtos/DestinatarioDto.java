package com.brgabrieldeoliveira.springrestalgaworks.api.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Campo obrigatório")
	private String nome;
	
	@NotBlank(message = "Campo obrigatório")
	private String logradouro;
	
	@NotBlank(message = "Campo obrigatório")
	private String numero;
	
	private String complemento;
	
	@NotBlank(message = "Campo obrigatório")
	private String bairro;
	
}
