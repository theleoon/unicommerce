package br.com.alura.unicommerce.api.categoria;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.unicommerce.core.entity.Categoria;

public record DadosNovaCategoria(@NotEmpty @NotNull @Length(min = 2) String nome) {
	
	public Categoria toEntity() {
		return new Categoria(this.nome);
	}

}

