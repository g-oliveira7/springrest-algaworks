package com.brgabrieldeoliveira.springrestalgaworks.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENTES")
public class Cliente {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 60, nullable = false)
	@NotEmpty(message = "Campo obrigatório")
	@Length(max = 60, message = "Quantidade de caracteres deve ser igual ou inferior a 60")
	private String nome;
	
	@Column(length = 150, nullable = false)
	@NotEmpty(message = "Campo obrigatório")
	@Length(max = 150, message = "Quantidade de caracteres deve ser igual ou inferior a 150")
	@Email(message = "E-mail inválido")
	private String email;
	
	@Column(length = 20, nullable = false)
	@NotEmpty(message = "Campo obrigatório")
	@Length(max = 20, message = "Quantidade de caracteres deve ser igual ou inferior a 20")
	private String telefone;
}
