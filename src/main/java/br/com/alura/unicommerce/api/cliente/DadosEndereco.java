package br.com.alura.unicommerce.api.cliente;

import br.com.alura.unicommerce.core.entity.Endereco;

public record DadosEndereco(String rua, 
		String longradouro, 
		Integer numero, 
		String complemento, 
		String bairro, 
		String cidade, 
		String estado) {
	
	
	public DadosEndereco(Endereco obj) {
		this(obj.getRua(), 
				obj.getRua(), 
				obj.getNumero(), 
				obj.getComplemento(), 
				obj.getBairro(), 
				obj.getCidade(), 
				obj.getEstadoUF());
	}

}
