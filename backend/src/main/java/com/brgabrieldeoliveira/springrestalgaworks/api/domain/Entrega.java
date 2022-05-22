package com.brgabrieldeoliveira.springrestalgaworks.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.enums.StatusEntrega;
import com.brgabrieldeoliveira.springrestalgaworks.api.services.ValidationGroups;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ENTREGAS")
public class Entrega implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Digits(integer = 10, fraction = 2)
	@Column(nullable = false, length = 10)
	@NotNull(message = "É necessário informar a taxa")
	private BigDecimal taxa;

	@Column(nullable = false, length = 30)
	private OffsetDateTime dataPedido;

	@Column(length = 30)
	private OffsetDateTime dataFinalizacao;

	@Embedded
	@Valid
	@NotNull(message = "Campo obrigatório")
	private Destinatario destinatario;
	
	@ManyToOne
	@Valid
	@NotNull(message = "Campo obrigatório")
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
	private Cliente cliente;

	@Column(nullable = false, length = 20)
	private StatusEntrega status;

}
