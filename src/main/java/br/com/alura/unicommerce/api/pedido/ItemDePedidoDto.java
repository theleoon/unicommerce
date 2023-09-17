package br.com.alura.unicommerce.api.pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.unicommerce.api.categoria.CategoriaDto;
import br.com.alura.unicommerce.api.produto.ProdutoDto;
import br.com.alura.unicommerce.core.entity.ItemDePedido;

public class ItemDePedidoDto {
	
	private Long id;
	private ProdutoDto produto;
	private CategoriaDto categoria;
	private Long quantidade;
	private BigDecimal precoUnitario;
	private BigDecimal valor;
	private BigDecimal desconto;

	public ItemDePedidoDto(ItemDePedido item) {
        this.id = item.getProduto().getId();
        this.produto = new ProdutoDto(item.getProduto());
        this.categoria = new CategoriaDto(item.getProduto().getCategoria());
        this.quantidade = item.getQuantidade();
        this.precoUnitario = item.getPrecoUnitario();
        this.valor = item.getTotal();
        this.desconto = item.getDesconto();
    }

	public Long getId() {
		return id;
	}

	public ProdutoDto getProduto() {
		return produto;
	}

	public CategoriaDto getCategoria() {
		return categoria;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public static List<ItemDePedidoDto> converter(List<ItemDePedido> itens) {
		return itens.stream().map(ItemDePedidoDto::new).collect(Collectors.toList());
	}
}
