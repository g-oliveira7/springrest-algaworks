package com.brgabrieldeoliveira.springrestalgaworks.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntregaInputDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "É necessário informar a taxa")
	private BigDecimal taxa;
	
	@NotNull(message = "Campo obrigatório")
	private Long clienteId;
	
	@Valid
	@NotNull(message = "Campo obrigatório")
	private DestinatarioDto destinatario;

}
