package br.com.alura.unicommerce.api.produto;

import java.math.BigDecimal;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import br.com.alura.unicommerce.api.categoria.service.CategoriaService;
import br.com.alura.unicommerce.core.entity.Produto;

public class ProdutoRequestDto {

    @Length(min = 2)
    private String nome;

    @Positive
    private BigDecimal preco;
    
    private String descricao;
    
    private int estoque;
    
    private Long categoriaId;

    public ProdutoRequestDto(String nome, BigDecimal preco, String descricao, int estoque, Long categoriaId) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
        this.categoriaId = categoriaId;
    }

    public ProdutoRequestDto() {}

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidadeEmEstoque() {
		return estoque;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getIdCategoria() {
        return categoriaId;
    }

    public Produto converter(CategoriaService categoriaService) {
        return new Produto(preco, nome, descricao, estoque, categoriaService.buscaPorId(categoriaId).get());
    }

	@Override
	public String toString() {
		return "ProdutoForm [nome=" + nome + ", preco=" + preco + ", descricao=" + descricao + ", estoque="
				+ estoque + ", categoriaId=" + categoriaId + "]";
	}

}
