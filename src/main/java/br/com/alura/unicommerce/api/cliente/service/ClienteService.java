package br.com.alura.unicommerce.api.cliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.api.cliente.exception.ClienteException;
import br.com.alura.unicommerce.core.entity.Cliente;
import br.com.alura.unicommerce.core.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public void cadastra(Cliente obj) {
		if (obj == null)
			throw new ClienteException("Cadastro inválido para objeto nulo");
		repository.save(obj);
	}

	public void atualiza(Cliente obj) {
		if (obj == null)
			throw new ClienteException("Atualização inválida para objeto nulo");
		repository.save(obj);
	}

	public Optional<Cliente> buscaPorId(Long idCliente) {
		return repository.findById(idCliente);
	}

	public Optional<List<Cliente>> listaTodas() {
		return Optional.ofNullable(repository.findAll());
	}

}
