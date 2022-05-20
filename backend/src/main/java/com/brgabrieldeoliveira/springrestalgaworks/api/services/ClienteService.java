package com.brgabrieldeoliveira.springrestalgaworks.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brgabrieldeoliveira.springrestalgaworks.api.domain.Cliente;
import com.brgabrieldeoliveira.springrestalgaworks.api.repositories.ClienteRepository;
import com.brgabrieldeoliveira.springrestalgaworks.api.services.exceptions.DomainException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional(readOnly = true)
	public List<Cliente> listarTodos() {
		List<Cliente> lista = clienteRepository.findAll();
		return lista;
	}

	@Transactional(readOnly = true)
	public Optional<Cliente> buscarPorId(Long id) {
		return clienteRepository.findById(id);
	}
	
	@Transactional
	public Optional<Cliente> salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(algumClienteRetornado -> !algumClienteRetornado.equals(cliente));
		
		if (emailEmUso) {
			throw new DomainException("Já existe um cadastro com esse e-mail");
		}
		
		return Optional.of(clienteRepository.save(cliente));
	}

	@Transactional
	public Optional<Cliente> atualizar(Long id, Cliente dadosParaAtualizar) {
		Cliente clienteParaAtualizar = buscarPorId(id).orElse(null); 
		
		if (clienteParaAtualizar != null) {			
			return Optional.of(atualizarCliente(clienteParaAtualizar, dadosParaAtualizar));
		}
		return null;
	}

	@Transactional	
	public void deletarPorId(Long id) {
		clienteRepository.deleteById(id);		
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
	
}
