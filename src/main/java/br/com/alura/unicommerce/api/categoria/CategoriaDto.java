package br.com.alura.unicommerce.api.categoria;

import br.com.alura.unicommerce.core.entity.Categoria;

public class CategoriaDto {
	
    private Long id;
    private Boolean status;
    private String nome;

    public CategoriaDto(Categoria categoria) {
        this.status = categoria.isStatus();
        this.nome = categoria.getNome();
        this.id = categoria.getId();
    }
    
    public Boolean getStatus() {
		return status;
	}

	public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}
