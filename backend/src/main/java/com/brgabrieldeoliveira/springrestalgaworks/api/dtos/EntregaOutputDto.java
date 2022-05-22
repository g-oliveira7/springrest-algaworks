package com.brgabrieldeoliveira.springrestalgaworks.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.enums.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaOutputDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private BigDecimal taxa;
	
	private OffsetDateTime dataPedido;
	
	private OffsetDateTime dataFinalizacao;
	
	private ClienteResumDto cliente;
	
	private StatusEntrega status;

	private DestinatarioDto destinatario;

}
