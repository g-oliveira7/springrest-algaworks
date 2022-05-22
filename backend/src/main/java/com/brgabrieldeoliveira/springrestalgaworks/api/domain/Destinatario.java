package com.brgabrieldeoliveira.springrestalgaworks.api.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
	private String nome;
	
	@Column(nullable = false, length = 100, name = "destinatario_logradouro")
	private String logradouro;
	
	@Column(nullable = false, length = 20, name = "destinatario_numero")
	private String numero;
	
	@Column(length = 60, name = "destinatario_complemento")
	private String complemento;
	
	@Column(nullable = false, length = 30, name = "destinatario_bairro")
	private String bairro;
	
}
