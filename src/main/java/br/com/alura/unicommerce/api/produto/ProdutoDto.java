package br.com.alura.unicommerce.api.produto;

import java.math.BigDecimal;

import br.com.alura.unicommerce.api.categoria.CategoriaDto;
import br.com.alura.unicommerce.core.entity.Produto;

public class ProdutoDto {

	private Long id;
	private String nome;
	private BigDecimal preco;
	private String descricao;
	private int qntEmEstoque;
	private CategoriaDto categoria;

	public ProdutoDto(Produto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.preco = obj.getPreco();
		this.descricao = obj.getDescricao();
		this.qntEmEstoque = obj.getQuantidadeEmEstoque();
		this.categoria = new CategoriaDto(obj.getCategoria());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getQntEmEstoque() {
		return qntEmEstoque;
	}

	public CategoriaDto getCategoria() {
		return categoria;
	}

}
