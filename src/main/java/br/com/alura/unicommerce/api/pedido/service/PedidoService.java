package br.com.alura.unicommerce.api.pedido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
