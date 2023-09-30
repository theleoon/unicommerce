package br.com.alura.unicommerce.api.pedido;

import java.util.Optional;

import br.com.alura.unicommerce.api.produto.service.ProdutoService;
import br.com.alura.unicommerce.core.entity.ItemDePedido;
import br.com.alura.unicommerce.core.entity.Produto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosDeProduto(@NotNull Long id, @Positive Long quantidade) {

	public ItemDePedido converter(ProdutoService produtoService) {

		Optional<Produto> produto = produtoService.buscaPorId(id);

		if (produto.isPresent()) 
			return new ItemDePedido(quantidade, produto.get());
		
		return null;

	}

}
