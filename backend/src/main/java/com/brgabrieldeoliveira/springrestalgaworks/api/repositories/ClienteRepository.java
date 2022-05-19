package com.brgabrieldeoliveira.springrestalgaworks.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
