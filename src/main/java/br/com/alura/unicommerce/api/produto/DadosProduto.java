package br.com.alura.unicommerce.api.produto;

import java.math.BigDecimal;

import br.com.alura.unicommerce.api.categoria.DadosCategoria;
import br.com.alura.unicommerce.core.entity.Produto;

public record DadosProduto(Long id, String nome, BigDecimal preco, String descricao, int qntEmEstoque,
		DadosCategoria categoria) {

	public DadosProduto(Produto obj) {
		this(obj.getId(), 
				obj.getNome(), 
				obj.getPreco(), 
				obj.getDescricao(), 
				obj.getQuantidadeEmEstoque(), 
				new DadosCategoria(obj.getCategoria()));
	}

}
