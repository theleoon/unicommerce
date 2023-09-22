package br.com.alura.unicommerce.api.pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import br.com.alura.unicommerce.api.cliente.service.ClienteService;
import br.com.alura.unicommerce.api.produto.service.ProdutoService;
import br.com.alura.unicommerce.core.entity.Cliente;
import br.com.alura.unicommerce.core.entity.ItemDePedido;
import br.com.alura.unicommerce.core.entity.Pedido;
import br.com.alura.unicommerce.core.entity.TipoDescontoPedido;

public record DadosDePedido(@NotNull Long clienteId, 
		String tipoDesconto, 
		BigDecimal desconto,
		@NotNull BigDecimal totalPedido,
		@NotNull List<DadosDeProduto> produtos) {

	public Pedido converter(ClienteService clienteService, ProdutoService produtoService) {
		
		Optional<Cliente> cliente = clienteService.buscaPorId(clienteId);
		List<ItemDePedido> itens = produtos.stream().map(produto -> produto.converter(produtoService)).toList();
		
		if (cliente.isPresent()) 
			return new Pedido(cliente.get(), desconto, 
					TipoDescontoPedido.valueOf(tipoDesconto), itens);
		
		return null;
	}
	
	

}
