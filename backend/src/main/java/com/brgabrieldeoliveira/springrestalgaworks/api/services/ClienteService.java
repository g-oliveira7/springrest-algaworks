package com.brgabrieldeoliveira.springrestalgaworks.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Cliente;
import com.brgabrieldeoliveira.springrestalgaworks.api.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarTodos() {
		List<Cliente> lista = clienteRepository.findAll();
		return lista;
	}

	public Optional<Cliente> buscarPorId(Long id) {
		if (id == null) {
			return null;
		}
		
		return clienteRepository.findById(id);
	}

	public Optional<Cliente> salvar(Cliente cliente) {
		if (cliente == null) {
			return null;
		}
		
		return Optional.of(clienteRepository.save(cliente));
	}

	public Optional<Cliente> atualizar(Long id, Cliente dadosParaAtualizar) {
		Cliente clienteParaAtualizar = buscarPorId(id).orElse(null); 
		
		if (clienteParaAtualizar != null) {			
			return Optional.of(atualizarCliente(clienteParaAtualizar, dadosParaAtualizar));
		}
		return null;
	}

	private Cliente atualizarCliente(Cliente clienteParaAtualizar, Cliente dadosParaAtualizar) {
		final String nome = dadosParaAtualizar.getNome();
		final String email = dadosParaAtualizar.getEmail();
		final String telefone = dadosParaAtualizar.getTelefone();
		
		if (nome != null) {
			clienteParaAtualizar.setNome(nome);
		}
		if (email != null) {
			clienteParaAtualizar.setEmail(email);
		}
		if (telefone != null) {
			clienteParaAtualizar.setTelefone(telefone);
		}
		return clienteParaAtualizar;
	}

	public void deletarPorId(Long id) {
		clienteRepository.deleteById(id);		
	}
}
