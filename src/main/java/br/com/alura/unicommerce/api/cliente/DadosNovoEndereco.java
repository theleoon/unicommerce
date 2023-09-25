package br.com.alura.unicommerce.api.cliente;

import br.com.alura.unicommerce.core.entity.Endereco;

public record DadosNovoEndereco(String rua, Integer numero, String complemento, String bairro, String cidade, String estado) {
	
	public Endereco toEntity() {
		return new Endereco(rua, numero, complemento, bairro, cidade, estado);
	}
	
}
