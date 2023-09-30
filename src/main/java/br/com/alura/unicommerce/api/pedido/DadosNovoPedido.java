package br.com.alura.unicommerce.api.pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import br.com.alura.unicommerce.api.cliente.service.ClienteService;
import br.com.alura.unicommerce.api.produto.service.ProdutoService;
import br.com.alura.unicommerce.core.entity.Cliente;
import br.com.alura.unicommerce.core.entity.ItemDePedido;
import br.com.alura.unicommerce.core.entity.Pedido;
import jakarta.validation.constraints.NotNull;

public record DadosNovoPedido(@NotNull Long clienteId, 
		@NotNull BigDecimal totalPedido,
		@NotNull List<DadosDeProduto> produtos) {

	public Optional<Pedido> converter(ClienteService clienteService, ProdutoService produtoService) {
		
		Optional<Cliente> cliente = clienteService.buscaPorId(clienteId);
		List<ItemDePedido> itens = produtos.stream().map(produto -> produto.converter(produtoService)).toList();
		
		if (cliente.isPresent()) 
			return Optional.ofNullable(new Pedido(cliente.get(), itens));
		
		return Optional.empty();
	}
	
}
