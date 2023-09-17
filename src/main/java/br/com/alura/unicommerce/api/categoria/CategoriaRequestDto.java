package br.com.alura.unicommerce.api.categoria;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.unicommerce.core.entity.Categoria;

public class CategoriaRequestDto {

	@NotEmpty
    @NotNull
    @Length(min = 2)
    private String nome;

    public CategoriaRequestDto(String nome) {
        this.nome = nome;
    }
    
    public CategoriaRequestDto() {
    }
    
    public void setNome(String nome) {
		this.nome = nome;
	}

    public String getNome() {
        return nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }

	@Override
	public String toString() {
		return "CategoriaForm [nome=" + nome + "]";
	}
    
    
}

