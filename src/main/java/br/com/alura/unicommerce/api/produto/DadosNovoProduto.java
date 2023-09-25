package br.com.alura.unicommerce.api.produto;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import br.com.alura.unicommerce.api.categoria.service.CategoriaService;
import br.com.alura.unicommerce.core.entity.Produto;

public record DadosNovoProduto(@Length(min = 2) String nome, 
		@Positive BigDecimal preco, 
		String descricao, 
		@Positive Integer estoque, 
		@Positive Long categoriaId) {

    public Optional<Produto> toEntity(CategoriaService categoriaService) {
		return Optional
				.ofNullable(new Produto(preco, 
						nome, 
						descricao, 
						estoque, 
						categoriaService.buscaPorId(categoriaId).get()));
    }

}
