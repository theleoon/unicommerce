package br.com.alura.unicommerce.api.cliente;

import br.com.alura.unicommerce.api.usuario.DadosUsuario;
import br.com.alura.unicommerce.core.entity.Cliente;

public record DadosCliente(Long id, String nome, String cpf, String telefone, DadosEndereco endereco, DadosUsuario usuario) {
	
	public DadosCliente(Cliente obj) {
		this(obj.getId(), 
				obj.getNome(), 
				obj.getCpf(), 
				obj.getTelefone(), 
				new DadosEndereco(obj.getEndereco()),
				new DadosUsuario(obj.getUsuario()));
	}

}
