package br.com.alura.unicommerce.api.cliente.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.api.cliente.exception.ClienteException;
import br.com.alura.unicommerce.core.dao.ClienteDao;
import br.com.alura.unicommerce.core.entity.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	public void cadastra(Cliente obj) {
		if (obj == null)
			throw new ClienteException("Cadastro inválido para objeto nulo");
		clienteDao.save(obj);
	}

	public void atualiza(Cliente obj) {
		if (obj == null)
			throw new ClienteException("Atualização inválida para objeto nulo");
		clienteDao.update(obj);
	}

	public Optional<Cliente> buscaPorId(Long idCliente) {
		return Optional.ofNullable(clienteDao.get(idCliente));
	}

}
