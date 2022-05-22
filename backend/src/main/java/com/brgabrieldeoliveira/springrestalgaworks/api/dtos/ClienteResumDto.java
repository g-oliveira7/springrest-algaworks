package com.brgabrieldeoliveira.springrestalgaworks.api.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResumDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Campo obrigatório")
	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	
}
