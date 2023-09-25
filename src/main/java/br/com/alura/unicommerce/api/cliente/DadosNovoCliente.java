package br.com.alura.unicommerce.api.cliente;

import br.com.alura.unicommerce.core.entity.Cliente;

public record DadosNovoCliente(String nome, String cpf, String telefone, DadosNovoEndereco endereco) {

	public Cliente toEntity() {
		return new Cliente(nome, cpf, telefone, endereco.toEntity());
	}

}
