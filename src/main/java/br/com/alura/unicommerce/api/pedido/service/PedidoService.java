package br.com.alura.unicommerce.api.pedido.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.core.entity.Cliente;
import br.com.alura.unicommerce.core.entity.Pedido;
import br.com.alura.unicommerce.core.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public void cadastra(Pedido pedido) {
		aplicarPoliticaDeDesconto(pedido);
		repository.save(pedido);
	}

	private void aplicarPoliticaDeDesconto(Pedido pedido) {
		Integer quantidadeDePedidos = 0;
		pedido.aplicaPoliticaDeDesconto(quantidadeDePedidos);
	}

	public Optional<Pedido> buscaPorId(Long id) {
		return repository.findById(id);
	}

	public Optional<List<Pedido>> listaTodas() {
		return Optional.ofNullable(repository.findAll());
	}

}
