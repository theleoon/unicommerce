package br.com.alura.unicommerce.core.entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "item_pedido")
public class ItemDePedido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
	@Column(name = "preco_unitario", scale = 2, nullable = false)
    private BigDecimal precoUnitario;
    
	@Column(name = "quantidade", nullable = false)
    private Long quantidade;
    
	@ManyToOne(optional = false, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Pedido pedido;
    
	@ManyToOne(optional = false)
    private Produto produto;
    
	@Column(name = "desconto", scale = 2, nullable = false)
    private BigDecimal desconto;
    
	@Enumerated(EnumType.STRING)
    @Column(name = "tipo_desconto", nullable = false)
    private TipoDescontoItemPedido tipoDesconto;
    
	@Transient
    private BigDecimal total = BigDecimal.ZERO;

	public ItemDePedido() {
	}

	public ItemDePedido(Long quantidade, Produto produto) {
		this.quantidade = quantidade;
		this.produto = produto;
		this.desconto = BigDecimal.ZERO;
		this.tipoDesconto = TipoDescontoItemPedido.NENHUM;
		this.precoUnitario = produto.getPreco();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public TipoDescontoItemPedido getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(TipoDescontoItemPedido tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public BigDecimal getTotal() {
		return this.produto.getPreco().multiply(new BigDecimal(this.quantidade));
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	

}
