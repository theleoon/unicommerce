package br.com.alura.unicommerce.api.categoria;

import br.com.alura.unicommerce.core.entity.Categoria;

public record DadosCategoria(Long id, Boolean ativo, String nome) {

    public DadosCategoria(Categoria categoria) {
    	this(categoria.getId(), categoria.isStatus(), categoria.getNome());
    }

}
