package com.brgabrieldeoliveira.springrestalgaworks.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
