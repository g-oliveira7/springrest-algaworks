package com.brgabrieldeoliveira.springrestalgaworks.api.domain;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.enums.StatusEntrega;

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
public class Entrega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Digits(integer = 10, fraction = 2)
	@Column(nullable = false, length = 10)
	private BigDecimal taxa;

	@Column(nullable = false, length = 30)
	private OffsetDateTime dataPedido;

	@Column(length = 30)
	private OffsetDateTime dataFinalizacao;

	
	@Column(nullable = false, length = 20)
	private StatusEntrega status;
	
	@Embedded
	private Destinatario destinatario;

	@ManyToOne
	private Cliente cliente;

	@OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Ocorrencia> ocorrencias = new ArrayList<>();

	public Ocorrencia addOcorrencia(String descricao) {
		Ocorrencia ocorrencia = new Ocorrencia(null, descricao, OffsetDateTime.now(), this);
		ocorrencias.add(ocorrencia);
		return ocorrencia;
	}
}
