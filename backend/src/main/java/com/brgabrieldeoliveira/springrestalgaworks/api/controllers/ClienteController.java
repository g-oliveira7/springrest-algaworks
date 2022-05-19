package com.brgabrieldeoliveira.springrestalgaworks.api.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@GetMapping
	public List<Cliente> listarTodos() {
		Cliente c1 = new Cliente(1L, "Bob", "bob@gmail.com", "98888-7777");
		Cliente c2 = new Cliente(2L, "Leah", "leah@gmail.com", "99999-1111");
		return Arrays.asList(c1, c2);
	}
}
