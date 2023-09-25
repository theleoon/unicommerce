package br.com.alura.unicommerce.api.pedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.alura.unicommerce.core.entity.Cliente;
import br.com.alura.unicommerce.core.entity.ItemDePedido;
import br.com.alura.unicommerce.core.entity.Pedido;
import br.com.alura.unicommerce.core.entity.TipoDescontoPedido;

public record DadosPedido(Long id, LocalDate data, Cliente cliente, BigDecimal desconto, TipoDescontoPedido tipoDesconto,
		List<ItemDePedido> itemPedidos) {

	public DadosPedido(Pedido pedido) {
		this(pedido.getId(), 
				pedido.getData(), 
				pedido.getCliente(), 
				pedido.getDesconto(), 
				pedido.getTipoDesconto(), 
				pedido.getItemPedidos());
	}

}
