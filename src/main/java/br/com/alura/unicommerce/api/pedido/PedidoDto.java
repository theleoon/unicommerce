package br.com.alura.unicommerce.api.pedido;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.unicommerce.core.entity.Pedido;
import br.com.alura.unicommerce.core.entity.TipoDescontoPedido;

public class PedidoDto {
	
	private Long id;
    private Long idCliente;
    private BigDecimal desconto;
    private TipoDescontoPedido tipoDesconto;
    private List<ItemDePedidoDto> itens;

    public PedidoDto(Pedido obj) {
        this.id = obj.getId();
        this.idCliente = obj.getCliente().getId();
        this.desconto = obj.getDesconto();
        this.tipoDesconto = obj.getTipoDesconto();
        this.itens = ItemDePedidoDto.converter(obj.getItemPedidos());
    }

	public Long getId() {
		return id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public TipoDescontoPedido getTipoDesconto() {
		return tipoDesconto;
	}

	public List<ItemDePedidoDto> getItens() {
		return itens;
	}

}
