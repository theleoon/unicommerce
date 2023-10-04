package br.com.alura.unicommerce.core.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
	@Column(name = "data", nullable = false)
    private LocalDate data = LocalDate.now();
    
	@ManyToOne(optional = false)
    private Cliente cliente;
    
	@Column(name = "desconto", nullable = false, scale = 2)
    private BigDecimal desconto = BigDecimal.ZERO;
    
	@Column(name = "tipo_desconto", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDescontoPedido tipoDesconto = TipoDescontoPedido.NENHUM;
    
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemDePedido> itemPedidos = new ArrayList<>();
	
	public Pedido(Cliente cliente, List<ItemDePedido> itemPedidos) {
		this.cliente = cliente;
		adicionaItens(itemPedidos);
	}
	
	public Pedido() {
	}

	public void adicionaItens(List<ItemDePedido> itemPedidos) {
		for (ItemDePedido item : itemPedidos) {
			this.adicionaItem(item);
		}
	}

	public void adicionaItem(ItemDePedido item) {
		item.setPedido(this);
		itemPedidos.add(item);
	}

	public BigDecimal getDesconto() {
		this.desconto = tipoDesconto.getTotalDeDesconto(getTotalBruto());
		return this.desconto;
	}

	public BigDecimal getTotalLiquido() {
		BigDecimal total = getTotalDeItens();
		return total.subtract(this.desconto);
	}
	
	public BigDecimal getTotalBruto() {
		BigDecimal total = getTotalDeItens();
		return total;
	}

	public BigDecimal getTotalDeItens() {
		BigDecimal total = BigDecimal.ZERO;
		
		for (ItemDePedido item : itemPedidos) {
			total = total.add(item.getTotal());
		}
		return total;
	}

	public void aplicaPoliticaDeDesconto(Integer quantidadeDePedidos) {
		if (quantidadeDePedidos > 5) {
			this.tipoDesconto = TipoDescontoPedido.QUANTIDADE;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public TipoDescontoPedido getTipoDesconto() {
		return tipoDesconto;
	}

	public List<ItemDePedido> getItemPedidos() {
		return itemPedidos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", cliente=" + cliente + ", desconto=" + desconto
				+ ", tipoDesconto=" + tipoDesconto + ", itemPedidos=" + itemPedidos + "]";
	}
}
