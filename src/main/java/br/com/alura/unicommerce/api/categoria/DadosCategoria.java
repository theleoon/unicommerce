package br.com.alura.unicommerce.api.categoria;

import br.com.alura.unicommerce.core.entity.Categoria;

public record DadosCategoria(Long id, Boolean status, String nome) {

    public DadosCategoria(Categoria categoria) {
    	this(categoria.getId(), categoria.isStatus(), categoria.getNome());
    }
    
//    public DadosCategoria(Long id, Boolean status, String nome) {
//    	this.nome = nome;
//    	this.status = status;
//    	this.id = id;
//    }

}
