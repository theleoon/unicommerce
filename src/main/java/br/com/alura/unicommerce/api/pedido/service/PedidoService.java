package br.com.alura.unicommerce.api.pedido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.core.dao.PedidoDao;
import br.com.alura.unicommerce.core.entity.Pedido;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoDao pedidoDao;
	
	public void cadastra(Pedido pedido) {
		aplicarPoliticaDeDesconto(pedido);
		pedidoDao.save(pedido);
	}

	private void aplicarPoliticaDeDesconto(Pedido pedido) {
		Integer quantidadeDePedidos = pedidoDao.listaTodos().size();
		pedido.aplicaPoliticaDeDesconto(quantidadeDePedidos);
	}

}
