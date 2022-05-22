package com.brgabrieldeoliveira.springrestalgaworks.api.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class ClienteInputDto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@NotEmpty(message = "Campo obrigatório")
	@Length(max = 60, message = "Quantidade de caracteres deve ser igual ou inferior a 60")
	private String nome;
	
	@NotEmpty(message = "Campo obrigatório")
	@Length(max = 150, message = "Quantidade de caracteres deve ser igual ou inferior a 150")
	@Email(message = "E-mail inválido")
	private String email;
	
	@NotEmpty(message = "Campo obrigatório")
	@Length(max = 20, message = "Quantidade de caracteres deve ser igual ou inferior a 20")
	private String telefone;
}
