package br.com.alura.unicommerce.api.pedido;

import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.alura.unicommerce.api.produto.service.ProdutoService;
import br.com.alura.unicommerce.core.entity.ItemDePedido;
import br.com.alura.unicommerce.core.entity.Produto;

public record DadosDeProduto(@NotNull Long id, @Positive Long quantidade) {

	public ItemDePedido converter(ProdutoService produtoService) {

		Optional<Produto> produto = produtoService.buscaPorId(id);

		if (produto.isPresent()) 
			return new ItemDePedido(quantidade, produto.get());
		
		return null;

	}

}
