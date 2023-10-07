package br.com.alura.unicommerce.api.pedido;

import java.math.BigDecimal;

import br.com.alura.unicommerce.api.produto.DadosProduto;
import br.com.alura.unicommerce.core.entity.ItemDePedido;
import br.com.alura.unicommerce.core.entity.TipoDescontoItemPedido;

public record DadosItemDePedido(Long id, 
		Long quantidade, 
		BigDecimal precoUnitario, 
		BigDecimal desconto,
		TipoDescontoItemPedido tipoDesconto, 
		DadosProduto produto) {

	public DadosItemDePedido(ItemDePedido item) {
		this(item.getId(), 
				item.getQuantidade(), 
				item.getPrecoUnitario(), 
				item.getDesconto(), 
				item.getTipoDesconto(),
				new DadosProduto(item.getProduto()));
	}

}
