package br.com.alura.unicommerce.core.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "preco", nullable = false)
	private BigDecimal preco;

	@Column(name = "nome", length = 160)
	private String nome;

	@Column(name = "descricao", length = 160)
	private String descricao;

	@Column(name = "quantidade_estoque", nullable = false)
	private Integer quantidadeEmEstoque;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;

	public Produto() {
	}
	
	public Produto(BigDecimal preco, String nome, String descricao, Integer quantidadeEmEstoque, Categoria categoria) {
		super();
		this.preco = preco;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
