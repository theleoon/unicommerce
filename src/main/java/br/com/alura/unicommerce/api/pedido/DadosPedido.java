package br.com.alura.unicommerce.api.pedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.unicommerce.api.cliente.DadosCliente;
import br.com.alura.unicommerce.core.entity.Pedido;
import br.com.alura.unicommerce.core.entity.TipoDescontoPedido;

public record DadosPedido(Long id, 
		LocalDate data, 
		BigDecimal total, 
		BigDecimal desconto, 
		TipoDescontoPedido tipoDesconto,
		DadosCliente cliente,
		List<DadosItemDePedido> itens) {

	public DadosPedido(Pedido pedido) {
		this(pedido.getId(), 
				pedido.getData(),
				pedido.getTotalLiquido(),
				pedido.getDesconto(), 
				pedido.getTipoDesconto(),
				new DadosCliente(pedido.getCliente()),
				pedido.getItemPedidos()
							.stream().map(DadosItemDePedido::new)
							.collect(Collectors.toList()));
	}

}
