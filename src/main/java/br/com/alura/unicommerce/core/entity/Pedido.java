package br.com.alura.unicommerce.core.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    
	@Column(name = "data", nullable = false)
    private LocalDate data;
    
	@ManyToOne(optional = false)
    private Cliente cliente;
    
	@Column(name = "desconto", nullable = false, scale = 2)
    private BigDecimal desconto;
    
	@Column(name = "tipo_desconto", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDescontoPedido tipoDesconto;
    
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemDePedido> itemPedidos = new ArrayList<>();
    
	@Transient
    private BigDecimal total;
    
	@Transient
    private BigDecimal descontosDeItens;
    
	@Transient
    private Long quantidadeDeItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public TipoDescontoPedido getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(TipoDescontoPedido tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public List<ItemDePedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(List<ItemDePedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getDescontosDeItens() {
		return descontosDeItens;
	}

	public void setDescontosDeItens(BigDecimal descontosDeItens) {
		this.descontosDeItens = descontosDeItens;
	}

	public Long getQuantidadeDeItems() {
		return quantidadeDeItems;
	}

	public void setQuantidadeDeItems(Long quantidadeDeItems) {
		this.quantidadeDeItems = quantidadeDeItems;
	}

}
