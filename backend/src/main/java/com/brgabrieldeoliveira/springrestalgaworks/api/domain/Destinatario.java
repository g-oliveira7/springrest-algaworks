package com.brgabrieldeoliveira.springrestalgaworks.api.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Destinatario {

	@Column(nullable = false, length = 60, name = "destinatario_nome")
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	
	@Column(nullable = false, length = 100, name = "destinatario_logradouro")
	@NotBlank(message = "Campo obrigatório")
	private String logradouro;
	
	@Column(nullable = false, length = 20, name = "destinatario_numero")
	@NotBlank(message = "Campo obrigatório")
	private String numero;
	
	@Column(length = 60, name = "destinatario_complemento")
	private String complemento;
	
	@Column(nullable = false, length = 30, name = "destinatario_bairro")
	@NotBlank(message = "Campo obrigatório")
	private String bairro;
	
}
